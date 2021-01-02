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


/**
 * A full qualified name consists of a name and a namespace.
 *
 * @author: haozhibei
 */
public final class FullQualifiedName {

    private final String namespace;
    private final String name;

    private final String fqn;

    /**
     * Create the FQN with given namespace and name
     *
     * @param namespace namespace of FQN
     * @param name      name of FQN
     */
    public FullQualifiedName(final String namespace, final String name) {
        this.namespace = namespace;
        this.name = name;
        fqn = namespace + "." + name;
    }

    /**
     * Create the FQN with given namespace and name (which is split of last <code>.</code> of the parameter).
     *
     * @param namespaceAndName namespace and name of FQN
     */
    public FullQualifiedName(final String namespaceAndName) {
        final int dotIdx = namespaceAndName.lastIndexOf('.');
        if (dotIdx == -1 || dotIdx == 0 || dotIdx == namespaceAndName.length() - 1) {
            throw new IllegalArgumentException(
                    "Malformed " + FullQualifiedName.class.getSimpleName() + ": " + namespaceAndName);
        }

        fqn = namespaceAndName;
        namespace = fqn.substring(0, dotIdx);
        name = fqn.substring(dotIdx + 1);
    }

    /**
     * @return namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return namespace.name
     */
    public String getFullQualifiedNameAsString() {
        return fqn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final FullQualifiedName that = (FullQualifiedName)o;
        return (namespace == null ? that.namespace == null : namespace.equals(that.namespace))
                && (name == null ? that.name == null : name.equals(that.name));
    }

    @Override
    public int hashCode() {
        return fqn == null ? 0 : fqn.hashCode();
    }

    @Override
    public String toString() {
        return fqn;
    }

}
