package game;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Game {
	private boolean antiAlias = true;

	
	Player player;
	private UnicodeFont font;
	private Font testFont = new Font("TimesRoman",Font.BOLD, 24);
	
	public Game(){
		player = new Player();

	}


	public UnicodeFont getFont() {
		return font;
	}


	public void setAwtFont(UnicodeFont awtFont) {
		this.font = awtFont;
	}
	
	public void start(){
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
		} catch (LWJGLException e) {
		e.printStackTrace();
		System.exit(0);
		}
		 
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);       
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);                   
		 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);               
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
	
	public void init() {
		// load a default java font
		font = new UnicodeFont(testFont);
		 
		}
	public void render() {
		font.drawString(100, 50, "THE LIGHTWEIGHT JAVA GAMES LIBRARY", Color.white);
		}
	
	public static void main(String[] argv) {
		Game fontExample = new Game();
		fontExample.start();
		}


}
