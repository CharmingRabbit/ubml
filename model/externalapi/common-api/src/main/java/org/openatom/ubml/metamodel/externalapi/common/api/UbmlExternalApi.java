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

package org.openatom.ubml.metamodel.externalapi.common.api;

import java.util.List;
import org.openatom.ubml.metametamodel.api.UbmlMetamodel;
import org.openatom.ubml.metametamodel.api.UbmlType;
import org.openatom.ubml.metamodel.commonpart.api.UbmlProvider;

/**
 * The type UbmlExternalApi
 *
 * @author: haozhibei
 */
public interface UbmlExternalApi extends UbmlMetamodel {


    /**
     * Gets the microservice unit to which the current externalapi belongs.
     * Microservice unit is a complete microservice module that can be deployed and released independently.
     *
     * @return the microservice unit string
     */
    String getMicroserviceUnit();

    /**
     * Gets the critical application to which the current externalapi beglongs.
     * Criticalapplication is a business system which contains a series of highly cohesive business functions,
     * generally a subsystem in the system.
     *
     * @return the critical application string
     */
    String getCriticalApplication();

    /**
     * Gets the business object to which the current externalapi belongs;
     *
     * @return the business object string
     */
    String getBusinessObject();


    /**
     * Gets the server urls;
     *
     * @return the url string list
     */
    List<String> getServerUrls();

    /**
     * Gets the externalapi version;
     *
     * @return the version string
     */
    String getVersion();

    /**
     * Gets the provider of the external api.
     *
     * @return the {@link UbmlProvider}
     */
    UbmlExternalApiProvider getProvider();

    /**
     * Gets all the operations in the current external api.
     *
     * @return the List of {@link UbmlExternalApiOperation}
     */
    List<UbmlExternalApiOperation> getOperations();

    /**
     * Gets all the structuredType.
     *
     * @return the list of {@link UbmlType}
     */
    List<UbmlType> getStructuredTypes();

}
