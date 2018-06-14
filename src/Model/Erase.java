package Model;

public class Erase extends Paint {

	public Erase(int x1, int y1) {
		super(x1, y1);
	}
	
	public void paint(char[][] tab) {
		tab[x1][y1] = BLANK; 	
	}
	
	public void E_CELL(int a, int b) {
		System.out.println("E_CELL " + a + " " + b);
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void erase(char[][] tab2) {
		// TODO Auto-generated method stub
		
	}

}
