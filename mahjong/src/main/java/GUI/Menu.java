package GUI;



import org.lwjgl.input.Mouse;

import teamdin.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	Image i;
	float mouseX, mouseY;
	Sound click;
	
	public Menu(int state){
		
	}

	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		i = new Image("/res/tiles/bamboo/bamboo1.png");
		click = new Sound("res/mouse1.wav");
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.setBackground(Color.black);
		g.drawString("Start", 480, 425);
		g.drawRect(400, 410, 200, 50);
		i.draw(465,260,70,70);
		g.drawString("MAHJONG", 470, 110);
		g.drawString("Welcome to TeamDin's game!", 400, 160);
		g.drawString("Version 1.0", 400, 180);
		

		
		
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		
		if((mouseX > 400 && mouseX < 600)&& (mouseY > 240 && mouseY < 290)){
			
			if(Mouse.isButtonDown(0)){
				
				click.play();
			
				sbg.enterState(2);
			}
		}
		
	}

	@Override
	public int getID() {
		
		return 0;
	}

}
