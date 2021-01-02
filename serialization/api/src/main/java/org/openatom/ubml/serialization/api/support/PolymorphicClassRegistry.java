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
import org.openatom.ubml.common.loader.EnhancedServiceLoader;
import org.openatom.ubml.common.loader.ExtensionURL;
import org.openatom.ubml.metametamodel.api.UbmlObject;

/**
 * The type PolymorphicClassRegistry
 *
 * @author: haozhibei
 */
public class PolymorphicClassRegistry {

    private static final Map<Class<?>/* extension point class */, Map<Class<?>/* extension impl class */,
            String /* extension impl kind */>> REGISTRATIONS_GROUPED = new LinkedHashMap<>();
    private static final Map<Class<?>/* extension impl class */, String/* extension impl kind */> REGISTRATIONS =
            new LinkedHashMap<>();

    static {
        Map<ExtensionURL, Class<?>> allExtensionMap = EnhancedServiceLoader.getServiceLoader(UbmlObject.class).getAllExtensionClassWithKey();
        if (!allExtensionMap.isEmpty()) {
            for (Map.Entry entry : allExtensionMap.entrySet()) {
                String objectKind = ((ExtensionURL)entry.getKey()).getName();
                Class<?> objectClass = (Class<?>)entry.getValue();
                registerClass(objectClass, objectKind);
            }
        }
    }

    /**
     * only supposed to be called at startup time
     *
     * @param clazz      object type
     * @param objectKind class kind string
     */
    public static void registerClass(Class<?> clazz, String objectKind) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class registered cannot be null!");
        }
        REGISTRATIONS.put(clazz, objectKind);
    }

    /**
     * get registered classes
     *
     * @return class serializer
     */
    public static Map<Class<?>, String> getRegisteredClasses() {
        return REGISTRATIONS;
    }

    /**
     * get grouped registered classes
     *
     * @return class serializer
     */
    public static Map<Class<?>, Map<Class<?>, String>> getGroupedRegisteredClasses() {
        return REGISTRATIONS_GROUPED;
    }
}
