

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;

public class CreateCsvFile {

static void generateCsvFile(String fileName,String[][] table,JLabel message) {
	  
	 
		String msg=message.getText();
		FileWriter writer = null;

 try {

     writer = new FileWriter(fileName);
    
     for (int i = 0; i < 20; i++) {
 	    writer.append(table[0][i]+":  "+table[1][i]);
 	} 
     writer.append('\n');
     writer.append("Diagnosis: \n");
     writer.append(msg);

    

  } catch (IOException e) {
     e.printStackTrace();
  } finally {
        try {
      writer.flush();
      writer.close();
        } catch (IOException e) {
      e.printStackTrace();
}
}
}



}