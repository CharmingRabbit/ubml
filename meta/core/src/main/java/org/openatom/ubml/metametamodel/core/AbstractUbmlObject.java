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

import org.openatom.ubml.metametamodel.api.Tags;
import org.openatom.ubml.metametamodel.api.UbmlObject;

/**
 * The type AbstractEdmObject
 *
 * @author: haozhibei
 */
public abstract class AbstractUbmlObject implements UbmlObject {

    protected Tags tags;

    @Override
    public Tags getTags() {
        return tags;
    }

    @Override
    public abstract String getKind();

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
