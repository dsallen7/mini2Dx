/*******************************************************************************
 * Copyright 2019 See AUTHORS file
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2Dx.core.di;

import org.mini2Dx.core.exception.MdxException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Bean utility functions
 */
public class BeanUtils {
    /**
     * Creates a deep copy of an {@link Object}
     * @param bean The {@link Object} to copy
     * @return A new instance of {@link Object} with all its properties copied
     * @throws MdxException Thrown if an exception occurs during the copy
     */
    public Object cloneBean(Object bean) throws MdxException {
        try {
            Class<?> currentClass = bean.getClass();
            Object result = currentClass.newInstance();

            while (!currentClass.equals(Object.class)) {
                for (Field field : currentClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    if(Modifier.isFinal(field.getModifiers())) {
                        continue;
                    }
                    Object value = field.get(bean);
                    field.set(result, value);
                }
                currentClass = currentClass.getSuperclass();
            }
            return result;
        } catch (IllegalAccessException e) {
            throw new MdxException(e.getMessage(), e);
        } catch (InstantiationException e) {
            throw new MdxException(e.getMessage(), e);
        }
    }
}