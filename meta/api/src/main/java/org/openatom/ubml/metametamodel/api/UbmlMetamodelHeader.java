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
 * The type UbmlMetamodelHeader
 *
 * @author: haozhibei
 */
public final class UbmlMetamodelHeader {

    private String id;
    private String alias;
    private String metamodelType;
    private String metamodelVersion;
    private String ubmlVersion;
    private String language;
    private boolean translated;
    private boolean extensible;
    private FullQualifiedName fullQualifiedName;
    private List<UbmlMetamodelReference> references;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMetamodelType() {
        return metamodelType;
    }

    public void setMetamodelType(String metamodelType) {
        this.metamodelType = metamodelType;
    }

    public String getMetamodelVersion() {
        return metamodelVersion;
    }

    public void setMetamodelVersion(String metamodelVersion) {
        this.metamodelVersion = metamodelVersion;
    }

    public String getUbmlVersion() {
        return ubmlVersion;
    }

    public void setUbmlVersion(String ubmlVersion) {
        this.ubmlVersion = ubmlVersion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTranslated() {
        return translated;
    }

    public void setTranslated(boolean translated) {
        this.translated = translated;
    }

    public boolean isExtensible() {
        return extensible;
    }

    public void setExtensible(boolean extensible) {
        this.extensible = extensible;
    }

    public FullQualifiedName getFullQualifiedName() {
        return fullQualifiedName;
    }

    public void setFullQualifiedName(FullQualifiedName fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }

    public List<UbmlMetamodelReference> getReferences() {
        return references;
    }

    public void setReferences(List<UbmlMetamodelReference> references) {
        this.references = references;
    }
}
