

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiagnosisWindow {

	//Ctor
	public DiagnosisWindow(String[][] table) {
		JFrame frame = new JFrame("Diagnosis");
		frame.setSize(2000,1000);
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));	    
		panel.setSize(1000,1000);
		panel.setBackground(Color.GRAY);
		
		float array[];
		array= new float[12];
		
		//Convert from string to float
		for(int i=0;i<12;i++) {	
			array[i]=Float.valueOf(table[1][i+3]);
			//System.out.println(array[i]);
		}
		
	
	
		panel.add(new JLabel("Diagnosis of the Doctor:"));
		panel.add(new JLabel("   "));
		
	//Labels
		JLabel label1 = new JLabel("Too much White Blood Cells: High Presence of an infection, if there is a fever, is most often indicated. In other, very rare cases, very high values may indicate blood disease or cancer. RECOMMANDATION: Take Dedicated antibiotics");
		JLabel label2 = new JLabel("Not Enough White Blood Cells: Indicate viral disease, immune system failure and in very rare cases cancer. RECOMMANDATION: Relax at Home.");
		JLabel label3 = new JLabel("Too much Neutrophil: Most often indicate a bacterial infection. RECOMMANDATION: Take Dedicated antibiotics ");
		JLabel label4 = new JLabel("Not Enough Neutrophil: Indicate a disorder in the formation of blood, a tendency to bacterial infections and in rare cases a process cancerous. RECOMMANDATION: 10 mg pill of B12 a day for a month and 5 mg pill of folic acid a day for a month ");
		JLabel label5 = new JLabel("Too much Lymphocytes: Indicate a problem in the formation of blood cells. RECOMMANDATION: 10 mg pill of B12 a day for a month and 5 mg pill of folic acid a day for a month. ");
		JLabel label6 = new JLabel("Not Enough Lymphocytes: May indicate a prolonged bacterial infection or lymphoma cancer. RECOMMANDATION: Take Decicated antibiotics.");
		JLabel label7 = new JLabel("Too much Red Blood Cells: May indicate a disturbance in the blood production system. High levels were also observed in smokers and in patients with lung diseases. RECOMMANDATION: 10 mg pill of B12 a day for a month and 5 mg pill of folic acid a day for a month. ");
		JLabel label8 = new JLabel("Not Enough Red Blood Cells: May indicate anemia or severe bleeding. RECOMMANDATION: Two 10 mg B12 pills a day for a month.");
		JLabel label9 = new JLabel("Too much HCT: Common with smokers. RECOMMANDATION: Stop Smoking.");
		JLabel label10 = new JLabel("Not Enough HCT: Most often indicate bleeding or anemia. RECOMMANDATION: Two 10 mg B12 pills a day for a month. ");
		JLabel label11 = new JLabel("Too much Urea: May indicate kidney disease, dehydration or a high protein diet. RECOMMANDATION: Balance blood sugar levels.");
		JLabel label12 = new JLabel("Not Enough Urea: Malnutrition, low-protein diet or liver disease. It should be noted that during pregnancy the level of urination decreases. RECOMMANDATION: Referral to a specific diagnosis for the purpose of determining treatment. Schedule an appointment with a nutritionist");
		JLabel label13= new JLabel("Not Enough Hemoglobin: Indicate anemia. This can be due to a hematologic disorder, iron deficiency and bleeding. RECOMMANDATION: Two 10 mg B12 pills a day for a month");
		JLabel label14 = new JLabel("Too much Creatinine: May indicate a kidney problem and in severe cases kidney failure. High values are possible. Also found in diarrhea and vomiting (causes of increased muscle breakdown and high levels of creatinine), muscle diseases and increased consumption of meat. RECOMMANDATION: Balance blood sugar levels. Schedule an appointment with a nutritionist.");
		JLabel label15 = new JLabel("Not Enough Creatinine: Most commonly seen in patients with very poor muscle mass and malnourished people who do not consume enough protein. RECOMMANDATION: Schedule an appointment with a nutritionist. ");
		JLabel label16 = new JLabel("Too much Iron: May indicate iron poisoning. RECOMMANDATION: Be evacuated to the hospital.");
		JLabel label17 = new JLabel("Not Enough Iron: Usually indicates an inadequate diet or an increase in the need for iron (for example during pregnancy) or blood loss due to bleeding. RECOMMANDATION: Two 10 mg B12 pills a day for a month. ");
		JLabel label18 = new JLabel("Too much HDL: Are usually harmless. Exercise raises good cholesterol levels ");
		JLabel label19 = new JLabel("Not Enough HDL: May indicate a risk of heart disease, hyperlipidemia (hyperlipidemia) or adult-onset diabetes. RECOMMANDATION: Schedule an appointment with a nutritionist, a 5 mg pill of Simobil daily for a week.");
		JLabel label20 = new JLabel("Too much Alkaline Phosphatase:  May indicate liver disease, biliary tract disease, pregnancy, hypothyroidism or use of various medications. RECOMMANDATION: Referral to a specific diagnosis for the purpose of determining treatment");
		JLabel label21 = new JLabel("Not Enough Alkaline Phosphatase: May indicate a poor diet that lacks protein. Deficiency in vitamins like vitamin, vitamin B12, vitamin C, folic acid B6. RECOMMANDATION: Schedule an appointment with a nutritionist.");
		
		
		String location="";
		if(table[1][0].equals("Shlomo")){
			location = "src//Excel//ShlomoData.csv";
		}
		else if(table[1][0].equals("Reuven")) {
			location = "src//Excel//ReuvenData.csv";
		}
		else if(table[1][0].equals("Yonathan")){
			location = "src//Excel//YonathanData.csv";
		}
		else if(table[1][0].equals("Julia")) {
			location = "src//Excel//JuliaData.csv";
		}
		else if(table[1][0].equals("Daniel")) {
			location = "src//Excel//DanielData.csv";
		}
		else if(table[1][0].equals("Shirel")) {
			location = "src//Excel//ShirelData.csv";
		}
		else {
			location = "src//Excel//PatientData.csv";
		}
		
		
		
		
		//White Blood Cells
		if(array[0]>18) {
			if(array[1]>11000) {
				panel.add(label1);
				CreateCsvFile.generateCsvFile(location,table,label1);
			}
			else if(array[1]<4500) {
				panel.add(label2);
				CreateCsvFile.generateCsvFile(location,table,label2);
			}
		}
		else if(array[0]>3&&array[0]<18) {
			if(array[1]>15500) {
				panel.add(label1);
				CreateCsvFile.generateCsvFile(location,table,label1);
				
			}
			else if(array[1]<5500) {
				panel.add(label2);
				CreateCsvFile.generateCsvFile(location,table,label2);
			}
		}
		else if(array[0]<3) {
			if(array[1]>17500) {
				panel.add(label1);
				CreateCsvFile.generateCsvFile(location,table,label1);
			}
			else if(array[1]<6000) {
				panel.add(label2);
				CreateCsvFile.generateCsvFile(location,table,label2);
			}
		}
		
		//Neutrophil
		if(array[2]>54) {
			panel.add(label3);
			CreateCsvFile.generateCsvFile(location,table,label3);
		}
		else if(array[2]<28) {
			panel.add(label4);
			CreateCsvFile.generateCsvFile(location,table,label4);
		}
		
		//Lymphocytes
		if(array[3]>52) {
			panel.add(label5);
			CreateCsvFile.generateCsvFile(location,table,label5);
		}
		else if(array[3]<36) {
			panel.add(label6);
			CreateCsvFile.generateCsvFile(location,table,label6);
		}
		
		//Red Blood Cells
				if(array[4]>6) {
					panel.add(label7);
					CreateCsvFile.generateCsvFile(location,table,label7);
				}
				else if(array[4]<4.5) {
					panel.add(label8);
					CreateCsvFile.generateCsvFile(location,table,label8);
				}
				
		//HCT
				if(array[5]>54) {
					panel.add(label9);
					CreateCsvFile.generateCsvFile(location,table,label9);
				}
				else if(array[5]<37) {
					panel.add(label10);
					CreateCsvFile.generateCsvFile(location,table,label10);
				}
				
		//Urea
				if(array[6]>43) {
					panel.add(label11);
					CreateCsvFile.generateCsvFile(location,table,label11);
				}
				else if(array[6]<17) {
					panel.add(label12);
					CreateCsvFile.generateCsvFile(location,table,label12);
				}
				
		//Hemoglobine
				if(array[7]<12) {
					panel.add(label13);
					CreateCsvFile.generateCsvFile(location,table,label13);
				}
				
		//Creatinine
				if(array[0]>18) {
					if(array[8]>1) {
						panel.add(label14);
						CreateCsvFile.generateCsvFile(location,table,label14);
					}
					else if(array[8]<0.6) {
						panel.add(label15);
						CreateCsvFile.generateCsvFile(location,table,label15);
					}
				}
				else if(array[0]>3&&array[0]<18) {
					if(array[8]>1) {
						panel.add(label14);
						CreateCsvFile.generateCsvFile(location,table,label14);
						
					}
					else if(array[8]<0.5) {
						panel.add(label15);
						CreateCsvFile.generateCsvFile(location,table,label15);
					}
				}
				else if(array[0]<3) {
					if(array[8]>0.5) {
						panel.add(label14);
						CreateCsvFile.generateCsvFile(location,table,label14);
					}
					else if(array[8]<0.2) {
						panel.add(label15);
						CreateCsvFile.generateCsvFile(location,table,label15);
					}
				}
			
		//Iron
				if(array[9]>160) {
					panel.add(label16);
					CreateCsvFile.generateCsvFile(location,table,label16);
				}
				else if(array[9]<60) {
					panel.add(label17);
					CreateCsvFile.generateCsvFile(location,table,label17);
				}
				
		//HDL
				if(array[10]>62) {
					panel.add(label18);
					CreateCsvFile.generateCsvFile(location,table,label18);
				}
				else if(array[10]<29) {
					panel.add(label19);
					CreateCsvFile.generateCsvFile(location,table,label19);
				}
				
		//Alkaline Phosphatase
				if(array[11]>90) {
					panel.add(label20);
					CreateCsvFile.generateCsvFile(location,table,label20);
				}
				else if(array[11]<30) {
					panel.add(label21);
					CreateCsvFile.generateCsvFile(location,table,label21);
				}
				
				
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
}
