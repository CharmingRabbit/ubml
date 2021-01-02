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
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiProvider;
import org.openatom.ubml.metamodel.commonpart.core.AbstractUbmlProvider;

/**
 * The type UbmlExternalApiProvider
 *
 * @author: haozhibei
 */
@LoadLevel(name = UbmlExternalApiProviderImpl.UBML_EXTERNAL_API_PROVIDER_KIND)
public class UbmlExternalApiProviderImpl extends AbstractUbmlProvider implements UbmlExternalApiProvider {

    public static final String UBML_EXTERNAL_API_PROVIDER_KIND = "DefaultUbmlExternalApiProvider";

    private String alias;


    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getKind() {
        return UBML_EXTERNAL_API_PROVIDER_KIND;
    }

    @Override
    public String getAlias() {
        return alias;
    }
}
