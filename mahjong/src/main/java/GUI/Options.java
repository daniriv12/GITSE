package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class Options extends BasicGameState{
	Image i;
	float mouseX, mouseY;
	
	Sound click;
	public Options(int state){
		
	}

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		i = new Image("res/tiles/facedown.png");
		click = new Sound("res/mouse1.wav");
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.black);
		g.setColor(Color.white);
		g.drawString("BACK", 480, 425);
		g.drawRect(400, 410, 200, 50);
		i.draw(465,260,70,70);
		g.drawString("Sorry, not implemented yet.", 390, 110);
		g.drawString("Blame El Mehicano.", 460, 160);
		g.drawString("</3", 490, 180);
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
		
		return 1;
	}

}
