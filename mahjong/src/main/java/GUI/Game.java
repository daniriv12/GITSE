package GUI;

import java.awt.Toolkit;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.apple.eawt.Application;
public class Game extends StateBasedGame{
	
	public static final String name = "Mahjong";
	public static int menu = 0;
	public static int options = 1;
	public static int match = 2;
	public static AppGameContainer appgc;
	public Game(String name){
		super(name);
		this.addState(new Menu(menu));
		this.addState(new Options(options));
		this.addState(new Match(match));

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		this.getState(options).init(container, this);
		this.getState(match).init(container, this);
		
		this.enterState(menu);
	}
	
	public static void main(String[] args){
		
		
		//appgc.setIcon(ref); to set an icon in the future
		
		try{
			appgc = new AppGameContainer(new Game(name), 1000, 700, false);
			//these three lines are just to change the icon on dock
			Application application = Application.getApplication();
			java.awt.Image image = Toolkit.getDefaultToolkit().getImage("res/icon.png");
			application.setDockIconImage(image);
			appgc.setShowFPS(false);
		
			appgc.start();
			
			
			
			
			
		}catch(SlickException ex){
			ex.printStackTrace();
		}
	}
}
