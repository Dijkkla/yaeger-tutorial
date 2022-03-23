package com.github.hanyaeger.tutorial.entities.shark;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import javafx.scene.paint.Color;

public class SharkHitBox extends RectangleEntity implements Collider {

    public SharkHitBox(final Coordinate2D initialPosition, int width, int height) {
        super(initialPosition);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }
}

// LifeformHitbox(initialPosition:final Coordinate2D , width:int, height:int) : LifeformHitbox