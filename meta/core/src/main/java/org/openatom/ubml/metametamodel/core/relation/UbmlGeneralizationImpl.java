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

import org.openatom.ubml.metametamodel.api.UbmlObject;
import org.openatom.ubml.metametamodel.api.relationship.UbmlGeneralization;

/**
 * The type UbmlGeneralization
 *
 * @author: Jack Lee
 */
public class UbmlGeneralizationImpl extends AbstractUbmlDirectedRelationship implements UbmlGeneralization {

    private UbmlGeneralizationImpl general;

    public UbmlGeneralizationImpl(UbmlObject source, UbmlObject target, UbmlGeneralizationImpl general) {
        super(source, target);
        this.general = general;
    }

    @Override public UbmlGeneralization getGeneral() {
        return general;
    }

    @Override
    public String getKind() {
        return "UbmlGeneralization";
    }

}