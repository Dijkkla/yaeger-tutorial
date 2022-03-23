package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Bubble extends DynamicCircleEntity implements SceneBorderCrossingWatcher,Collider {

	protected Bubble(Coordinate2D initialLocation, double speed) {
		super(initialLocation);
	    setMotion(speed, 180d);
	    setRadius(10);
	    setOpacity(0.5);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		if (border == SceneBorder.TOP) {
			remove();
		}
	}

}
