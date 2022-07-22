

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class PatientWindow{

	//Ctor
	public PatientWindow(String index){
		JFrame frame = new JFrame();
		frame.setSize(2000,1000);
	
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.GRAY);
	   
	    String[][] table= Matrix(Reader(index));
	    
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));	    
	    panel.setSize(2000,2000);
	    
	    
	    	for (int i = 0; i < 20; i++) {
	    	    panel.add(new JLabel(table[0][i]+":  "+table[1][i]));
	    	} 
	   
	    
	    
	    frame.add(panel);
	    frame.setSize(500, 500);
	    frame.setVisible(true);
	    
	    JButton button = new JButton("Diagnosis");
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setBackground(Color.GRAY);
        bottomPanel.add(button);
       
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DiagnosisWindow dw = new DiagnosisWindow(table);
				System.out.println("Patient Data File is created in Excel Package... Please Refresh Excel package");
			}
			
			
		});
        
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
	    
	   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Medical Profile of: "+index);
	    frame.setVisible(true);
	}
	
	
	//Read from database selected patient
	public String[] Reader(String Name){
		String delimiter = ";";
		String rowArr[];
		rowArr = new String[20];
		try {
		FileReader fr = new FileReader("src//Excel//PatientsData.csv");
		BufferedReader br = new BufferedReader (fr);
		String line = " ";
		line = br.readLine();
		while((line = br.readLine()) != null) {
			String first = line.split(delimiter)[0];
			String second = line.split(delimiter)[1];
			if((first+" "+second).equals(Name)) {
				rowArr=line.split(delimiter);
				
				return rowArr;
				
				
			}
			
		}
		br.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return rowArr;
	}
        

	//Create a matrix of a patient profile
	public String[][] Matrix(String[] arr){
		String[] columnNames = {"First Name",
              "Last Name", "ID","Age", "WBC","Neut","Lymph","RBC",
              "HCT","Urea","Hb","Crtn","Iron","HDL","AP","Do you smoke ? (Y/N)",
              "Do you exercise ? (Y/N)","Do you often have headaches ? (Y/N)","Are You asthmatic ? (Y/N)",
              "Do you have heart problems ? (Y/N)" };
		
		String table[][] = new String[2][20];
		for(int i=0;i<20;i++) {
			table[0][i]=columnNames[i];
		}
		for(int i=0;i<20;i++) {
			table[1][i]=arr[i];
		}
		
		return table;
		
		
	}
           
            
            
}



