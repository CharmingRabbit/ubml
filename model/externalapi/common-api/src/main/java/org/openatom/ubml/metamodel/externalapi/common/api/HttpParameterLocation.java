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

package org.openatom.ubml.metamodel.externalapi.common.api;

/**
 * The type HttpParameterLocation
 *
 * @author: haozhibei
 */
public enum HttpParameterLocation {
    /**
     * QUERY
     */
    QUERY,
    /**
     * PATH
     */
    PATH,
    /**
     * HEADER
     */
    HEADER,
    /**
     * COOKIE
     */
    COOKIE;

    public static HttpParameterLocation getHttpParameterLocation(String paramLocationStr) {
        for (HttpParameterLocation location : values()) {
            if (location.name().equalsIgnoreCase(paramLocationStr)) {
                return location;
            }
        }
        throw new IllegalArgumentException("illegal kind:" + paramLocationStr);
    }
}
