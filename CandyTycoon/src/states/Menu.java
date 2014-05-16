package states;

import game.CandyGame;
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
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState implements GameState {
	Input input = new Input(Display.getHeight());
	boolean debugToggle = false;
	

	private TrueTypeFont font;
	private int state;
	
	public Menu(int state){
		this.setState(state);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		// load a default java font
		Font awtFont2= new Font("TimesRoman",Font.BOLD, 12);
		font = new TrueTypeFont(awtFont2, false);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setBackground(Color.white);
		
		g.setColor(Color.black);
		Rectangle butt1 = new Rectangle(container.getWidth()/2, container.getHeight()/2, 50, 50);
		g.fill(butt1);
		
		if(butt1.contains((float)input.getMouseY(),(float)(input.getMouseX()))){
			if(input.isMouseButtonDown(0)){
				game.enterState(CandyGame.level1);
			}
		}
	
		if(debugToggle){
			drawDebug(container);			
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
	
	public void drawDebug(GameContainer container){
		font.drawString(0, 0, "FPS: " + container.getFPS(), Color.black);

		if(Mouse.isInsideWindow()){
			font.drawString(0, 20, "x = " + Mouse.getX() + " | y = " + Mouse.getY(), Color.black);
		}
		else{
			font.drawString(0, 20, "Out", Color.black);
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
