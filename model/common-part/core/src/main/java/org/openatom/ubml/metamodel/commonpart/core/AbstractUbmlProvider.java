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

package org.openatom.ubml.metamodel.commonpart.core;

import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.core.AbstractUbmlNamedObject;
import org.openatom.ubml.metamodel.commonpart.api.UbmlProvider;

/**
 * The type AbstractUbmlProvider
 *
 * @author: haozhibei
 */
public abstract class AbstractUbmlProvider extends AbstractUbmlNamedObject implements UbmlProvider {

    protected String id;
    protected FullQualifiedName fullQualifiedName;
    protected String providerType;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public FullQualifiedName getFullQualifiedName() {
        return this.fullQualifiedName;
    }

    @Override
    public String getProviderType() {
        return this.providerType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullQualifiedName(FullQualifiedName fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }


}
