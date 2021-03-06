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

import org.openatom.ubml.metametamodel.api.UbmlOperation;

/**
 * The type UbmlExternalApiOperation
 *
 * @author: haozhibei
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "kind")
public interface UbmlExternalApiOperation extends UbmlOperation {

    /**
     * Gets the HttpMethod.
     *
     * @return the {@link HttpMethod}.
     */
    HttpMethod getHttpMethod();

    /**
     * Gets the path of the operation.
     *
     * @return the path string.
     */
    String getHttpPath();

    /**
     * Gets the provider operation ID.
     *
     * @return the provider operation ID.
     */
    String getProviderOperationID();

}
