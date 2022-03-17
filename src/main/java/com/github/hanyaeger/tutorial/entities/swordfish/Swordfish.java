package com.github.hanyaeger.tutorial.entities.swordfish;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

	public Swordfish(Coordinate2D initialLocation) {
		super(initialLocation);
	    setMotion(2, 270d);
	}
	
	@Override
	public void notifyBoundaryCrossing(SceneBorder border){
	    setAnchorLocationX(getSceneWidth());
	    setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
	}

	@Override
	protected void setupEntities() {
		var swordfishSprite = new SwordfishSprite(new Coordinate2D(0, 0));
		addEntity(swordfishSprite);

		var hitBox = new HitBox(new Coordinate2D(0, 39));
		addEntity(hitBox);
	}

}

/*

package com.github.hanyaeger.tutorial.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher,Collider {

	public Swordfish(Coordinate2D location){
	    super("sprites/swordfish.png", location);
	    setMotion(2, 270d);
	}
	
	@Override
	public void notifyBoundaryCrossing(SceneBorder border){
	    setAnchorLocationX(getSceneWidth());
	    setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
	}
	
}


*/