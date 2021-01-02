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
package org.openatom.ubml.metametamodel.api;

import java.util.List;

/**
 * An UbmlEnumType represents a set of related values.
 */
public interface UbmlEnumType extends UbmlType {

    /**
     * Get member according to given name
     *
     * @param name name of member
     * @return {@link UbmlEnumMember} for the given name
     */
    UbmlEnumMember getMember(String name);

    /**
     * @return members as a list
     */
    List<UbmlEnumMember> getMembers();

    /**
     * @return the {@link UbmlPrimitiveType} this {@link UbmlEnumType} is based upon
     */
    UbmlPrimitiveType getUnderlyingType();

}
