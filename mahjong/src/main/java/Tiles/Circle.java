package Tiles;

public class Circle extends Tile{
    private int value;
	public Circle(int id, int value) {
		super(id, value);
        this.value = value;
	}
    public String getImage(){
        return "/res/tiles/pin/pin"+value+".png";

    }
}
