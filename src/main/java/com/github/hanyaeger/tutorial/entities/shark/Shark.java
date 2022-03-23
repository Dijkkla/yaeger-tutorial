package com.github.hanyaeger.tutorial.entities.shark;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Shark extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

	public Shark(Coordinate2D initialLocation) {
		super(initialLocation);
	    setMotion(2, 90d);
	}
	
	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		setAnchorLocationX(-400);
	    setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 400));
	}

	@Override
	protected void setupEntities() {
		var sharkSprite = new SharkSprite(new Coordinate2D(0, 0));
		addEntity(sharkSprite);

		var hitBox = new SharkHitBox(new Coordinate2D(335, 190), 40, 70);
		addEntity(hitBox);
	}

}

/*
package com.github.hanyaeger.tutorial.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Shark extends DynamicSpriteEntity implements SceneBorderCrossingWatcher,Collider {

	public Shark(Coordinate2D location){
	    super("sprites/sharky.png", location, new Size(400,400), 1, 19);
	    setAutoCycle(69);
	    setMotion(2, 90d);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		setAnchorLocationX(-400);
	    setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 400));
	}

}

*/