package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.Lad;

public class Bubble extends DynamicCircleEntity implements SceneBorderCrossingWatcher,Collided,Collider {

	protected Bubble(Coordinate2D initialLocation, double speed) {
		super(initialLocation);
	    setMotion(speed, 180d);
	    setRadius(10);
	    setOpacity(0.5);
	}

	@Override
	public void onCollision(Collider collidingObject){
	    if (collidingObject instanceof Lad){
		    var popSound = new SoundClip("audio/pop.mp3");
		    popSound.play();
	
		    remove();
	    }
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		if (border == SceneBorder.TOP) {
			remove();
		}
	}

}
