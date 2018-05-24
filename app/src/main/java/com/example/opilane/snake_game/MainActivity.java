package com.example.opilane.snake_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.opilane.snake_game.engine.GameEngine;
import com.example.opilane.snake_game.view.SnakeView;

public class MainActivity extends AppCompatActivity {

    private GameEngine gameEngine;
    private SnakeView snakeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameEngine = new GameEngine();
        gameEngine.initGame();



        snakeView = (SnakeView)findViewById(R.id.snakeView);
        snakeView.setSnakeViewMap(gameEngine.getMap());
        snakeView.invalidate();
    }
}
