package com.example.opilane.snake_game.engine;

import com.example.opilane.snake_game.classes.Coordinate;
import com.example.opilane.snake_game.enums.TileType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by opilane on 24.05.2018.
 */

public class GameEngine {
    public static final int GameWidth = 28;
    public static final int GameHeight = 42;

    private List<Coordinate> walls = new ArrayList<>();

    public GameEngine(){

    }

    public void initGame(){


        AddWalls();
    }

    public TileType[][] getMap(){
        TileType[][] map = new TileType[GameWidth][GameHeight];

        for (int x = 0; x < GameWidth; x++) {
            for (int y = 0; y < GameHeight; y++) {
                map[x][y] = TileType.Nothing;
            }
        }

        for (Coordinate wall: walls ) {
            map[wall.getX()][wall.getY()] = TileType.Wall;
        }
        return map;
    }

    private void AddWalls() {
        for (int x = 0; x < GameWidth; x++) {
            walls.add(new Coordinate(x,0));
            walls.add(new Coordinate(x,GameHeight-1));
        }

        for (int y = 0; y < GameHeight; y++) {
            walls.add(new Coordinate(0,y));
            walls.add(new Coordinate(GameWidth - 1 , y));
        }



    }
}
