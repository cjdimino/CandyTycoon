package states;

import game.Player;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState implements GameState {
	Input input = new Input(Display.getHeight());
	boolean debugToggle = false;

	private TrueTypeFont font;
	private Font testFont = new Font("TimesRoman",Font.BOLD, 12);
	private int state;
	
	
	public Menu(int state){
		this.setState(state);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		// load a default java font
				try {
					Mouse.create();
					Keyboard.enableRepeatEvents(false);
					System.out.println(Display.getDisplayMode().isFullscreenCapable());

					Keyboard.create();
					
					Font awtFont2;
					awtFont2 = testFont;
					awtFont2 = awtFont2.deriveFont(12f); // set font size
					font = new TrueTypeFont(awtFont2, false);
			 
				} catch (LWJGLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		if(debugToggle){
			font.drawString(0, 0, "FPS: " + container.getFPS(), Color.white);
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

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.state;
	}
	
	public void handleInputs(){
		
		if (input.isKeyPressed(input.KEY_F1)) {
			debugToggle = !debugToggle;
			System.out.println("YES");
		}
		
	}
	public void keyPressed(int key, char c){
		switch (key){
		case Input.KEY_F1:debugToggle = !debugToggle;break;
		}
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}


}
