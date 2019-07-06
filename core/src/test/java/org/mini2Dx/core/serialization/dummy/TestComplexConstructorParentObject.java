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
package org.mini2Dx.core.serialization.dummy;

import org.mini2Dx.core.serialization.annotation.Field;
import org.mini2Dx.gdx.utils.Array;

import java.util.Objects;

public class TestComplexConstructorParentObject {
	@Field
	private final Array<TestComplexConstructorArgObject> children = new Array<TestComplexConstructorArgObject>();

	public Array<TestComplexConstructorArgObject> getChildren() {
		return children;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TestComplexConstructorParentObject that = (TestComplexConstructorParentObject) o;
		return children.equals(that.children);
	}

	@Override
	public int hashCode() {
		return Objects.hash(children);
	}
}
