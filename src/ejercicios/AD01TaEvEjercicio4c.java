package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AD01TaEvEjercicio4c {

	public static void main(String[] args) {
		final int long_registro = 110; //Longitud del registro 
		try	{
			File fichero = new File("ficheros" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			
			Personaje pFichero;
			ArrayList<Personaje> arrPersonajes = new ArrayList<Personaje>();
		
			Boolean existeTipo = false;
			String tipoConsola;
			
			System.out.println("Introduce el tipo:");
			tipoConsola = Consola.readString();
			for(int p=0;p<file.length();p+=long_registro){
				pFichero = new Personaje();
				file.seek(p);
				file.skipBytes(82);
				char[] auxTipo =new char[10];
				for(int i=0;i<10;i++)
				{
					auxTipo[i]=file.readChar();
				}
				pFichero.setTipo(new String(auxTipo).trim());
				if(pFichero.getTipo().equalsIgnoreCase(tipoConsola)){
					existeTipo = true;
					file.seek(p);
					file.skipBytes(4);//Salto el código
					//Recojo el DNI
					char[] auxDni =new char[9];
					for(int i=0;i<9;i++)
					{
						auxDni[i]=file.readChar();
					}
					pFichero.setDni(new String(auxDni).trim());
					
					//Recojo el nombre
					char[] auxNombre =new char[10];
					for(int i=0;i<10;i++)
					{
						auxNombre[i]=file.readChar();
					}
					pFichero.setNombre(new String(auxNombre).trim());
					
					//Recojo la identidad
					char[] auxIdentidad =new char[20];
					for(int i=0;i<20;i++)
					{
						auxIdentidad[i]=file.readChar();
					}
					pFichero.setIdentidad(new String(auxIdentidad).trim());
					
					file.skipBytes(20);//Salto el tipo porque ya lo tengo
					
					pFichero.setPeso(file.readInt());
					pFichero.setAltura(file.readInt());										
					
					arrPersonajes.add(pFichero);
				}
			}
			if(!existeTipo)
				System.out.println("No existen " + tipoConsola + "s en el fichero.");
			else {
				System.out.println("Se han encontrado " + arrPersonajes.size() + " " + tipoConsola + "s.");
				for (Personaje p: arrPersonajes) {
					System.out.println(p.toString());					
				}
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
