/*******************************************************************************
* @author Fatima Navarro 24044
* 
* Universidad del Valle de Guatemala
* Algoritmos y Estructura de Datos
* Sección: 10
* 
* HT4 - Clases y Objetos con Java
* Calculadora Infix/Postfix
* 
* FileReader.java
* Esta clase se encarga de leer las expresiones matemáticas desde el archivo datos.txt
* 
* Fecha: 16/02/2025
*******************************************************************************/

package ht4.calculator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase para leer el archivo de entrada que contiene la expresión matemática.
 * Sigue el principio de responsabilidad única.
 */
public class FileReader {
    
    /**
     * Lee la expresión matemática desde el archivo datos.txt
     * Precondición: El archivo datos.txt debe existir y ser accesible.
     * Postcondición: Retorna la expresión contenida en el archivo como String.
     * 
     * @return expresión matemática leída del archivo
     * @throws IOException si hay problemas al leer el archivo
     */
    public static String readExpression() throws IOException {
        // Primero intentamos leer desde resources (para jar ejecutable)
        try (InputStream input = FileReader.class.getResourceAsStream("/datos.txt")) {
            if (input != null) {
                return new String(input.readAllBytes()).trim();
            }
        }
        
        // Si no, intentamos leer desde el directorio actual
        try {
            return Files.readString(Paths.get("datos.txt")).trim();
        } catch (IOException e) {
            throw new IOException("Error al leer datos.txt: " + e.getMessage());
        }
    }
}