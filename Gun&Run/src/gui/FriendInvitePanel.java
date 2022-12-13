package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import game.AnotherPlayer;
import game.DrawUtils;
import game.Game;
import game.UserData;
import game.invites;

public class FriendInvitePanel extends GuiPanel{

	
	private int buttonWidth = 100;
	private int backButtonWidth = 220;
	private int buttonSpacing = 20;
	private int buttonY = 120;
	private int buttonHeight = 50;
	private int leaderboardsX = 130;
	private int leaderboardsY = buttonY + buttonHeight + 90;
	
	private String title = "Friend_Invite";
	private Font titleFont = Game.main.deriveFont(48f);
	private Font scoreFont = Game.main.deriveFont(30f);
	private State currentState = State.INVITE;
	
	public FriendInvitePanel(){
		super();
		

		GuiButton deleteButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, buttonY, buttonWidth, buttonHeight);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentState = State.DELETE;
			}
		});
		deleteButton.setText("Delete");
		add(deleteButton);
		
		GuiButton inviteButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2 - deleteButton.getWidth() - buttonSpacing, buttonY, buttonWidth, buttonHeight);
		inviteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentState = State.INVITE;
				String name = JOptionPane.showInputDialog("Invite player");
				AnotherPlayer.setUsername(name);
				 try {
				      FileWriter myWriter = new FileWriter("Szerver.txt",true);
				      myWriter.write(UserData.getUsername());
				      myWriter.write(" ");
				      myWriter.write(AnotherPlayer.getUsername());
				      myWriter.write(" ");
				      myWriter.write("PROCESSING");
				      myWriter.write("\n");
				      myWriter.close();
				      
				    } catch (IOException e1) {
				      e1.printStackTrace();
				    }
				 
				 	
				
			}
		});
		inviteButton.setText("Invite");
		add(inviteButton);
		
		GuiButton listFriendButton = new GuiButton(Game.WIDTH / 2 + buttonWidth / 2 + buttonSpacing, buttonY, buttonWidth, buttonHeight);
		listFriendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentState = State.LISTS;
				
				
				
			}
		});
		listFriendButton.setText("Lists");
		add(listFriendButton);
		
		GuiButton backButton = new GuiButton(Game.WIDTH / 2 - backButtonWidth / 2, 500, backButtonWidth, 60);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
		});
		backButton.setText("Back");
		add(backButton);
	}
	
	private void drawLeaderboards(Graphics2D g){
		ArrayList<String> strings = new ArrayList<String>();
		if(currentState == State.LISTS){
			//strings = convertToStrings(null);
		}
		
		
		
		g.setColor(Color.black);
		g.setFont(scoreFont);
		
		for(int i = 0; i < strings.size(); i++){
			String s = (i + 1) + ". " + strings.get(i);
			g.drawString(s, leaderboardsX, leaderboardsY + i * 40);
		}
	}
	
	private ArrayList<String> convertToStrings(ArrayList<? extends Number> list){
		ArrayList<String> ret = new ArrayList<String>();
		for(Number n : list){
			ret.add(n.toString());
		}
		return ret;
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void render(Graphics2D g){
		super.render(g);
		g.setColor(Color.black);
		g.drawString(title, Game.WIDTH / 2 - DrawUtils.getMessageWidth(title, titleFont, g) / 2, DrawUtils.getMessageHeight(title, titleFont, g) + 40);
		drawLeaderboards(g);
	}
	
	private enum State{
		INVITE,
		DELETE,
		LISTS
	}
}
