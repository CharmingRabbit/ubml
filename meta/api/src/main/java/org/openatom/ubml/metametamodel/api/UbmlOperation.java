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

import java.util.List;

/**
 * The type UbmlOperation .
 */
public interface UbmlOperation extends UbmlNamedObject {

    /**
     * Gets the ID of the operation.
     *
     * @return the ID String
     */
    String getID();

    /**
     * Gets the alias of the operation.
     *
     * @return the alias string.
     */
    String getAlias();

    /**
     * Get the full qualified name of the operation.
     *
     * @return {@link FullQualifiedName}
     */
    FullQualifiedName getFullQualifiedName();

    /**
     * Get the collection of parameters for this operation.
     *
     * @return the list of {@link UbmlParameter}
     */
    List<UbmlParameter> getParameters();

    /**
     * Get parameter for given name
     *
     * @param name name of parameter
     * @return {@link UbmlParameter} for this nampe
     */
    UbmlParameter getParameter(String name);

    /**
     * Gets the return type of this operation.
     *
     * @return {@link UbmlTypeReference} of this operation
     */
    UbmlTypeReference getReturnType();

}
