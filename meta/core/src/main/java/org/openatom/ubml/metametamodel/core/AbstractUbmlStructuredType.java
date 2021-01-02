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
import org.openatom.ubml.metametamodel.api.UbmlProperty;
import org.openatom.ubml.metametamodel.api.UbmlStructuredType;
import org.openatom.ubml.metametamodel.api.UbmlTypeKind;

/**
 * The type AbstractUbmlStructuredType
 *
 * @author: Jack Lee
 */
public abstract class AbstractUbmlStructuredType extends UbmlTypeImp implements UbmlStructuredType {

    protected FullQualifiedName typeName;

    private List<String> propertyNames;

    private Map<String, UbmlProperty> propertiesMap;

    public AbstractUbmlStructuredType(FullQualifiedName typeName,
        UbmlTypeKind typeKind, String alias) {
        super(typeName, typeKind, alias);
    }

    @Override public FullQualifiedName getFullQualifiedName() {
        return typeName;
    }

    @Override public UbmlProperty getProperty(String name) {
        if (propertiesMap == null) {
            return null;
        } else {
            return propertiesMap.get(name);
        }
    }

    @Override public List<UbmlProperty> getDeclaredProperties() {
        if (propertiesMap == null) {
            return null;
        } else {
            Collection<UbmlProperty> valueCollection = propertiesMap.values();
            List<UbmlProperty> valueList = new ArrayList<UbmlProperty>(valueCollection);
            return valueList;
        }
    }

    public AbstractUbmlStructuredType addProperty(String name, UbmlProperty property) {
        if (propertiesMap == null) {
            propertiesMap = new LinkedHashMap<String, UbmlProperty>();
        }
        propertiesMap.put(name, property);
        return this;
    }

    /**
     * Concrete kind
     *
     * @return kind
     */
    @Override public abstract String getKind();
}