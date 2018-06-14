package Model;

public class Line extends Paint {

	protected int x2;
	protected int y2;
	
	protected int length;
	
	public Line(int x1, int y1, int x2, int y2, int length) {		
		super(x1, y1);
		
		this.x2 = x2;
		this.y2 = y2;
		
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public void paint(char[][] tab) {
    	
    	for(int i= x1 ; i<=x2 ; i++) {
    		for(int j=y1 ; j<=y2 ; j++) {
    			tab[i][j] = PAINT;
    		}
    	}
	}
	

	
	public void P_LINE(int a, int b, int c, int d) {
		System.out.println("LINE " + a + " " + b + " " + c + " " + d);
	}

	@Override
	public void erase(char[][] tab) {
    	for(int i= x1 ; i<=x2 ; i++) {
    		for(int j=y1 ; j<=y2 ; j++) {
    			tab[i][j] = BLANK;
    		}
    	}
	}
	
}
