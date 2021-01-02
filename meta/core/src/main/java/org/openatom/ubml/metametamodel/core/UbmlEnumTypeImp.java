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
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.api.UbmlEnumMember;
import org.openatom.ubml.metametamodel.api.UbmlEnumType;
import org.openatom.ubml.metametamodel.api.UbmlPrimitiveType;
import org.openatom.ubml.metametamodel.api.UbmlTypeKind;

/**
 * The type UbmlEnumTypeImp
 *
 * @author: Jack Lee
 */
public class UbmlEnumTypeImp extends UbmlTypeImp implements UbmlEnumType {

    private UbmlPrimitiveType underlyingType;
    private Map<String, UbmlEnumMember> membersMap;

    public UbmlEnumTypeImp(FullQualifiedName typeName,
        UbmlPrimitiveType underlyingType, String alias) {
        super(typeName, UbmlTypeKind.Enum, alias);
    }

    @Override public UbmlEnumMember getMember(String name) {
        if (membersMap == null) {
            return null;
        } else {
            return membersMap.get(name);
        }
    }

    @Override public List<UbmlEnumMember> getMembers() {
        if (membersMap == null) {
            return null;
        } else {
            Collection<UbmlEnumMember> valueCollection = membersMap.values();
            List<UbmlEnumMember> valueList = new ArrayList<UbmlEnumMember>(valueCollection);
            return valueList;
        }
    }

    public UbmlEnumTypeImp addMember(String name, UbmlEnumMember enumMember) {
        if (membersMap == null) {
            membersMap = new LinkedHashMap<String, UbmlEnumMember>();
            membersMap.put(name, enumMember);
        } else {
            membersMap.put(name, enumMember);
        }
        return this;
    }

    @Override public UbmlPrimitiveType getUnderlyingType() {
        return underlyingType;
    }

    @Override public String getKind() {
        return "UbmlEnumTypeImp";
    }

    @Override
    public int hashCode() {
        return getID().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj != null
            && (obj == this
            || obj instanceof UbmlEnumType
            && getID().equals(((UbmlEnumType) obj).getID()));
    }
}