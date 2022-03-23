package com.github.hanyaeger.tutorial.entities;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubbles.Bubble;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

import javafx.scene.input.KeyCode;

public class Lad extends DynamicSpriteEntity implements KeyListener,SceneBorderTouchingWatcher,Newtonian,Collided {
	
	private Waterworld waterworld;
	
	private HealthText healthText;
	private int health = 10;
	
	private BubblesPoppedText bubblesPoppedText;
	private int bubblesPopped = 0;
	
	public Lad(Coordinate2D location, HealthText healthText, BubblesPoppedText bubblesPoppedText, Waterworld waterworld){
	    super("sprites/hanny.png", location, new Size(20,20), 2, 2);

	    this.waterworld = waterworld;
	    
	    this.healthText = healthText;
	    healthText.setHealthText(health);
	    
	    this.bubblesPoppedText = bubblesPoppedText;
	    bubblesPoppedText.setBubblesPoppedText(bubblesPopped);
	    
	    setGravityConstant(0.005);
	    setFrictionConstant(0.04);
	}
	
	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys){
	    if(pressedKeys.contains(KeyCode.LEFT)){
	        setMotion(3,270d);
	        setCurrentFrameIndex(0);
	    } else if(pressedKeys.contains(KeyCode.RIGHT)){
	        setMotion(3,90d);
	        setCurrentFrameIndex(1);
	    } else if(pressedKeys.contains(KeyCode.UP)){
	        setMotion(3,180d);
	        setCurrentFrameIndex(2);
	    } else if(pressedKeys.contains(KeyCode.DOWN)){
	        setMotion(3,0d);
	        setCurrentFrameIndex(3);
	    }
	}
	
	@Override
	public void notifyBoundaryTouching(SceneBorder border){
	    setSpeed(0);

	    switch(border){
	        case TOP:
	            setAnchorLocationY(1);
	            break;
	        case BOTTOM:
	            setAnchorLocationY(getSceneHeight() - getHeight() - 1);
	            break;
	        case LEFT:
	            setAnchorLocationX(1);
	            break;
	        case RIGHT:
	            setAnchorLocationX(getSceneWidth() - getWidth() - 1);
	        default:
	            break;
	        }
	}

	@Override
	public void onCollision(Collider collidingObject){
	    if (collidingObject instanceof Coral) {
	    	setSpeed(0);
	    } else if (collidingObject instanceof AirBubble){
	        bubblesPoppedText.setBubblesPoppedText(++bubblesPopped);
	    } else {
	        healthText.setHealthText(--health);

	        if (health <= 0){
	            this.waterworld.setActiveScene(2);
	        } else {
	            setAnchorLocation(new Coordinate2D(
	                new Random().nextInt((int)(getSceneWidth() - getWidth())),
	                new Random().nextInt((int)(getSceneHeight() - getHeight()))));
	        }
	    }
	    
	    if (collidingObject instanceof Bubble) {
		    var popSound = new SoundClip("audio/pop.mp3");
		    popSound.play();
	
		    ((Bubble) collidingObject).remove();
	    }
	}

}