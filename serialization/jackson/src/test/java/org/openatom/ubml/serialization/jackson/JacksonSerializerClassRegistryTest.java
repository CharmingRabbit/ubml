package org.openatom.ubml.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openatom.ubml.common.loader.EnhancedServiceLoader;
import org.openatom.ubml.metametamodel.api.UbmlObject;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiImpl;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiOperationImpl;
import org.openatom.ubml.serialization.api.SerializeOutput;
import org.openatom.ubml.serialization.api.Serializer;
import org.openatom.ubml.serialization.api.support.SerializerClassRegistry;

import static org.assertj.core.api.Assertions.assertThat;

class JacksonSerializerClassRegistryTest {

    @BeforeEach
    void initSerializer() {
        SerializerClassRegistry.registerSerializer(UbmlExternalApiOperationImpl.class, new CustomOperationSerializer());
        SerializerClassRegistry.registerDeserializer(UbmlExternalApiOperationImpl.class, new CustomOperationDeserializer());
    }

    @Test
    void registerSerializer() {
        UbmlExternalApiImpl eapi = JacksonSerializerTest.getSingleEApi();
        Serializer serializer = EnhancedServiceLoader.getServiceLoader(Serializer.class).load(JacksonSerializer.SERIALIZER_TYPE);
        //do serialize;
        SerializeOutput output = serializer.serialize(eapi);
        //do deserialize
        String eapiStr = output.getContent().toString();
        JacksonDeserializeInput deserializeInput = new JacksonDeserializeInput();
        deserializeInput.setContent(eapiStr);

        UbmlObject deserializeResult = serializer.deserialize(deserializeInput);
        SerializeOutput output2 = serializer.serialize(deserializeResult);

        assertThat(output.getContent()).isEqualTo(output2.getContent());
    }


    private static class CustomOperationSerializer extends JsonSerializer<UbmlExternalApiOperationImpl> {

        @Override
        public void serialize(UbmlExternalApiOperationImpl value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//            gen.writeStartObject();
            gen.writeStringField("kind", value.getKind());
            gen.writeStringField("customName", value.getName());
//            gen.writeEndObject();
        }

        @Override
        public void serializeWithType(UbmlExternalApiOperationImpl value, JsonGenerator g, SerializerProvider provider,
                                      TypeSerializer typeSer) throws IOException {

            WritableTypeId typeId = typeSer.typeId(value, JsonToken.START_OBJECT);
            typeSer.writeTypePrefix(g, typeId);
            serialize(value, g, provider); // call your customized serialize method
            typeSer.writeTypeSuffix(g, typeId);
        }
    }

    private static class CustomOperationDeserializer extends JsonDeserializer<UbmlExternalApiOperationImpl> {

        @Override
        public UbmlExternalApiOperationImpl deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode objJson = p.getCodec().readTree(p);
            String name = objJson.get("customName").asText();
            UbmlExternalApiOperationImpl op = new UbmlExternalApiOperationImpl();
            op.setName(name);
            return op;
        }
    }
}