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

package org.openatom.ubml.serialization.jackson;

import org.openatom.ubml.serialization.api.DeserializeInput;

/**
 * The type JacksonDeserializeInput
 *
 * @author: haozhibei
 */
public class JacksonDeserializeInput implements DeserializeInput {

    private static final String DEFAULT_DESERIALIZE_CONTENT_TYPE = "text/json";

    private Object content;

    private String contentType;

    public JacksonDeserializeInput() {
        this.contentType = DEFAULT_DESERIALIZE_CONTENT_TYPE;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public String getContentType() {
        return contentType;
    }
}
