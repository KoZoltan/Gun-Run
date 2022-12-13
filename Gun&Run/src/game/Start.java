package game;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Start {

	

	public static void main(String[] args){
		
		Game2 gamer = new Game2();
		JFrame firstwindow = new JFrame("Load");
		firstwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstwindow.setResizable(true);
		firstwindow.add(gamer);
		firstwindow.pack();
		firstwindow.setLocationRelativeTo(null);
		firstwindow.setVisible(true);
		gamer.start();
		
		String name = JOptionPane.showInputDialog("Enter player name");
		UserData.setUsername(name);
		Game game = new Game();
		
		JFrame window = new JFrame("Gun&Run");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}