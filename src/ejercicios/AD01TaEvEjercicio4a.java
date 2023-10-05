package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AD01TaEvEjercicio4a {

	public static void main(String[] args) {
		try {
			final int long_registro = 110; //Longitud del registro 
			File outputFile = new File("ficheros" + File.separator + "Marvel.dat");
			if(outputFile.exists()){
				outputFile.delete();
			}
			RandomAccessFile file = new RandomAccessFile(outputFile, "rw");
			 //Arrays con los datos de los superheroes
			int [] ids= {1, 2, 3, 4, 5, 6, 7};
			String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
			String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
			String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
			String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
			int[] pesos = {76,84,66,136,78,102,70};
			int[] alturas = {178,183,156,152,177,182,188};
			
			StringBuffer bufferDnis = null;
			StringBuffer bufferNoms = null;
			StringBuffer bufferIdentidades = null;
			StringBuffer bufferTipos = null;
			int cuantos=dnis.length;
			int posicion = 0;
					
			for (int i=0;i<cuantos; i++){
				posicion=i*long_registro;
				file.seek(posicion);
				
				file.writeInt(ids[i]);
				
				bufferDnis = new StringBuffer( dnis[i] );      	//DNI
				bufferDnis.setLength(9); 
				file.writeChars(bufferDnis.toString());
				
				bufferNoms = new StringBuffer( noms[i] );      	//Nombre
				bufferNoms.setLength(10); 
				file.writeChars(bufferNoms.toString());
				
				bufferIdentidades = new StringBuffer( identidades[i] );      //Identidad
				bufferIdentidades.setLength(20); 
				file.writeChars(bufferIdentidades.toString());
				
				bufferTipos = new StringBuffer( tipos[i] );      //Tipo
				bufferTipos.setLength(10); 
				file.writeChars(bufferTipos.toString());
				
				file.writeInt(pesos[i]); 		//Peso
				
				file.writeInt(alturas[i]);		//Altura
			 }     
			file.close();
			System.out.println("La carga de los personajes ha terminado correctamente.");	
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}


