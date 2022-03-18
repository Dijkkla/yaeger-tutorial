package com.github.hanyaeger.tutorial.entities.shark;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SharkSprite extends DynamicSpriteEntity {

    public SharkSprite(final Coordinate2D location){
	    super("sprites/sharky.png", location, new Size(400,400), 1, 19);
	    setAutoCycle(69);
	}
}

