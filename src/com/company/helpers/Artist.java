package com.company.helpers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;

public class Artist {
    public static final int WIDTH = 1280,HEIGHT = 960;
    public static void BeginSession(){
        Display.setTitle("THE GAME");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,WIDTH,HEIGHT,0,1,-1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }
    public static void DrawQuad(float x,float y , float width,float height){
        glBegin(GL_QUADS);
        glVertex2f(x,y);//TOP LEFT
        glVertex2f(x+width,y);//TOP RIGHT
        glVertex2f(x+width,y+height);//BOTTOM RIGHT
        glVertex2f(x,y+height);//BOTTOM LEFT
        glEnd();
    }
    public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
        tex.bind();
        glTranslatef(x,y,0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(width,0);
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glEnd();
        glLoadIdentity();
    }
    public static Texture LoadTexture(String path,String fileType){
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(fileType,in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tex;
    }
    public static Texture QuickLoad(String name){
        Texture tex= null;
        tex = LoadTexture("resources/" + name + ".png", "PNG");
        return tex;
    }
}
