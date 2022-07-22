import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountPage {
	private static JLabel userLabel,passwordLabel,idLabel;
	private static JTextField userText,idText;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel message;
	private static JPanel panel = new JPanel();
	private static JFrame frame = new JFrame();
	
	public void writeInDatabase(String ID,String user,String password) {
		// write into file
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("src//Excel//MedicalData.csv", true);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// using FileWrite
		BufferedWriter writer = new BufferedWriter (fileWriter);
		   try {
			   writer.write(user+';');
			   writer.write(password+';');
			   writer.write(ID);
			   writer.newLine();   
		   }
		catch (IOException e) {

		      e.printStackTrace();
		}

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int numOfDigitsInString(String str) {
        int digits = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
                digits++;
        }
        return digits;
	}
	 public int countSpecialChar(String userInput) {
	        if (userInput == null || userInput.trim().isEmpty()) {
	          return 0;
	        }
	        int countSpecial = 0;

	        for (int i = 0; i < userInput.length(); i++) {
	        	switch(userInput.charAt(i)) {
	        	  case ',':
	        	    countSpecial++;
	        	    break;
	        	  case '.':
	        		countSpecial++;
	        	    break;
	        	  case '?':
		        		countSpecial++;
		        	    break;
	        	  case ';':
		        		countSpecial++;
		        	    break;
	        	  case ':':
		        		countSpecial++;
		        	    break;
	        	  case '/':
		        		countSpecial++;
		        	    break;
	        	  case '!':
		        		countSpecial++;
		        	    break;
	        	  case '§':
		        		countSpecial++;
		        	    break;
	        	  case '%':
		        		countSpecial++;
		        	    break;
	        	  case '$':
		        		countSpecial++;
		        	    break;
	        	  case '£':
		        		countSpecial++;
		        	    break;
	        	  case '&':
		        		countSpecial++;
		        	    break;
	        	  case '"':
		        		countSpecial++;
		        	    break;
	        	  case '#':
		        		countSpecial++;
		        	    break;
	        	  case '{':
		        		countSpecial++;
		        	    break;
	        	  case '(':
		        		countSpecial++;
		        	    break;
	        	  case '[':
		        		countSpecial++;
		        	    break;
	        	  case '-':
		        		countSpecial++;
		        	    break;
	        	  case '|':
		        		countSpecial++;
		        	    break;
	        	  case '_':
		        		countSpecial++;
		        	    break;
	        	  case '@':
		        		countSpecial++;
		        	    break;
	        	  case ')':
		        		countSpecial++;
		        	    break;
	        	  case ']':
		        		countSpecial++;
		        	    break;
	        	  case '=':
		        		countSpecial++;
		        	    break;
	        	  case '+':
		        		countSpecial++;
		        	    break;
	        	  case '}':
		        		countSpecial++;
		        	    break;
	        	  case '*':
		        		countSpecial++;
		        	    break;
	        	}
	        }
	        return countSpecial;
	        }
	 
	public void showWindow2() {
		
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
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
		
		idLabel = new JLabel("ID");
		idLabel.setBounds(10,80,80,25);
		panel.add(idLabel);
		
		idText = new JTextField();
		idText.setBounds(100,80,165,25);
		panel.add(idText);
		
		button = new JButton("Create Account");
		button.setBounds(80,150,200,25);
		message = new JLabel("");
		message.setBounds(10,60,1000,300);
		panel.add(message);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = userText.getText();
				String password = passwordText.getText();
				String ID = idText.getText();
				
				if (user.length()>=6 && user.length()<=8 && numOfDigitsInString(user)<=2 && password.length()>=8 && password.length() <=10 
						&& numOfDigitsInString(password)<=1 && countSpecialChar(password)<=1) {
					System.out.println("Your account has been created!");
					message.setText("Your account has been created!");
					writeInDatabase(ID,user,password);
					frame.setVisible(false);
					
					
				}
				else {
					
					message.setText("Username must have between 6 and 8 characters, Password must have between 8 and 10 characters and must countain at least 1 digit and 1 special character");
				}
			}
			
		});
		panel.add(button);
		frame.setVisible(true);
	}
}
