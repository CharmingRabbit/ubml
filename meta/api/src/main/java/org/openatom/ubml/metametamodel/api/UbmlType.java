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

/**
 * The type UbmlType
 *
 * @author: haozhibei
 */
public interface UbmlType extends UbmlNamedObject {

    /**
     * Get the kind of the UBML type
     *
     * @return {@link UbmlTypeKind} of the UBML type
     */
    UbmlTypeKind getTypeKind();

    /**
     * Get the identifier of the UBML type
     *
     * @return the identifier string.
     */
    String getID();

    /**
     * Get the alias of the UBML type
     *
     * @return the alias string
     */
    String getAlias();
}
