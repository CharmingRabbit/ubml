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

import java.util.ArrayList;
import java.util.List;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociation;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociationEnd;
import org.openatom.ubml.metametamodel.api.relationship.UbmlAssociationType;

/**
 * The type UbmlAssociation
 *
 * @author: Jack Lee
 */
public class UbmlAssociationImpl extends AbstractUbmlDirectedRelationship implements UbmlAssociation {

    private UbmlAssociationType associationType;

    public UbmlAssociationImpl(UbmlAssociationEnd source,
                               UbmlAssociationEnd target,
                               UbmlAssociationType associationType) {
        super(source, target);
        this.associationType = associationType;
    }

    @Override
    public UbmlAssociationType getAssociationType() {
        return associationType;
    }

    @Override
    public List<UbmlAssociationEnd> getAssociationEnds() {
        List<UbmlAssociationEnd> associationEnds = new ArrayList<UbmlAssociationEnd>();
        associationEnds.add((UbmlAssociationEndImpl) this.getSource());
        associationEnds.add((UbmlAssociationEndImpl) this.getTarget());
        return associationEnds;
    }

    @Override
    public String getKind() {
        return "UbmlAssociation";
    }
}