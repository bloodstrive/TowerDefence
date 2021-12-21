package com.company;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import static com.company.helpers.Artist.*;

public class Main {
    public Main(){
        BeginSession();
        Tile tile = new Tile(0,0,64,64,TileType.Grass);
        while(!Display.isCloseRequested()) {
            tile.Draw();
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }

    public static void main(String[] args) {
        new Main();
    }
}
