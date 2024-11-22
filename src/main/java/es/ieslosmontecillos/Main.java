package es.ieslosmontecillos;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombre;
        System.out.print("Ingrese el nombre del fichero o directorio: ");
        nombre = entrada.nextLine();
        File fichero = new File(nombre);

        if (fichero.exists()&&fichero.isDirectory()) {
            String[] files = fichero.list();
            if (files != null) {
                for (String fileNombre : files) {
                    File ficheroActual = new File(nombre, fileNombre);
                    System.out.println(ficheroActual + isFile(ficheroActual));
                }
            }
        }
        else if(fichero.exists()&&fichero.isFile()) {
            System.out.println(fichero.getName()+" es un fichero.");
        }else{
            System.out.println("No existe el nombre indicado.");
        }

    }
    public static String isFile(File fichero) {
        if(fichero.isFile()) {
            return " es un fichero.";
        }else{
           return " es un directorio.";
        }
    }
}
