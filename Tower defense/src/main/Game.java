package main;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	//Use Ctrl + Space to show auto complete!
	
	public Game() {
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tower Defense");
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Start of Tower Defense");
		
		Game game = new Game();
		
	}
}
