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
 * The type UbmlPackage
 *
 * @author: Jack Lee
 */
public interface UbmlPackage extends UbmlNamedObject {

    /**
     * get all nested packages
     *
     * @return the {@link UbmlPackage}
     */
    List<UbmlPackage> getNestedPackage();

    /**
     * get all nested metamodel
     *
     * @return the {@link UbmlMetamodel}
     */
    List<UbmlMetamodel> getMetamodel();
}