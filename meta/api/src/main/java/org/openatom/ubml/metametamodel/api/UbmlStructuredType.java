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
 * UbmlStructuralType is the base for a complex type or an entity type.
 */
public interface UbmlStructuredType extends UbmlType {

    /**
     * Get the full qualified name of the structured type.
     *
     * @return the {@link FullQualifiedName}
     */
    FullQualifiedName getFullQualifiedName();

    /**
     * Get property by name
     *
     * @param name name of property
     * @return simple, complex or navigation property as {@link UbmlType}
     */
    UbmlProperty getProperty(String name);

    /**
     * Gets the properties declared immediately within this type.
     *
     * @return property {@link UbmlProperty} as list;
     */
    List<UbmlProperty> getDeclaredProperties();

}
