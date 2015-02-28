package Tiles;

public class Characters extends Tile{
    private int value;
	public Characters(int id, int value) {
		super(id, value);
        this.value = value;
	}
    public String getImage(){
        return "/res/tiles/man/man"+value+".png";

    }

}
