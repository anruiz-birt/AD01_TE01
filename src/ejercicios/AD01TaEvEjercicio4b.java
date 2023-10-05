package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AD01TaEvEjercicio4b {

	public static void main(String[] args) {
		final int long_registro = 110; //Longitud del registro 
		
		try	{
			File fichero = new File("ficheros" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			
			String dniConsola;
			int pesoConsola;		
			
			System.out.println("Introduzca el DNI (con letra) del personaje para control de peso: ");
			dniConsola = Consola.readString();
			
			System.out.println("Introduzca su peso actual: ");
			pesoConsola = Consola.readInt();
			
			Personaje pFichero = null;			
		
			int p;
			for(p=0;p<file.length();p+=long_registro){				
				file.seek(p);
				file.skipBytes(4);
				char[] auxDni =new char[9];
				for(int i=0;i<9;i++)
				{
					auxDni[i]=file.readChar();
				}
				
				if(new String(auxDni).trim().equalsIgnoreCase(dniConsola)){
					pFichero = new Personaje();
					pFichero.setDni(dniConsola);
					
					file.seek(p);
					file.skipBytes(4+18);//Salto el id y el dni
				
					//Recojo el nombre
					char[] auxNombre =new char[10];
					for(int i=0;i<10;i++)
					{
						auxNombre[i]=file.readChar();
					}
					pFichero.setNombre(new String(auxNombre).trim());
					
					file.skipBytes(40+20);//Salto la identidad y el tipo
					
					pFichero.setPeso(file.readInt());
					
					break;
				}
			}
			if(pFichero==null)
				System.out.println("No existe ningún personaje con el dni " + dniConsola);
			else {
				System.out.println(pFichero.getControlPeso(pesoConsola));
				file.seek(p);
				file.skipBytes(4+18+20+40+20);//Salto hasta llegar al peso
				file.writeInt(pesoConsola);				
			}		
			
			file.close();
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
