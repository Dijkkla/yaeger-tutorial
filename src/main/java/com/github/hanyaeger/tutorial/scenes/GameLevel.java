package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Lad;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene {

	private Waterworld waterworld;

	public GameLevel(Waterworld waterworld){
	    this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/waterworld.mp3");
	    setBackgroundImage("backgrounds/background2.jpg");
	}

	@Override
	public void setupEntities() {
		var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));
		addEntity(swordfish);
		
		var healthText = new HealthText(new Coordinate2D(getWidth() / 4 * 3, getHeight() / 4));
		addEntity(healthText);

		var lad = new Lad(new Coordinate2D(getWidth() / 4, getHeight() / 4), healthText, waterworld);
		addEntity(lad);
	}

}
