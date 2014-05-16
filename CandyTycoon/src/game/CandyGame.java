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

public class CandyGame extends BasicGame implements Game{
		
	private boolean antiAlias = true;

	Input input = new Input(Display.getHeight());
	Player player;
	private TrueTypeFont font;
	private Font testFont = new Font("TimesRoman",Font.BOLD, 12);
	boolean debugToggle = false;

	
	public CandyGame(){
		super("TestGame");
		player = new Player();
	}


	public TrueTypeFont getFont() {
		return font;
	}


	public void setAwtFont(TrueTypeFont awtFont) {
		this.font = awtFont;
	}
	
	public void handleInputs(){
		
		if (input.isKeyPressed(input.KEY_F1)) {
			debugToggle = !debugToggle;
			System.out.println("YES");
		}
		
	}
	public void redrawContents(){
		if (Display.wasResized()) {
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
		}

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
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
		// load a default java font
		try {
			Mouse.create();
			Keyboard.enableRepeatEvents(false);
			System.out.println(Display.getDisplayMode().isFullscreenCapable());

			Keyboard.create();
			
			InputStream inputStream	= getClass().getResourceAsStream("/resources/Arial.ttf");
	 
			Font awtFont2;
			awtFont2 = testFont;
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font = new TrueTypeFont(awtFont2, false);
	 
		} catch (LWJGLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		if(debugToggle){

			if(Mouse.isInsideWindow()){
				font.drawString(0, 20, "x = " + Mouse.getX() + " | y = " + Mouse.getY(), Color.white);
			}
			else{
				font.drawString(0, 20, "Out", Color.white);
			}
			if(input.isMouseButtonDown(0)){
				if(Mouse.isInsideWindow()){
					font.drawString(0, 20, "x = " + Mouse.getX() + " | y = " + Mouse.getY(), Color.red);
				}
				else{
					font.drawString(0, 20, "Out", Color.red);
				}
			}
		}
		
	}


	public void update(GameContainer container, int delta)
			throws SlickException {
		// TODO Auto-generated method stub


		
	}
	
	public void keyPressed(int key, char c){
		switch (key){
		case Input.KEY_F1:debugToggle = !debugToggle;break;
		}
	}







}
	
	




