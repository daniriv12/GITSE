package Tiles;

public class Dragon extends Tile{
    private int value;
	public Dragon(int id, int value) {
		super(id, value);
        this.value = value;
	}
    public String getImage(){
        return "/res/tiles/dragons/dragon"+value+".png";

    }
}
