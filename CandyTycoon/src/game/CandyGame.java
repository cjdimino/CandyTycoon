package game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import states.Menu;

public class CandyGame extends StateBasedGame implements Game{
	Player player;

	private boolean antiAlias = true;
	public static final int menu = 0;


	
	public CandyGame(){
		super("TestGame");
		player = new Player();
		this.addState(new Menu(menu));
		
		
		
		
	}

	@Override
	public boolean closeRequested() {
		// TODO Auto-generated method stub
		System.exit(0);
		return false;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
		   this.getState(menu).init(container, this);

		this.enterState(menu);
	}







}
	
	




