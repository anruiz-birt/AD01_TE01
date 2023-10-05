package ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AD01TaEvEjercicio1 {

	public static void main(String[] args) {
		File inputFile = new File("ficheros" + File.separator + "ejercicio1.txt");
		File outputFile = new File("ficheros" + File.separator + "ejercicio1_output.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
          	String linea;
        	StringBuffer sb;
		    while ((linea = br.readLine()) != null) {
		    	sb = new StringBuffer(linea);
		    	bw.write(sb.reverse().toString());
		    	bw.newLine();
		    }
		    bw.close();
		    br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
