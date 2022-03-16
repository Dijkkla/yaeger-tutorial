package com.github.hanyaeger.tutorial.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class Lad extends DynamicSpriteEntity implements KeyListener {
	
	public Lad(Coordinate2D location){
	    super("sprites/hanny.png", location, new Size(20,40), 1, 2);
	}
	
	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys){
	    if(pressedKeys.contains(KeyCode.LEFT)){
	        setMotion(3,270d);
	    } else if(pressedKeys.contains(KeyCode.RIGHT)){
	        setMotion(3,90d);
	    } else if(pressedKeys.contains(KeyCode.UP)){
	        setMotion(3,180d);
	    } else if(pressedKeys.contains(KeyCode.DOWN)){
	        setMotion(3,0d);
	    } else if(pressedKeys.isEmpty()){
	        setSpeed(0);
	    }
	}

}
