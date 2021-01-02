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

package org.openatom.ubml.metametamodel.core.relation;

import org.openatom.ubml.metametamodel.api.UbmlType;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociationEnd;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociationEndAggregation;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociationEndMultiplicity;
import org.openatom.ubml.metametamodel.core.AbstractUbmlObject;

/**
 * The type UbmlAssociationEnd
 *
 * @author: Jack Lee
 */
public class UbmlAssociationEndImpl extends AbstractUbmlObject implements UbmlAssociationEnd {

    private UbmlType type;
    private UbmlAssociationEndAggregation associationEndAggregation;
    private UbmlAssociationEndMultiplicity associationEndMultiplicity;

    public UbmlAssociationEndImpl(UbmlType type, UbmlAssociationEndMultiplicity associationEndMultiplicity,
                                  UbmlAssociationEndAggregation associationEndAggregation) {
        this.type = type;
        this.associationEndMultiplicity = associationEndMultiplicity;
        this.associationEndAggregation = associationEndAggregation;
    }

    @Override
    public UbmlAssociationEndMultiplicity getAssociationMultiplicity() {
        return associationEndMultiplicity;
    }

    @Override
    public UbmlAssociationEndAggregation getAssociationEndAggregation() {
        return associationEndAggregation;
    }

    @Override
    public UbmlType getType() {
        return type;
    }

    @Override
    public String getKind() {
        return "UbmlAssociationEnd";
    }
}