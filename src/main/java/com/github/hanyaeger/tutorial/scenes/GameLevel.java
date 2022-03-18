package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Lad;
import com.github.hanyaeger.tutorial.entities.shark.Shark;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

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

		var shark = new Shark(new Coordinate2D(getWidth() / 2, getHeight() / 2));
		addEntity(shark);
		
		var healthText = new HealthText(new Coordinate2D(getWidth() / 2, getHeight() / 4));
		addEntity(healthText);
		
		var bubblesPoppedText = new BubblesPoppedText(new Coordinate2D(getWidth() / 2, getHeight() / 5));
		addEntity(bubblesPoppedText);

		var lad = new Lad(new Coordinate2D(getWidth() / 4, getHeight() / 4), 
				healthText, 
				bubblesPoppedText,
				waterworld);
		addEntity(lad);
	}

	@Override
	public void setupEntitySpawners() {
		addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
	}

}
