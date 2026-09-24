package ad1te1ej3;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



// Basado en la solución al Ejercicio 1 de la Tarea de Aprendizaje 3
public class InputStreamyFirma {
 
    public static void main(String[] args) {
    	
    	// La ruta con la que se crea el objeto File es el primer argumento del main
    	String rutaFichero = args[0];
    	File fichero = new File(rutaFichero);
 
    	// CON AYUDA DE GEMINI: Firma esperada para un fichero ZIP según el enunciado (80, 75, 3, 4)
        byte[] firmaEsperada = {80, 75, 3, 4};
        byte[] buffer = new byte[4];
 
        try (InputStream inputStream = new FileInputStream(fichero)) {
        	
        	// Leemos hasta un máximo de 4 bytes y guardamos el número real de bytes leídos
            int bytesLeidos = inputStream.read(buffer);

            // Requisito 1: Comprobar si tiene menos de 4 bytes
            if (bytesLeidos < 4) {
            	
                System.out.println("El fichero contiene menos de cuatro bytes.");
                
            }
        	
            // Requisito 2: Si tiene 4 bytes, comprobar la firma
            else if (buffer[0] == firmaEsperada[0] && 
                     buffer[1] == firmaEsperada[1] && 
                     buffer[2] == firmaEsperada[2] && 
                     buffer[3] == firmaEsperada[3]) {
                
                System.out.println("La cabecera es compatible con un fichero ZIP.");
                
            } else {
            	
                System.out.println("La cabecera no corresponde a la firma esperada.");
                
            }

        } catch (FileNotFoundException e) {
        	
            System.out.println("No se encuentra el fichero: " + args[0]);
            
        } catch (IOException e) {
        	
            System.out.println("Error de E/S: " + e.getMessage());
            
        }
    }
}
 
 
