package game;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Game {
	private boolean antiAlias = true;

	
	Player player;
	private TrueTypeFont font;
	private Font testFont = new Font("TimesRoman",Font.BOLD, 24);
	boolean debugToggle = false;

	
	public Game(){
		player = new Player();

	}


	public TrueTypeFont getFont() {
		return font;
	}


	public void setAwtFont(TrueTypeFont awtFont) {
		this.font = awtFont;
	}
	
	public void start() throws LWJGLException{
		initGL(800,600);
		init();
		while(true){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			render();
			Display.update();

			Display.sync(100);
			
			
			if (Display.isCloseRequested()){
				Display.destroy();
				System.exit(0);
				
			}
			
		}
	}
	private void initGL(int width, int height) {
		try {
		Display.setDisplayMode(new DisplayMode(width,height));
		Display.create();
		Display.setVSyncEnabled(true);
		Display.setResizable(true);
		} catch (LWJGLException e) {
		e.printStackTrace();
		System.exit(0);
		}
		 
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);       
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);                   
		 
		GL11.glClearColor(1f, 1f, 1f, 0.0f);               
		GL11.glClearDepth(1);                                      
		 
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		 
		GL11.glViewport(0,0,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
	
	public void init() throws LWJGLException {
		// load a default java font
		Mouse.create();
		Keyboard.enableRepeatEvents(false);

		try {
			Keyboard.create();

			
			InputStream inputStream	= getClass().getResourceAsStream("/resources/Arial.ttf");
	 
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font = new TrueTypeFont(awtFont2, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		 
		}
	
	
	public void render() throws LWJGLException {
		handleInputs();
		if(debugToggle){
			if(Mouse.isInsideWindow()){
			font.drawString(20, 20, "x = " + Mouse.getX() + " | y = " + Mouse.getY(), Color.black);
			}
			else{
				font.drawString(20, 20, "Out", Color.black);
			}
		}
	}
	
	public void handleInputs(){
		
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_F1) {
					debugToggle = !debugToggle;
				}
			}
		}
		
	}
}
	
	




