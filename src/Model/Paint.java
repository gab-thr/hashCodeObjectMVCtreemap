package Model;

public abstract class Paint {
	protected char[][] tab;
	protected int x1;
	protected int y1;
	public static final char PAINT = '#';
	public static final char BLANK = '.';
	
	public Paint(int x1,int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public abstract void paint(char[][] tab);
	
	public abstract int getLength();

	public abstract void erase(char[][] tab);
	
}
