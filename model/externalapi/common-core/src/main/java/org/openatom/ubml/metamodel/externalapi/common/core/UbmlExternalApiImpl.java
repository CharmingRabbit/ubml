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

package org.openatom.ubml.metamodel.externalapi.common.core;

import java.util.List;
import org.openatom.ubml.common.loader.LoadLevel;
import org.openatom.ubml.metametamodel.api.UbmlType;
import org.openatom.ubml.metametamodel.core.AbstractUbmlMetamodel;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApi;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiOperation;
import org.openatom.ubml.metamodel.externalapi.common.api.UbmlExternalApiProvider;

/**
 * The type UbmlExternalApiImpl
 *
 * @author: haozhibei
 */
@LoadLevel(name = UbmlExternalApiImpl.UBML_EXTERNAL_API_KIND)
public class UbmlExternalApiImpl extends AbstractUbmlMetamodel implements UbmlExternalApi {

    public static final String UBML_EXTERNAL_API_KIND = "DefaultExternalApi";

    private String microserviceUnit;

    private String criticalApplication;

    private String businessObject;

    private List<String> serverUrls;

    private String version;

    private List<UbmlExternalApiOperation> operations;

    private UbmlExternalApiProvider provider;

    private List<UbmlType> structuredTypes;

    public void setMicroserviceUnit(String microserviceUnit) {
        this.microserviceUnit = microserviceUnit;
    }

    public void setCriticalApplication(String criticalApplication) {
        this.criticalApplication = criticalApplication;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

    public void setServerUrls(List<String> serverUrls) {
        this.serverUrls = serverUrls;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setOperations(List<UbmlExternalApiOperation> operations) {
        this.operations = operations;
    }

    public void setProvider(UbmlExternalApiProvider provider) {
        this.provider = provider;
    }

    public void setStructuredTypes(List<UbmlType> structuredTypes) {
        this.structuredTypes = structuredTypes;
    }

    @Override
    public String getMicroserviceUnit() {
        return microserviceUnit;
    }

    @Override
    public String getCriticalApplication() {
        return criticalApplication;
    }

    @Override
    public String getBusinessObject() {
        return businessObject;
    }

    @Override
    public List<String> getServerUrls() {
        return serverUrls;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public UbmlExternalApiProvider getProvider() {
        return provider;
    }

    @Override
    public List<UbmlExternalApiOperation> getOperations() {
        return operations;
    }

    @Override
    public List<UbmlType> getStructuredTypes() {
        return structuredTypes;
    }

    @Override
    public String getKind() {
        return UBML_EXTERNAL_API_KIND;
    }
}
