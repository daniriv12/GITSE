package teamdin;

import java.util.ArrayList;

import Tiles.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * @author Andreia & Din
 *
 */

public class PlayerTest extends TestCase {

	ArrayList<Tile> Tiles;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlayerTest( String testName ) {
        super( testName );
        Tiles = new ArrayList<Tile>();
    	Tiles.add(new Bamboo(20,1));
    	Tiles.add(new Bamboo(19,2));
    	Tiles.add(new Bamboo(18,3));
    	Tiles.add(new Bamboo(17,4));
    	Tiles.add(new Bamboo(16,5));
    	Tiles.add(new Bamboo(15,6));
    	Tiles.add(new Bamboo(14,7));
    	Tiles.add(new Bamboo(13,8));
    	Tiles.add(new Bamboo(12,9));
    	Tiles.add(new Bamboo(11,10));
    	Tiles.add(new Bamboo(10,11));
    	Tiles.add(new Bamboo(9,12));
    	Tiles.add(new Bamboo(8,13));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( PlayerTest.class );
    }

    public void test_getHand() {
    	Player p = new Player(1, 0);
    	assertTrue(p.getHand().size() == 0);
    }
    
    public void test_firstHand() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	assertTrue(p.getHand().size() == 13);
    }
    
    public void test_addTileToHand() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	Tile t1 = new Bamboo(50,100);
    	p.addTileToHand(t1);
    	assertTrue(p.getHand().size() == 14);
    }
    
    public void test_removeHandTile() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	Tile t1 = new Bamboo(14,7);
    	p.removeHandTile(t1);
    	assertTrue(p.getHand().size() == 12);
    	ArrayList<Tile> remainingTiles = p.getHand();
    	assertFalse(checkTileInArray(t1.getId(), remainingTiles));
    }
    
    public void test_getMelds() {
    	Player p = new Player(1, 0);
    	assertTrue(p.getMelds().size() == 0);
    }
    
    public void test_addMelds() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	ArrayList<Tile> TilesMeld = new ArrayList<Tile>();
    	p.addMeld(TilesMeld);
    	assertTrue(p.getMelds().size() == 0);
    	TilesMeld.add(new Bamboo(20, 1));
    	TilesMeld.add(new Bamboo(15, 6));
    	TilesMeld.add(new Bamboo(10, 11));
    	p.addMeld(TilesMeld);
    	assertTrue(p.getHand().size() == 10);
    	assertTrue(p.getMelds().size() == 3);
    	assertTrue(checkTilesNotInArray(TilesMeld, p.getHand()));
    	assertTrue(checkTilesInArray(TilesMeld, p.getMelds()));
    }
    
    public void test_getDiscardedTiles() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	assertTrue(p.getDiscardedTiles().size() == 0);
    }
    
    public void test_addDiscardedTile() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	Tile tileDiscarded = new Bamboo(14,7);
    	p.addDiscardedTile(tileDiscarded);
    	assertTrue(p.getDiscardedTiles().size() == 1);
    	assertTrue(p.getHand().size() == 12);
    	assertFalse(checkTileInArray(tileDiscarded.getId(), p.getHand()));
    	assertTrue(checkTileInArray(tileDiscarded.getId(), p.getDiscardedTiles()));
    }
    
    public void test_removeDiscardedTile() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	Tile tileDiscarded = new Bamboo(14,7);
    	Tile tile2Discarded = new Bamboo(15,6);
    	p.addDiscardedTile(tileDiscarded);
    	p.addDiscardedTile(tile2Discarded);
    	assertTrue(p.getDiscardedTiles().size() == 2);
    	assertTrue(p.getHand().size() == 11);
    	p.removeDiscardedTile(tile2Discarded);
    	assertTrue(p.getDiscardedTiles().size() == 1);
    	assertTrue(checkTileInArray(tileDiscarded.getId(), p.getDiscardedTiles()));
    	assertFalse(checkTileInArray(tile2Discarded.getId(), p.getDiscardedTiles()));
    }
    
    
    public void test_getId() {
    	Player p = new Player(1, 0);
    	assertTrue(p.getId() == 1);
    }
    
    public void test_swapTiles() {
    	Player p = new Player(1, 0);
    	p.firstHand(Tiles);
    	int index1 = 4;
    	int index2 = 6;
    	int idTile1 = p.getHand().get(index1).getId();
    	int idTile2 = p.getHand().get(index2).getId();
    	p.swapTiles(index1, index2);
    	assertTrue(p.getHand().get(index2).getId() == idTile1);
    	assertTrue(p.getHand().get(index1).getId() == idTile2);    	
    }
    
    
    
    
	/** 
	 * Helper function to check if (given a tileId) a specific tile is in an array of tiles
	 * @param -
	 * @return boolean
	 */
    
    public boolean checkTileInArray(int tileId, ArrayList<Tile> tiles) {
    	for(Tile tile : tiles) {
    		if(tile.getId() == tileId) {
    			return true;
    		}
    	}
    	return false;
    }

	/** 
	 * Helper function to check if (given a tile) a specific tile is in an array of tiles
	 * @param -
	 * @return boolean
	 */
    
    public boolean checkTilesInArray(ArrayList<Tile> tilesForCheck, ArrayList<Tile> tiles) {
    	for(Tile tile : tilesForCheck) {
    		if(!checkTileInArray(tile.getId(), tiles)) {
    			return false;
    		}
    	}
    	return true;
    }
    
	/** 
	 * Helper function to check if (given a tile) a specific tile is NOT in an array of tiles
	 * @param -
	 * @return boolean
	 */
    
    public boolean checkTilesNotInArray(ArrayList<Tile> tilesForCheck, ArrayList<Tile> tiles) {
    	for(Tile tile : tilesForCheck) {
    		if(checkTileInArray(tile.getId(), tiles)) {
    			return false;
    		}
    	}
    	return true;
    }
    
	/** 
	 * Helper function to return an index of a specific tile.
	 * @param -
	 * @return int
	 */
	private int getTileIndex(int idTile, ArrayList<Tile> listTiles) {
		int index = 0;
		while(index < listTiles.size()) {
			if(listTiles.get(index).getId() == idTile) {
				return index;
			}
			index++;
		}
		return -1;
	}
    
}
