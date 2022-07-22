//DYLANLEV


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;



public class GUI implements ActionListener{
	//GUI
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button,button2;
	private static JLabel message;
	
	private static JPanel panel = new JPanel();
	private static JFrame frame = new JFrame();


	//MAIN
	public static void main(String[] args) {
		System.out.println("[Welcome to the Medical Interface]\n");
		showWindow1();
		
	}
	//Function to show GUI
	public static void showWindow1() {
		
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("Welcome To the Medical Interface. Please Login.");
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		userLabel = new JLabel("User");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		userText = new JTextField();
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(100,80,80,25);
		button.addActionListener(new GUI());
		panel.add(button);
		
		button2 = new JButton("Create an account");
		button2.setBounds(100,110,200,25);

		
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(false);
				CreateAccountPage cap = new CreateAccountPage();
				cap.showWindow2();
			}
			
			
		});
		

		panel.add(button2);
		
		message = new JLabel("");
		message.setBounds(10,200,300,25);
		panel.add(message);

		frame.setVisible(true);
	}
	
	//Verify if user in database
	public static boolean ExistInDatabase() {
		String user = userText.getText();
		String password = passwordText.getText();
		String delimiter = ";";
		try {
		FileReader fr = new FileReader("src//Excel//MedicalData.csv");
		BufferedReader br = new BufferedReader (fr);
		String line = " ";
		String[] tempArr;
		while((line = br.readLine()) != null) {
			tempArr = line.split(delimiter);
			
			
			if(tempArr[0].equals(user) && tempArr[1].equals(password)) {
				
				return true;

			}
			
			
		}
		br.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if (ExistInDatabase()) {
			message.setText("Login successful!");
			MedicalWindow mw = new MedicalWindow();
			frame.setVisible(false);
			
		}
		else {
			message.setText("informations are not correct.");
		}
	}

}
