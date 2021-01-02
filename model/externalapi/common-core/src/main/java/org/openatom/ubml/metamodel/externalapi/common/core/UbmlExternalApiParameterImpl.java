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
import org.openatom.ubml.metametamodel.core.AbstractUbmlParameter;
import org.openatom.ubml.metamodel.externalapi.common.api.HttpParameterLocation;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiParameter;

/**
 * The type UbmlExternalApiParameterImpl
 *
 * @author: haozhibei
 */
@LoadLevel(name = UbmlExternalApiParameterImpl.UBML_EXTERNAL_API_PARAMETER_KIND)
public class UbmlExternalApiParameterImpl extends AbstractUbmlParameter implements UbmlExternalApiParameter {

    public static final String UBML_EXTERNAL_API_PARAMETER_KIND = "DefaultExternalApiParameter";

    private HttpParameterLocation location;

    private boolean required;

    public void setLocation(HttpParameterLocation location) {
        this.location = location;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public String getKind() {
        return UBML_EXTERNAL_API_PARAMETER_KIND;
    }

    @Override
    public HttpParameterLocation getLocation() {
        return null;
    }

    @Override
    public boolean isRequired() {
        return false;
    }
}
