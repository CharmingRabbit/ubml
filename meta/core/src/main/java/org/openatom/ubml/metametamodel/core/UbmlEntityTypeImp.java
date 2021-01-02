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

import java.util.ArrayList;
import java.util.List;
import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.api.UbmlEntityType;
import org.openatom.ubml.metametamodel.api.UbmlKeyPropertyRef;
import org.openatom.ubml.metametamodel.api.UbmlProperty;
import org.openatom.ubml.metametamodel.api.UbmlTypeKind;

/**
 * The type UbmlEntityTypeImp
 *
 * @author: Jack Lee
 */
public class UbmlEntityTypeImp extends AbstractUbmlStructuredType implements UbmlEntityType {

    private List<UbmlKeyPropertyRef> keyPropertyRefs;

    public UbmlEntityTypeImp(FullQualifiedName typeName,
        UbmlTypeKind typeKind, List<UbmlKeyPropertyRef> keys, String alias) {
        super(typeName, typeKind, alias);
        this.keyPropertyRefs = keys;
    }

    @Override public List<UbmlProperty> getDeclaredKeys() {
        List<UbmlProperty> propertyList = new ArrayList<UbmlProperty>();
        if (keyPropertyRefs == null) {
            return null;
        } else {
            for (UbmlKeyPropertyRef keyPropertyRef : keyPropertyRefs) {
                propertyList.add(keyPropertyRef.getProperty());
            }
            return propertyList;
        }
    }

    @Override public String getKind() {
        return "UbmlEntityTypeImp";
    }
}