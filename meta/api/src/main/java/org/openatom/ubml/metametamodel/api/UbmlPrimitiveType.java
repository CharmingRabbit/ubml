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
 * UbmlPrimitiveType is a primitive type as defined in the UBML.
 * <br/>
 * There are methods to convert Ubmlprimitive types from and to Java objects, respectively. The following Java types
 * are
 * supported:
 * <table frame="hsides" rules="groups">
 * <thead>
 * <tr><th>UBML primitive type</th><th>Java types</th></tr>
 * </thead>
 * <tbody>
 * <tr><td>Binary</td><td>byte[], {@link Byte}[]</td></tr>
 * <tr><td>Boolean</td><td>{@link Boolean}</td></tr>
 * <tr><td>Byte</td><td>{@link Short}, {@link Byte}, {@link Integer}, {@link Long}, {@link java.math.BigInteger}
 * </td></tr>
 * <tr><td>Date</td><td>{@link java.util.Calendar}, {@link java.util.Date}, {@link java.sql.Timestamp},
 * {@link java.sql.Time}, {@link Long}</td></tr>
 * <tr><td>Decimal</td><td>{@link java.math.BigDecimal}, {@link java.math.BigInteger}, {@link Double}, {@link Float},
 * {@link Byte}, {@link Short}, {@link Integer}, {@link Long}</td></tr>
 * <tr><td>Double</td><td>{@link Double}, {@link Float}, {@link java.math.BigDecimal}, {@link Byte}, {@link Short},
 * {@link Integer}, {@link Long}</td></tr>
 * <tr><td>Int16</td><td>{@link Short}, {@link Byte}, {@link Integer}, {@link Long}, {@link java.math.BigInteger}
 * </td></tr>
 * <tr><td>Int32</td><td>{@link Integer}, {@link Byte}, {@link Short}, {@link Long}, {@link java.math.BigInteger}
 * </td></tr>
 * <tr><td>Int64</td><td>{@link Long}, {@link Byte}, {@link Short}, {@link Integer}, {@link java.math.BigInteger}
 * </td></tr>
 * <tr><td>String</td><td>{@link String}</td></tr>
 * <tr><td>DateTime</td><td>{@link java.util.Calendar}, {@link java.util.Date}, {@link java.sql.Timestamp},
 * {@link java.sql.Time}, {@link Long}</td></tr>
 * </tbody>
 * </table>
 * <p>
 * The first Java type is the default type for the respective UBML primitive type.
 * </p>
 */
public interface UbmlPrimitiveType extends UbmlType {

    /**
     * Get the kind of the primitive type.
     *
     * @return {@link UbmlPrimitiveTypeKind} of the primitive type
     */
    UbmlPrimitiveTypeKind getPrimitiveKind();

}
