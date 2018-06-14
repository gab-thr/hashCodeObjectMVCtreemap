package View;

import Controller.Controller;
import Model.Model;
import Model.Paint;

import javax.swing.*;

import java.awt.*;

public class View {
	private Controller controller;
	private Model model;
	
	public JFrame frame;
	private JPanel[][] board = null;
	
	public static final int IMG_SIZE = 20;
	
	public View() {
		frame = new JFrame();
		frame.setTitle("HashCode");
		frame.setLocation(250, 350);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(1615, 320);
		frame.setResizable(true);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	} 
	public void setModel(Model model) {
		this.model = model;
	} 
	
	public static void printTab(char[][] tab) {
    	for (int i =0; i<tab.length;i++) {
    		System.out.println(tab[i]);
    	}
    	System.out.println();
	}
	
	public void displayTab(char[][] tab) {
		frame.getContentPane().removeAll();
		board = new JPanel[tab.length][tab[0].length];
		for (int i = 0; i < board.length; i++) {
			 for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new JPanel();
				board[i][j].setBounds(j * IMG_SIZE, i * IMG_SIZE, IMG_SIZE, IMG_SIZE);
				if(tab[i][j] == Paint.PAINT) {
					board[i][j].setBackground(Color.BLACK);
				}
				frame.getContentPane().add(board[i][j]);
			 }
		}
		
		frame.setVisible(true);
	}
	
	public void nbCoups() {
		System.out.println("Nombre de coups: " + Model.nbCoups);
		System.out.println();
	}

	public void compareTabs(Model tab, Model tab2) {
		if (Controller.compare(tab.getTab(),tab2.getTab())==true) {
			System.out.println("Vrai");
		}
		else  {
			System.out.println("Faux");
		}
	}
}
