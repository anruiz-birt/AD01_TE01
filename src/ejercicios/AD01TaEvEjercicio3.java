package ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class AD01TaEvEjercicio3 {

	public static void main(String[] args) {
		
		File inputFile = new File("ficheros" + File.separator + "ejercicio2.zip");
		//File inputFile = new File("ficheros" + File.separator + "ejercicio2.txt");
				 
        int[] zipSignature = {80, 75, 3, 4} ; //cabecera de fichero ZIP en decimal
       
         try {
            InputStream inputStream = new FileInputStream(inputFile);
        
            int[] zipHeader = new int[4];
 
            // lee los 4 primeros enteros decimales como cabecera de ZIP
            for (int i = 0; i < 4; i++) {
            	zipHeader[i] = inputStream.read();
            }
 
            if (!Arrays.equals(zipHeader, zipSignature)) {
            	System.out.println("No es un fichero ZIP");                
            } else {
            	System.out.println("Si es un fichero ZIP");
            }
            inputStream.close();
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }


	}

}
