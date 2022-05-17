package newcassonne;

public class TileSet {
	private int id;
	private int x;
	private int y;
	
	public TileSet(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public int getId() {
		return id;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
}
