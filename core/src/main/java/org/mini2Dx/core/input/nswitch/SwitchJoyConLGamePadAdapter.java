/*******************************************************************************
 * Copyright 2019 Viridian Software Limited
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
package org.mini2Dx.core.input.nswitch;

import org.mini2Dx.core.input.button.SwitchJoyConLButton;

public class SwitchJoyConLGamePadAdapter implements SwitchJoyConLGamePadListener {
	@Override
	public void connected(SwitchJoyConLGamePad gamePad) {

	}

	@Override
	public void disconnected(SwitchJoyConLGamePad gamePad) {

	}

	@Override
	public boolean buttonDown(SwitchJoyConLGamePad gamePad, SwitchJoyConLButton button) {
		return false;
	}

	@Override
	public boolean buttonUp(SwitchJoyConLGamePad gamePad, SwitchJoyConLButton button) {
		return false;
	}

	@Override
	public boolean leftStickXMoved(SwitchJoyConLGamePad gamePad, float value) {
		return false;
	}

	@Override
	public boolean leftStickYMoved(SwitchJoyConLGamePad gamePad, float value) {
		return false;
	}

	@Override
	public boolean zlMoved(SwitchJoyConLGamePad gamePad, float value) {
		return false;
	}
}
