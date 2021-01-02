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

package org.openatom.ubml.metamodel.commonpart.api;

import org.openatom.ubml.metametamodel.api.FullQualifiedName;
import org.openatom.ubml.metametamodel.api.UbmlNamedObject;

/**
 * The type UbmlProvider
 *
 * @author: haozhibei
 */
public interface UbmlProvider extends UbmlNamedObject {

    /**
     * Gets the ID of the provider.
     *
     * @return the ID string
     */
    String getId();

    /**
     * Gets the fqn of the provider.
     *
     * @return the {@link FullQualifiedName}
     */
    FullQualifiedName getFullQualifiedName();

    /**
     * Gets the type of the provider
     *
     * @return the type string.
     */
    String getProviderType();
}
