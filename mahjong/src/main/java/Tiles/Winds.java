package Tiles;

public class Winds extends Tile{
    private int value;
	public Winds(int id, int value) {
		super(id, value);
        this.value = value;
	}
    public String getImage(){
        return "/res/tiles/winds/wind"+value+".png";

    }
}
