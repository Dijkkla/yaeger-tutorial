package com.github.hanyaeger.tutorial.entities.shark;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import javafx.scene.paint.Color;

public class SharkHitBox extends RectangleEntity implements Collider {

    public SharkHitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(70);
        setFill(Color.TRANSPARENT);
    }
}
