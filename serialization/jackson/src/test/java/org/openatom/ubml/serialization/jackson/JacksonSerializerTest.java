package org.openatom.ubml.serialization.jackson;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openatom.ubml.common.loader.EnhancedServiceLoader;
import org.openatom.ubml.metametamodel.api.UbmlObject;
import org.openatom.ubml.metametamodel.api.UbmlParameter;
import org.openatom.ubml.metamodel.externalapi.common.api.HttpMethod;
import org.openatom.ubml.metamodel.externalapi.common.api.HttpParameterLocation;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiOperation;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiImpl;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiOperationImpl;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiParameterImpl;
import org.openatom.ubml.metamodel.externalapi.common.core.UbmlExternalApiProviderImpl;
import org.openatom.ubml.serialization.api.SerializeOutput;
import org.openatom.ubml.serialization.api.Serializer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for jackson serializer
 *
 * @author haozhibei
 */
public class JacksonSerializerTest {


    @Test
    public void testSerializeAndDeserialize() {
        Serializer serializer = EnhancedServiceLoader.getServiceLoader(Serializer.class).load(JacksonSerializer.SERIALIZER_TYPE);

        UbmlExternalApiImpl eapi = getSingleEApi();
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

    public static UbmlExternalApiImpl getSingleEApi() {
        UbmlExternalApiImpl eapi = new UbmlExternalApiImpl();
        eapi.setBusinessObject("bo1");
        eapi.setCriticalApplication("cmp");
        eapi.setMicroserviceUnit("cmp_su1");

        UbmlExternalApiProviderImpl provider = new UbmlExternalApiProviderImpl();
        provider.setId("provider1");
        provider.setAlias("provider2qsd");
        provider.setProviderType("view_model");
        provider.setName("providerFromVO");
        eapi.setProvider(provider);

        List<UbmlExternalApiOperation> operations = new ArrayList<>();
        UbmlExternalApiOperationImpl op1 = new UbmlExternalApiOperationImpl();
        operations.add(op1);
        eapi.setOperations(operations);

        op1.setId("abc");
        op1.setAlias("alias");
        op1.setName("name1");
        op1.setHttpMethod(HttpMethod.GET);
        List<UbmlParameter> parameters = new ArrayList<>();
        op1.setParameters(parameters);

        UbmlExternalApiParameterImpl param1 = new UbmlExternalApiParameterImpl();
        param1.setLocation(HttpParameterLocation.PATH);
        param1.setId("param1");
        param1.setAlias("parambbb");
        param1.setRequired(true);
        parameters.add(param1);
        return eapi;
    }

}