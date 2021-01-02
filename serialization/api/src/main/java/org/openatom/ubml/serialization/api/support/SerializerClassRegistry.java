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

package org.openatom.ubml.serialization.api.support;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provide a unified serialization registry, this class used for {@code ubml-serialization-jsckson},
 * it will register some classes at startup time
 *
 * @author haozhibei
 */
public class SerializerClassRegistry {

    private static final Map<Class<?>, Object> SERIALIZER_REGISTRATIONS = new LinkedHashMap<>();

    private static final Map<Class<?>, Object> DESERIALIZER_REGISTRATIONS = new LinkedHashMap<>();

    /**
     * only supposed to be called at startup time
     *
     * @param clazz      object type
     * @param serializer object serializer
     */
    public static void registerSerializer(Class<?> clazz, Object serializer) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class registered cannot be null!");
        }
        SERIALIZER_REGISTRATIONS.put(clazz, serializer);
    }

    /**
     * only supposed to be called at startup time
     *
     * @param clazz        object type
     * @param deserializer object deserializer
     */
    public static void registerDeserializer(Class<?> clazz, Object deserializer) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class registered cannot be null!");
        }
        DESERIALIZER_REGISTRATIONS.put(clazz, deserializer);
    }

    /**
     * get registered serializers
     *
     * @return class serializer
     */
    public static Map<Class<?>, Object> getRegisteredSerializers() {
        return SERIALIZER_REGISTRATIONS;
    }

    /**
     * get registered deserializers
     *
     * @return class deserializer
     */
    public static Map<Class<?>, Object> getRegisteredDeserializers() {
        return DESERIALIZER_REGISTRATIONS;
    }
}
