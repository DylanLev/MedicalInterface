

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MedicalWindow {
	

	private static final int MAXSIZE = 8;

	private String[] namesArray = new String[MAXSIZE];
	
	//Ctor
	public MedicalWindow() {
		
		JFrame frame = new JFrame();
		
		JButton deconnexionBtn = new JButton("Deconnexion");
		
		frame.setSize(2000,1500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBackground(Color.GRAY);
		
		
		frame.setTitle("Choose a Patient");
		//frame.setBackground(Color.GRAY);
		
		ReadFromPatientDatabase();
		
        JComboBox<String> jComboBox = new JComboBox<>(namesArray);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        deconnexionBtn.setBounds(200,150,150,20);  
         
        frame.add(jComboBox);
        frame.add(jLabel);
		frame.add(deconnexionBtn);
        
        
		
        frame.setLayout(null);
        frame.setSize(350, 250);
        frame.setVisible(true);
        
        
        jComboBox.addActionListener(new ActionListener() {     
            @Override
            public void actionPerformed(ActionEvent e) {
              String index=jComboBox.getSelectedItem().toString(); 
              PatientWindow pw = new PatientWindow(index);
              frame.setVisible(false);
            }
          });
		
        deconnexionBtn.addActionListener(new ActionListener() {     
            @Override
            public void actionPerformed(ActionEvent e) {
              Deconnexion deco = new Deconnexion();
              frame.setVisible(false);
            }
          });
        
       
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	//Names of Patient in Database
	public void ReadFromPatientDatabase(){
		
		String delimiter = ";";
		try {
		FileReader fr = new FileReader("src//Excel//PatientsData.csv");
		BufferedReader br = new BufferedReader (fr);
		String line = " ";
		String first,second;
		line = br.readLine();
		int index=0;
		while((line = br.readLine()) != null) {
			first = line.split(delimiter)[0];
			second = line.split(delimiter)[1];
			namesArray[index++]=(first+" "+second);	
			}
		br.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	
}
