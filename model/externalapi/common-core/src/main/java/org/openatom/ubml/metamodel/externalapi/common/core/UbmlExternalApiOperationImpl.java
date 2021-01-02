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

package org.openatom.ubml.metamodel.externalapi.common.core;

import org.openatom.ubml.common.loader.LoadLevel;
import org.openatom.ubml.metametamodel.core.AbstractUbmlOperation;
import org.openatom.ubml.metamodel.externalapi.common.api.HttpMethod;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiOperation;

/**
 * The type UbmlExternalApiOperationImpl
 *
 * @author: haozhibei
 */
@LoadLevel(name = UbmlExternalApiOperationImpl.UBML_EXTERNAL_API_OPERATION_KIND)
public class UbmlExternalApiOperationImpl extends AbstractUbmlOperation implements UbmlExternalApiOperation {

    public static final String UBML_EXTERNAL_API_OPERATION_KIND = "DefaultUbmlExternalApiOperation";

    private HttpMethod httpMethod;

    private String httpPath;

    private String providerOperationID;


    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    public void setProviderOperationID(String providerOperationID) {
        this.providerOperationID = providerOperationID;
    }


    @Override
    public String getKind() {
        return UBML_EXTERNAL_API_OPERATION_KIND;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    @Override
    public String getHttpPath() {
        return httpPath;
    }

    @Override
    public String getProviderOperationID() {
        return providerOperationID;
    }

}
