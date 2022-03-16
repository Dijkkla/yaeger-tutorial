package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Lad;
import com.github.hanyaeger.tutorial.entities.Swordfish;

public class GameLevel extends DynamicScene {

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/waterworld.mp3");
	    setBackgroundImage("backgrounds/background2.jpg");
	}

	@Override
	public void setupEntities() {
		var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));
		addEntity(swordfish);

		var lad = new Lad(new Coordinate2D(getWidth() / 4, getHeight() / 4));
		addEntity(lad);
	}

}
