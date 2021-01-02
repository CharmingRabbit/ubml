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

package org.openatom.ubml.metametamodel.core;

import org.openatom.ubml.metametamodel.api.UbmlProperty;
import org.openatom.ubml.metametamodel.api.UbmlTypeReference;

/**
 * The type UbmlPropertyImp
 *
 * @author: Jack Lee
 */
public class UbmlPropertyImp extends AbstractUbmlNamedObject implements UbmlProperty {

    private String defaultValue;
    private UbmlTypeReference typeReference;

    @Override public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override public UbmlTypeReference getType() {
        return typeReference;
    }

    public void SetType(UbmlTypeReference typeReference) {
        this.typeReference = typeReference;
    }

    @Override public String getKind() {
        return "UbmlPropertyImp";
    }
}