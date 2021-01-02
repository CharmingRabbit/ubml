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
package org.openatom.ubml.metametamodel.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of all primitive type kinds.
 */
public enum UbmlPrimitiveTypeKind {

    Binary,
    Boolean,
    Byte,
    Date,
    DateTime,
    Decimal,
    Double,
    Int16,
    Int32,
    Int64,
    String;

    private static Map<String, UbmlPrimitiveTypeKind> VALUES_BY_NAME;

    static {
        Map<String, UbmlPrimitiveTypeKind> valuesByName = new HashMap<java.lang.String, UbmlPrimitiveTypeKind>();
        for (UbmlPrimitiveTypeKind value : values()) {
            valuesByName.put(value.name(), value);
        }
        VALUES_BY_NAME = Collections.unmodifiableMap(valuesByName);
    }

    /**
     * Get a type kind by name.
     *
     * @param name The name.
     * @return The type kind or <tt>null</tt> if it does not exist.
     */
    public static UbmlPrimitiveTypeKind getByName(String name) {
        return VALUES_BY_NAME.get(name);
    }

}
