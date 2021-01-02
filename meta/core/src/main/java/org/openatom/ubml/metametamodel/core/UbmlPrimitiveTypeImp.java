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
import org.openatom.ubml.metametamodel.api.UbmlPrimitiveType;
import org.openatom.ubml.metametamodel.api.UbmlPrimitiveTypeKind;
import org.openatom.ubml.metametamodel.api.UbmlTypeKind;

/**
 * The type AbstractUbmlPrimitiveType
 *
 * @author: Jack Lee
 */
public final class UbmlPrimitiveTypeImp extends UbmlTypeImp implements UbmlPrimitiveType {

    private UbmlPrimitiveTypeKind primitiveTypeKind;

    public UbmlPrimitiveTypeImp(FullQualifiedName typeName,
        String alias, UbmlPrimitiveTypeKind primitiveTypeKind) {
        super(typeName, UbmlTypeKind.Primitive, alias);
        this.primitiveTypeKind = primitiveTypeKind;
    }

    @Override public UbmlPrimitiveTypeKind getPrimitiveKind() {
        return primitiveTypeKind;
    }

    @Override public String getKind() {
        return "UbmlPrimitiveTypeImp";
    }
}