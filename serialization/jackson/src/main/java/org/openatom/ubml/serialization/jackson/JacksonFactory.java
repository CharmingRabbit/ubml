/*
 *  Copyright 1999-2020 org.openatom.ubml Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openatom.ubml.serialization.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.openatom.ubml.common.util.ReflectionUtils;
import org.openatom.ubml.metametamodel.api.UbmlObject;
import org.openatom.ubml.serialization.api.support.PolymorphicClassRegistry;
import org.openatom.ubml.serialization.api.support.SerializerClassRegistry;

/**
 * The type JacksonFactory
 *
 * @author: haozhibei
 */
public class JacksonFactory {

    private static ObjectMapper MAPPER = new ObjectMapper();

    private static SimpleModule MODULE = new SimpleModule();

    private static JacksonFactory INSTANCE = new JacksonFactory();

    public static JacksonFactory getInstance() {
        return INSTANCE;
    }

    private JacksonFactory() {
        // ignore unrecognized fields.
        MAPPER.configure(Feature.IGNORE_UNKNOWN, true);
        // allow to execute normally while encountering an unrecognized attribute
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // ignore field case.
        MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        // allow JSON strings to contain non JSON standard control characters.
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        TypeResolverBuilder<?> typeResolver = new UbmlJacksonTypeResolverBuilder();
        typeResolver.init(JsonTypeInfo.Id.NAME, null);
        typeResolver.inclusion(JsonTypeInfo.As.EXISTING_PROPERTY);
        typeResolver.typeProperty("kind");
        MAPPER.setDefaultTyping(typeResolver);


        //register custom serializer
        SerializerClassRegistry.getRegisteredSerializers().forEach((clazz, serializer) -> {
            MODULE.addSerializer(clazz, (JsonSerializer)serializer);
        });

        //register custom deserializer
        SerializerClassRegistry.getRegisteredDeserializers().forEach((clazz, deserializer) -> {
            MODULE.addDeserializer(clazz, (JsonDeserializer)deserializer);
        });
        MAPPER.registerModule(MODULE);
    }

    public ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    static class UbmlJacksonTypeResolverBuilder extends DefaultTypeResolverBuilder {

        public UbmlJacksonTypeResolverBuilder() {
            super(DefaultTyping.NON_FINAL);
        }

        @Override
        public boolean useForType(JavaType t) {
            Class<?> clazz = t.getRawClass();
            if (ReflectionUtils.isOrInheritingOrImplementing(clazz, UbmlObject.class)) {
                return true;
            }
            return false;
        }

        @Override
        public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            Class<?> baseClass = baseType.getRawClass();
            if (ReflectionUtils.isOrInheritingOrImplementing(baseClass, UbmlObject.class)) {
                Map<Class<?>, String> groupedByBaseClasses = PolymorphicClassRegistry.getGroupedRegisteredClasses().get(baseClass);
                if (subtypes == null) {
                    subtypes = new LinkedHashSet<>();
                }
                if (groupedByBaseClasses == null) {
                    synchronized (baseClass) {
                        groupedByBaseClasses = PolymorphicClassRegistry.getGroupedRegisteredClasses().get(baseClass);
                        if (groupedByBaseClasses == null) {
                            AtomicReference<Collection<NamedType>> subTypesRefer = new AtomicReference(subtypes);
                            groupedByBaseClasses = getGroupedClasses(baseClass, subTypesRefer);
                            PolymorphicClassRegistry.getGroupedRegisteredClasses().put(baseClass, groupedByBaseClasses);
                            subtypes = subTypesRefer.get();
                        }
                    }
                } else {
                    Collection<NamedType> finalSubtypes = subtypes;
                    groupedByBaseClasses.forEach((clazz, kind) -> {
                        NamedType namedType = new NamedType(clazz, kind);
                        finalSubtypes.add(namedType);
                    });
                }
            }
            return useForType(baseType) ? super.buildTypeDeserializer(config, baseType, subtypes) : null;
        }

        @Override
        public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            Class<?> baseClass = baseType.getRawClass();
            if (ReflectionUtils.isOrInheritingOrImplementing(baseClass, UbmlObject.class)) {
                Map<Class<?>, String> groupedByBaseClasses = PolymorphicClassRegistry.getGroupedRegisteredClasses().get(baseClass);
                if (subtypes == null) {
                    subtypes = new LinkedHashSet<>();
                }
                if (groupedByBaseClasses == null) {
                    synchronized (baseClass) {
                        groupedByBaseClasses = PolymorphicClassRegistry.getGroupedRegisteredClasses().get(baseClass);
                        if (groupedByBaseClasses == null) {
                            AtomicReference<Collection<NamedType>> subTypesRefer = new AtomicReference(subtypes);
                            groupedByBaseClasses = getGroupedClasses(baseClass, subTypesRefer);
                            PolymorphicClassRegistry.getGroupedRegisteredClasses().put(baseClass, groupedByBaseClasses);
                            subtypes = subTypesRefer.get();
                        }
                    }
                } else {
                    Collection<NamedType> finalSubtypes = subtypes;
                    groupedByBaseClasses.forEach((clazz, kind) -> {
                        NamedType namedType = new NamedType(clazz, kind);
                        finalSubtypes.add(namedType);
                    });
                }
            }
            return useForType(baseType) ? super.buildTypeSerializer(config, baseType, subtypes) : null;
        }

        private Map<Class<?>, String> getGroupedClasses(Class<?> baseClass, AtomicReference<Collection<NamedType>> subTypesRefer) {
            Collection<NamedType> subTypes = subTypesRefer.get();
            Map<Class<?>, String> result = new HashMap<>();
            PolymorphicClassRegistry.getRegisteredClasses().forEach((concreteClass, kind) -> {
                if (ReflectionUtils.classIsInheritingOrImplementing(concreteClass, baseClass)) {
                    result.put(concreteClass, kind);
                    NamedType namedType = new NamedType(concreteClass, kind);
                    subTypes.add(namedType);
                }
            });
            return result;
        }

    }
}
