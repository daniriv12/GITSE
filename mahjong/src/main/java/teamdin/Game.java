package teamdin;

import java.util.*;

import Tiles.*;


public class Game {

	private static ArrayList<Tile> deck;
	private static LinkedList<Player> players;
	private Tile lastDiscardedTile;
	private final int INITIAL_POINTS = 60;
	private int currentTurn;

	public Game() {
		players = new LinkedList<Player>();
		
		for (int i = 0; i < getNumberOfPlayers(); i++) {
			players.push(new Player(i, INITIAL_POINTS));
		}
		
		deck = new ArrayList<Tile>();
		
		generateDeck();
		shuffleUpAndDeal();
		selectStarter();
		
	}
	
	
/**
 * Author: Gustavo
 * 
 * Create a deck of 136 tiles:
 * 	9 x 4 circles
 * 	9 x 4 characters
 *  9 x 4 bamboos
 * 	3 x 4 dragons
 * 	4 x 4 winds
 */
	public static void generateDeck(){
		
		int id = 0;
		for(int x = 1; x <= 9 ; x++){
			for(int y = 1; y <=4;y++){
				deck.add(new Bamboo(id, x));
				id++;
			}
		}
		for(int x = 1; x <= 9 ; x++){
			for(int y = 1; y <=4;y++){
				deck.add(new Characters(id, x));
				id++;
			}
		}
		for(int x = 1; x <= 9 ; x++){
			for(int y = 1; y <=4;y++){
				deck.add(new Circle(id, x));
				id++;
			}
		}
		for(int x = 1; x <= 5 ; x+=2){
			for(int y = 1; y <=4;y++){
				deck.add(new Dragon(id, x));
				id++;
			}
		}
		for(int x = 1; x <= 7 ; x+=2){
			for(int y = 1; y <=4;y++){
				deck.add(new Winds(id, x));
				id++;
			}
		}
	}
	
	/**
	 * Author: Gustavo
	 * 
	 * Shuffle the deck a distributes the tile to the 2-4 players
	 */
	public static void shuffleUpAndDeal() {
		
		Collections.shuffle(deck);
		
		int TilesPerhand = 13;
		
		for (int x = 1; x <=13; x++){
			for(Player player : players){
				Tile tile = deck.remove(deck.size()-1);
				player.addTileToHand(tile);
			}
		}
		System.out.println("Remaining tils in deck: "+ deck.size()+" tiles");
		for(Player player : players){
			System.out.println("Player "+player.getId()+":  " + player.getHand().size()+" tiles");
			for (Tile tile : player.getHand())  {
				System.out.print(tile.getId() + " ");
			}

		}
	}
	


	public void selectStarter() {
		Random rand = new Random();
		currentTurn = rand.nextInt(getNumberOfPlayers());
		System.out.println("currentTurn: " + currentTurn);
		nextTurn();
	}

	public void giveDeckTile(Player p) {

	}

	public void getDiscardedTile(Tile tile) {

	}

	public void nextTurn() {
		Player inTurn = players.get(currentTurn);
		// TODO setTurn missing in class Player
		// inTurn.setTurn(true);
	}

	public int getNumberOfPlayers() {
		return 4;
	}
	
	public Player getPlayer(){
		return players.get(0);
	}

//	public static void main(String[] args) {
//		Game g = new Game();
//		generateDeck();
//		shuffleUpAndDeal();
//		g.selectStarter();
//	}
}
