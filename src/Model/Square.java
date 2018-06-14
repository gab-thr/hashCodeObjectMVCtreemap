package Model;

public class Square extends Paint {

	protected int s;
	
	public static final int squareFullSize = 3;
	
	public static final int size = 1;
	
	public Square(int x1, int y1, int s) {
		super(x1, y1);
		
		this.s = s;
	}
	
	public void paint(char[][] tab) {
		
    	if (s == 0) {
    		tab[x1][y1] = PAINT;
    	}
    	else {
    	x1 = x1 - s;
    	y1 = y1 - s;
    	s = (2 * s) + 1;
    	
		for(int i = x1; i < (x1+s); i++) {
			for (int j = y1; j < (y1+s); j++) {
				tab[i][j] = PAINT;
				}
			}
    	}
	}
	
	public void P_SQUARE(int a, int b, int c) {
		System.out.println("P_SQUARE " + a + " " + b + " " + c);
	}

	@Override
	public int getLength() {
		return s;
	}

	@Override
	public void erase(char[][] tab) {
		// TODO Auto-generated method stub
		
	}

}
