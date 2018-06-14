package Controller;

import java.util.List;

import Model.Line;
import Model.Model;
import Model.Paint;
import Model.Square;
import View.View;

import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class Controller {
	private Model model;
	private View view;
	
	
	
	public Controller(Model model,View view) {
		this.model = model;
		this.view = view;
	}

	public static boolean compare(char[][] tab, char[][]tab2) {
    	for (int i=0; i<tab.length;i++) {
    		for (int j=0; j<tab[0].length;j++) {
    			if (tab[i][j]!=tab2[i][j]) {
    				System.out.println("Erreur à:" + i + "|"+ j);
    				return false;
    			}
    		}
    	}
		return true;
    }
    
	public static void findSolutionLine(char[][] tab, List<Paint>[] cmds) {
		for (int row = 0; row<tab.length;row++) {
			findSolutionOneLine(tab[row], row, cmds);
		}
	}
	
	public static void findSolutionOneLine(char[] line, int numLine, List<Paint>[] cmds) {
		int i=0;
		boolean block = false;
		int startBlock = 0;
		int lenBlock =0;

		while(i<line.length) {
			if(line[i]==Paint.PAINT) {
				if(block == false) {
					block=true;
					startBlock = i;
					lenBlock=0;
				}
				else {
					lenBlock++;
				}
			}else {
				if(block == true) {
					cmds[lenBlock].add(new Line(numLine, startBlock, numLine, startBlock + lenBlock, lenBlock));
					Model.tmap.put(lenBlock, cmds[lenBlock]);
				}
				block = false;
			}
			
			i++;			
		}
		
		// Si un bloc touche la fin de la line
		if(block == true) {
			cmds[lenBlock].add(new Line(numLine, startBlock, numLine, startBlock + lenBlock, lenBlock));
			Model.tmap.put(lenBlock, cmds[lenBlock]);
		}
	}
	
	public static void findSolutionColumn(char[][] tab, List<Paint>[] cmds) {
		for (int column = 0; column<tab[0].length;column++) {
			findSolutionOneColumn(tab, column, cmds);
		}
	}

	private static void findSolutionOneColumn(char[][] tab, int numColumn, List<Paint>[] cmds) {
		int i = 0;
		boolean block = false;
		int startBlock = 0;
		int lenBlock=0;
		
		while (i<tab.length) {
			if (tab[i][numColumn] == Paint.PAINT) {
				if (block == false) {
					block = true;
					startBlock = i;
					lenBlock = 0;
				}
				else {
					lenBlock++;
				}
			} 
			else {
				if(block == true) {
					cmds[lenBlock].add(new Line(startBlock, numColumn, startBlock + lenBlock, numColumn, lenBlock));
					Model.tmap.put(lenBlock, cmds[lenBlock]);
				}
				block = false;
			}	
			i++;
		}
		
		// Si un bloc touche la fin de la colonne
		if(block == true) { 
			cmds[lenBlock].add(new Line(startBlock, numColumn, startBlock + lenBlock, numColumn, lenBlock));
			Model.tmap.put(lenBlock, cmds[lenBlock]);
		}
	}
	
//	public static void updateTab(char[][] tab, List<Paint> cmds) {
//		paintTab(tab, cmds);
//		cmds.remove(0);
//	}
//	
	public static void findSolutionSquare(char[][] tab, List<Paint> cmds) {
		for (int row = 0; row<tab.length - (Square.squareFullSize - 1);row++) {
			for (int column = 0; column < tab[0].length - (Square.squareFullSize - 1);column++) {
				findSolutionOneSquare(tab, row, column, cmds);
			}
		}
	}

	private static void findSolutionOneSquare(char[][] tab, int row, int column, List<Paint> cmds) {
		int nb = 0;
		for (int sizeSquareL = row; sizeSquareL < row + Square.squareFullSize; sizeSquareL++ ) {
			for (int sizeSquareC = column; sizeSquareC < column + Square.squareFullSize; sizeSquareC++) {
				if (tab[sizeSquareL][sizeSquareC] == Paint.PAINT) {
					nb++;
				}
				else {
					continue;
				}
			}
		}
		if (nb == Square.squareFullSize * Square.squareFullSize) {
			cmds.add(new Square(row + Square.size, column + Square.size, Square.size));
			
			for (int sizeSquareL = row; sizeSquareL < row + Square.squareFullSize; sizeSquareL++ ) {
				for (int sizeSquareC = column; sizeSquareC < column + Square.squareFullSize; sizeSquareC++) {
					tab[sizeSquareL][sizeSquareC] = Paint.BLANK;
				}
			}
		}
	}
	
	public static void findFinalSolution(char[][] tabIn, char[][] midTab, char[][] tabOut, List<Paint>[] cmds) {
		
		findSolutionLine(tabIn, cmds);
		findSolutionColumn(tabIn, cmds);
		
		
		for (int i = 12; i>=0;i--) {
			while(cmds[i].size() != 0) {
				if (cmds[i] == cmds[7]) {
					continue;
				}
				else {
					paintTab(tabOut,Model.tmap.get(i).get(0));
					eraseP(midTab, Model.tmap.get(i).get(0));
					for(int j = 0; j<cmds.length; j++) {
						cmds[j].clear();
					}
					findSolutionLine(midTab, cmds);
					findSolutionColumn(midTab, cmds);
					
					View.printTab(tabOut);
				}
			}
		}
	}

	public static void paintTab(char[][] tab, Paint paint) {
		Paint p = paint; 
			p.paint(tab);
			Model.nbCoups++;
		
	}

	public static void eraseP(char[][] tab, Paint paint) {
		Paint p = paint;
			p.erase(tab);
		
	}
	
	
}
