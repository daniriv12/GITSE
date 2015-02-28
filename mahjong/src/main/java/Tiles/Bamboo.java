package Tiles;

public class Bamboo extends Tile{
    int value;
	public Bamboo(int id, int value) {
		super(id, value);
        this.value = value;
	}
    public String getImage(){
        return "/res/tiles/bamboo/bamboo"+value+".png";

    }
}
