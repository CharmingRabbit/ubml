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

package org.openatom.ubml.metametamodel.api.relationship;

import org.openatom.ubml.metametamodel.api.UbmlObject;

/**
 * The type UbmlDirectedRelationship
 *
 * @author: Jack Lee
 */
public interface UbmlDirectedRelationship extends UbmlRelationship {

    /**
     * get the source in relationship
     *
     * @return the {@link UbmlObject}
     */
    UbmlObject getSource();

    /**
     * get the target in relationship
     *
     * @return the {@link UbmlObject}
     */
    UbmlObject getTarget();
}
