package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.buttons.ReplayButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene {

	private Waterworld waterworld;

	public GameOverScene(Waterworld waterworld){
	    this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/ocean.mp3");
	    setBackgroundImage("backgrounds/background1.jpg");
	}

	@Override
	public void setupEntities() {
		var waterworldText = new TextEntity(
	        new Coordinate2D(getWidth() / 2, getHeight() / 2),
	        "Game Over"
	    );
	    waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
	    waterworldText.setFill(Color.DARKBLUE);
	    waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
	    addEntity(waterworldText);
	    
	    var replayButton = new ReplayButton(new Coordinate2D(getWidth() / 2, getHeight() / 5 * 3), waterworld);
	    replayButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
	    addEntity(replayButton);
	    
	    var quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 5 * 4), waterworld);
	    quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
	    addEntity(quitButton);
	}

}
