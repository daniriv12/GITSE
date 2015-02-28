package Tiles;

public abstract class Tile {

	private int id;
	private int value;
	
	public Tile(int id, int value) {
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getValue() {
		return value;
	}
    public String getImage(){
        return null;
    }
}
