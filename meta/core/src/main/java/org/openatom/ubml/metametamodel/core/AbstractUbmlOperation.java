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

import java.util.List;
import java.util.stream.Collectors;
import org.openatom.ubml.common.util.CollectionUtils;
import org.openatom.ubml.common.util.StringUtils;
import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.api.UbmlOperation;
import org.openatom.ubml.metametamodel.api.UbmlParameter;
import org.openatom.ubml.metametamodel.api.UbmlTypeReference;

/**
 * The type AbstractUbmlOperation
 *
 * @author: haozhibei
 */
public abstract class AbstractUbmlOperation extends AbstractUbmlNamedObject implements UbmlOperation {

    protected String id;

    protected String alias;

    protected FullQualifiedName fullQualifiedName;

    protected List<UbmlParameter> parameters;

    protected UbmlTypeReference returnType;

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public FullQualifiedName getFullQualifiedName() {
        return fullQualifiedName;
    }

    @Override
    public List<UbmlParameter> getParameters() {
        return parameters;
    }

    @Override
    public UbmlTypeReference getReturnType() {
        return returnType;
    }

    @Override
    public UbmlParameter getParameter(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("name is empty or null!");
        }
        if (CollectionUtils.isEmpty(parameters)) {
            return null;
        }
        List<UbmlParameter> result = parameters.stream().filter(p -> name.equals(p.getName())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFullQualifiedName(FullQualifiedName fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }

    public void setParameters(List<UbmlParameter> parameters) {
        this.parameters = parameters;
    }

    public void setReturnType(UbmlTypeReference returnType) {
        this.returnType = returnType;
    }


}
