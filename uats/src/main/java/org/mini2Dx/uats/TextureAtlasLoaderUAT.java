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
package org.mini2Dx.uats;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.AssetDescriptor;
import org.mini2Dx.core.assets.AssetManager;
import org.mini2Dx.core.files.FileHandleResolver;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.TextureAtlas;
import org.mini2Dx.core.graphics.TilingDrawable;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;
import org.mini2Dx.uats.util.ScreenIds;
import org.mini2Dx.uats.util.UATSelectionScreen;

public class TextureAtlasLoaderUAT extends BasicGameScreen {

    private static final String TEXTURE_ATLAS = "texture-region-uat.atlas";
    private final AssetManager assetManager;
    private TextureAtlas atlas;

    public TextureAtlasLoaderUAT(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.load(TEXTURE_ATLAS, TextureAtlas.class);
    }

    @Override
    public void initialise(GameContainer gc) {
        assetManager.finishLoading();
        atlas = assetManager.get(TEXTURE_ATLAS, TextureAtlas.class);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        if (Mdx.input.justTouched()) {
            screenManager.enterGameScreen(UATSelectionScreen.SCREEN_ID, new FadeOutTransition(),
                    new FadeInTransition());
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        g.drawTextureRegion(atlas.findRegion("cardDiamondsJ"), 100, 100);
        g.drawTextureRegion(atlas.findRegion("cardDiamondsQ"), 150, 100);
        g.drawTextureRegion(atlas.findRegion("cardDiamondsK"), 100, 150);
        g.drawTextureRegion(atlas.findRegion("cardDiamondsA"), 150, 150);
    }

    @Override
    public int getId() {
        return ScreenIds.getScreenId(TextureAtlasLoaderUAT.class);
    }
}
