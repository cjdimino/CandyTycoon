package exec;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import game.CandyGame;

public class Test{

	/**
	 * @param args
	 * @throws LWJGLException 
	 */
	public static Font  menuFontDef;
	public static TrueTypeFont menuFont;

	public static void main(String[] args) throws LWJGLException {
		// TODO Auto-generated method stub
	

		
		
		Display.setResizable(true);
		Display.setInitialBackground(1f, 1f, 1f);
	    AppGameContainer appgc;
	    try {

	        appgc = new AppGameContainer(new CandyGame());
	        appgc.setDisplayMode(800, 600, false);
	        
	        appgc.setTargetFrameRate(60);
	        appgc.setShowFPS(false);
	        appgc.setTitle("TestApp");
	        appgc.start();
	    }
	    catch(SlickException e) {
	        e.printStackTrace();
	    }

	}
}
