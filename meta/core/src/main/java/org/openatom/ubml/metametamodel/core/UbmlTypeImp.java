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

import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.api.UbmlType;
import org.openatom.ubml.metametamodel.api.UbmlTypeKind;

/**
 * The type AbstractUbmlType
 *
 * @author: Jack Lee
 */
public class UbmlTypeImp extends AbstractUbmlNamedObject implements UbmlType {

    protected final FullQualifiedName typeName;
    protected final UbmlTypeKind typeKind;

    protected String alias;

    public UbmlTypeImp(FullQualifiedName typeName, UbmlTypeKind typeKind, String alias) {
        this.typeName = typeName;
        this.typeKind = typeKind;
        this.alias = alias;

    }

    @Override
    public UbmlTypeKind getTypeKind() {
        return typeKind;
    }

    @Override public String getID() {
        return typeName.getFullQualifiedNameAsString();
    }

    @Override public String getAlias() {
        return alias;
    }

    @Override public String getName() {
        return typeName.getName();
    }

    @Override public String getKind() {
        return "UbmlTypeImp";
    }

}