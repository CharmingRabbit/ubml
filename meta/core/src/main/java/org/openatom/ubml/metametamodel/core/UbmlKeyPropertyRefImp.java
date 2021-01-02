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

import org.openatom.ubml.metametamodel.api.UbmlKeyPropertyRef;
import org.openatom.ubml.metametamodel.api.UbmlProperty;

/**
 * The type UbmlKeyPropertyRefImp
 *
 * @author: Jack Lee
 */
public class UbmlKeyPropertyRefImp implements UbmlKeyPropertyRef {
    private String name;
    private UbmlProperty property;

    public UbmlKeyPropertyRefImp(String name, UbmlProperty property) {
        this.name = name;
        this.property = property;
    }

    @Override public String getName() {
        return name;
    }

    @Override public UbmlProperty getProperty() {
        return property;
    }
}