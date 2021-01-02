/*
 *  Copyright 1999-2019 Seata.io Group.
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
package org.openatom.ubml.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Reflection tools
 *
 * @author zhangsen
 */
public class ReflectionUtils {

    /**
     * The constant MAX_NEST_DEPTH.
     */
    public static final int MAX_NEST_DEPTH = 20;

    /**
     * Gets class by name.
     *
     * @param className the class name
     * @return the class by name
     * @throws ClassNotFoundException the class not found exception
     */
    public static Class<?> getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(className, true, Thread.currentThread().getContextClassLoader());
    }

    /**
     * get Field Value
     *
     * @param target    the target
     * @param fieldName the field name
     * @return field value
     * @throws NoSuchFieldException     the no such field exception
     * @throws SecurityException        the security exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IllegalAccessException   the illegal access exception
     */
    public static Object getFieldValue(Object target, String fieldName)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Class<?> cl = target.getClass();
        int i = 0;
        while ((i++) < MAX_NEST_DEPTH && cl != null) {
            try {
                Field field = cl.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(target);
            } catch (Exception e) {
                cl = cl.getSuperclass();
            }
        }
        throw new NoSuchFieldException("class:" + target.getClass() + ", field:" + fieldName);
    }

    /**
     * invoke Method
     *
     * @param target     the target
     * @param methodName the method name
     * @return object
     * @throws NoSuchMethodException     the no such method exception
     * @throws SecurityException         the security exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws IllegalArgumentException  the illegal argument exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static Object invokeMethod(Object target, String methodName)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Class<?> cl = target.getClass();
        int i = 0;
        while ((i++) < MAX_NEST_DEPTH && cl != null) {
            try {
                Method m = cl.getDeclaredMethod(methodName);
                m.setAccessible(true);
                return m.invoke(target);
            } catch (Exception e) {
                cl = cl.getSuperclass();
            }
        }
        throw new NoSuchMethodException("class:" + target.getClass() + ", methodName:" + methodName);
    }

    /**
     * invoke Method
     *
     * @param target         the target
     * @param methodName     the method name
     * @param parameterTypes the parameter types
     * @param args           the args
     * @return object
     * @throws NoSuchMethodException     the no such method exception
     * @throws SecurityException         the security exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws IllegalArgumentException  the illegal argument exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static Object invokeMethod(Object target, String methodName, Class<?>[] parameterTypes, Object[] args)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Class<?> cl = target.getClass();
        int i = 0;
        while ((i++) < MAX_NEST_DEPTH && cl != null) {
            try {
                Method m = cl.getDeclaredMethod(methodName, parameterTypes);
                m.setAccessible(true);
                return m.invoke(target, args);
            } catch (Exception e) {
                cl = cl.getSuperclass();
            }
        }
        throw new NoSuchMethodException("class:" + target.getClass() + ", methodName:" + methodName);
    }

    /**
     * invoke static Method
     *
     * @param targetClass     the target class
     * @param methodName      the method name
     * @param parameterTypes  the parameter types
     * @param parameterValues the parameter values
     * @return object
     * @throws NoSuchMethodException     the no such method exception
     * @throws SecurityException         the security exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws IllegalArgumentException  the illegal argument exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static Object invokeStaticMethod(Class<?> targetClass, String methodName, Class<?>[] parameterTypes,
                                            Object[] parameterValues)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        int i = 0;
        while ((i++) < MAX_NEST_DEPTH && targetClass != null) {
            try {
                Method m = targetClass.getMethod(methodName, parameterTypes);
                return m.invoke(null, parameterValues);
            } catch (Exception e) {
                targetClass = targetClass.getSuperclass();
            }
        }
        throw new NoSuchMethodException("class:" + targetClass + ", methodName:" + methodName);
    }

    /**
     * get Method by name
     *
     * @param classType      the class type
     * @param methodName     the method name
     * @param parameterTypes the parameter types
     * @return method
     * @throws NoSuchMethodException the no such method exception
     * @throws SecurityException     the security exception
     */
    public static Method getMethod(Class<?> classType, String methodName, Class<?>[] parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return classType.getMethod(methodName, parameterTypes);
    }

    /**
     * get all interface of the clazz
     *
     * @param clazz the clazz
     * @return set
     */
    public static Set<Class<?>> getInterfaces(Class<?> clazz) {
        if (clazz.isInterface()) {
            return Collections.singleton(clazz);
        }
        Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
        while (clazz != null) {
            Class<?>[] ifcs = clazz.getInterfaces();
            for (Class<?> ifc : ifcs) {
                interfaces.addAll(getInterfaces(ifc));
            }
            clazz = clazz.getSuperclass();
        }
        return interfaces;
    }

    /**
     * Gets a value indicates whether the concrete class inherit from or realize the base class
     *
     * @param concreteClass must be a concrete class,can not be an interface.
     * @param baseClass     an abstract class or an interface.
     * @return the result boolean.
     */
    public static boolean classIsInheritingOrImplementing(Class<?> concreteClass, Class<?> baseClass) {
        if (concreteClass.isInterface()) {
            throw new IllegalArgumentException("the concrete class should not be an interface!");
        }
        if (concreteClass.equals(baseClass)) {
            return false;
        }
        return baseClass.isAssignableFrom(concreteClass);
    }

    /**
     * Gets a value indicates whether the sub class is or inheriting or implementing the base class.
     * that means:
     * 1.while the sub class is a class and the base class is a class too,the value indicates whether the sub class
     * inherits from base class;
     * 2.while the sub class is an interface and the base class is an interface too,the value indicates whether the sub
     * class inherits from the base class;
     * 3.while the sub class is a class and the base class is an interface,the value indicates whether the sub class
     * implements the base class;
     *
     * @param subClass  can be a concrete class or an interface
     * @param baseClass an abstract class or an interface
     * @return
     */
    public static boolean isOrInheritingOrImplementing(Class<?> subClass, Class<?> baseClass) {
        // subClass is baseClass
        if (subClass.equals(baseClass)) {
            return true;
        }
        // subClass is interface
        if (subClass.isInterface()) {
            Class<?>[] interfaces = subClass.getInterfaces();
            boolean result = judgeInRecursive(interfaces, baseClass);
            return result;

        }
        // subClass is class
        return baseClass.isAssignableFrom(subClass);
    }

    private static boolean judgeInRecursive(Class<?>[] interfaces, Class<?> targetInterface) {
        List<Class<?>[]> innerInterfacess = new ArrayList<>();
        boolean matched = false;
        for (Class<?> interfacz : interfaces) {
            matched = interfacz.equals(targetInterface);
            innerInterfacess.add(interfacz.getInterfaces());
            if (matched) {
                break;
            }
        }
        if (!matched && innerInterfacess.size() > 0) {
            for (Class<?>[] innerInterfaces : innerInterfacess) {
                matched = judgeInRecursive(innerInterfaces, targetInterface);
                if (matched) {
                    break;
                }
            }
        }
        return matched;
    }

}
