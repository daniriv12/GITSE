package teamdin;
import java.util.*;

import Tiles.*;

/**
 * 
 * @author Andreia & Din
 *
 */

public class Player {
	private ArrayList<Tile> hand;
	private ArrayList<Tile> melds;
	private ArrayList<Tile> discardedTiles;
	private int id;
	private int points;
	public Player(int id, int points) {
		hand = new ArrayList<Tile>();
		melds = new ArrayList<Tile>();
		discardedTiles = new ArrayList<Tile>();
		this.id = id;
		this.points = points;
	}
	
	/** 
	 * Returns the current hand of the player
	 * @param -
	 * @return ArrayList<Tile>
	 */
	public ArrayList<Tile> getHand() {
		return hand;
	}
	
	/** 
	 * Sets the starting hand of the player
	 * @param ArrayList<Tile>
	 * @return -
	 */
	public void firstHand(ArrayList<Tile> first_Hand) {
		if (first_Hand.size() > 0) {
			hand = first_Hand;
		}
	}
	
	/** 
	 * Adds a single tile to the players hand
	 * @param Tile
	 * @return -
	 */
	public void addTileToHand(Tile new_Tile) {
		if (new_Tile != null) {
			hand.add(new_Tile);
		}
	}
	
	/** 
	 * Removes a single tile from the players hand
	 * @param Tile
	 * @return -
	 */
	public void removeHandTile(Tile discarded_Tile) {
		if (discarded_Tile != null) {
			removeTileFromArray(discarded_Tile, hand);
		}
	}
	
	/** 
	 * Returns the array of made melds
	 * @param -
	 * @return ArrayList<Tile>
	 */
	public ArrayList<Tile> getMelds() {
		return melds;
	}
	
	/** 
	 * Adds a meld to the array
	 * @param ArrayList<Tile>
	 * @return -
	 */
	public void addMeld(ArrayList<Tile> new_TileMeld){
//		TODO: if (new_TileMeld.isValid())
		for(Tile tile : new_TileMeld) {
			Tile tileFromHand = getTile(tile.getId(), hand);
			removeHandTile(tileFromHand);
			melds.add(tile);
		}
	}
	
	/** 
	 * Returns the array of this player's discarded tiles
	 * @param -
	 * @return ArrayList<Tile>
	 */
	public ArrayList<Tile> getDiscardedTiles() {
		return discardedTiles;
	}
	
	/** 
	 * Adds a tile to this player's discarded tiles
	 * @param Tile
	 * @return -
	 */
	public void addDiscardedTile(Tile discarded_Tile) {
		if (discarded_Tile != null) {
			removeHandTile(discarded_Tile);
			discardedTiles.add(discarded_Tile);
		}
	}
	
	/** 
	 * Removes a tile from this player's discarded tiles (has been eaten by another player)
	 * @param Tile
	 * @return -
	 */
	public void removeDiscardedTile(Tile eaten_Discarded_Tile) {
		if (eaten_Discarded_Tile != null) {
			removeTileFromArray(eaten_Discarded_Tile, discardedTiles);
		}
	}
	
	/** 
	 * Returns this player's Id
	 * @param -
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/** 
	 * Returns this player's current total accumulated points
	 * @param -
	 * @return int
	 */
	public int getPoints() {
		return points;
	}
	
	/** 
	 * Swaps two tiles within this player's hand
	 * @param int, int
	 * @return -
	 */
	public void swapTiles(int index_tile1,int index_tile2) {
		Collections.swap(hand, index_tile1, index_tile2);
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
	
	/** 
	 * Helper function to return a specific Tile from an array of tiles.
	 * @param -
	 * @return Tile
	 */
	private Tile getTile(int idTile, ArrayList<Tile> listTiles) {
		for(Tile tile : listTiles) {
			if(tile.getId() == idTile) {
				return tile;
			}
		}
		return null;
	}

	/** 
	 * Helper function to remove a specific Tile from an array of tiles.
	 * @param -
	 * @return Tile
	 */
	private void removeTileFromArray(Tile tile_to_remove, ArrayList<Tile> listTiles) {
		int index = getTileIndex(tile_to_remove.getId(), listTiles);
		if(index != -1) {
			listTiles.remove(index);
		}
	}
	
}
