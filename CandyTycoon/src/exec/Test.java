package exec;

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

import game.CandyGame;

public class Test{

	/**
	 * @param args
	 * @throws LWJGLException 
	 */
	public static void main(String[] args) throws LWJGLException {
		// TODO Auto-generated method stub
		
		//CandyGame game = new CandyGame();
		//game.start();
		Display.setResizable(true);
	    AppGameContainer appgc;
	    try {
	        appgc = new AppGameContainer(new CandyGame());
	        appgc.setDisplayMode(800, 600, false);
	        appgc.setTitle("TestApp");
	        appgc.start();
	    }
	    catch(SlickException e) {
	        e.printStackTrace();
	    }

	}
}
