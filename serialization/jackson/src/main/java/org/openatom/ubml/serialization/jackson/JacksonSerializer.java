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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.openatom.ubml.common.loader.LoadLevel;
import org.openatom.ubml.metametamodel.api.UbmlObject;
import org.openatom.ubml.serialization.api.DeserializeInput;
import org.openatom.ubml.serialization.api.SerializeOutput;
import org.openatom.ubml.serialization.api.Serializer;

/**
 * The type JacksonSerializer
 *
 * @author: haozhibei
 */
@LoadLevel(name = JacksonSerializer.SERIALIZER_TYPE)
public class JacksonSerializer implements Serializer {

    public static final String SERIALIZER_TYPE = "jackson";

    private ObjectMapper mapper = JacksonFactory.getInstance().getObjectMapper();


    @Override
    public SerializeOutput serialize(UbmlObject ubmlObject) {
        JacksonSerializeOutput result = new JacksonSerializeOutput();
        try {
            result.setContent(mapper.writeValueAsString(ubmlObject));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public UbmlObject deserialize(DeserializeInput input) {
        UbmlObject result;
        JacksonDeserializeInput jacksonInput = (JacksonDeserializeInput)input;
        String jsonStr = jacksonInput.getContent().toString();
        try {
            result = mapper.readValue(jsonStr, UbmlObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }


}
