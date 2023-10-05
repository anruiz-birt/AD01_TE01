package ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AD01TaEvEjercicio2 {

	public static void main(String[] args) {
		File inputFile = new File("ficheros" + File.separator + "ejercicio2.txt");
		File outputFile = new File("ficheros" + File.separator + "ejercicio2_output.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
          	String linea;
        	StringBuffer sb;
        	String[] palabrasLinea;
		    while ((linea = br.readLine()) != null) {
		    	palabrasLinea = linea.split(" ");
		    	for (String palabra: palabrasLinea) {
		    		sb = new StringBuffer(palabra);
		    		if (palabra.equalsIgnoreCase(sb.reverse().toString())) {
		    			bw.write(palabra);
				    	bw.newLine();
		    		}
		    	}
		    }
		    bw.close();
		    br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
