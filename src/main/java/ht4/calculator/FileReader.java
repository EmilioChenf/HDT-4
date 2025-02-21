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
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase utilitaria para leer el archivo de datos que contiene la expresión matemática.
 * Busca el archivo en múltiples ubicaciones para mayor flexibilidad.
 */
public class FileReader {

    /**
     * Lee la expresión matemática del archivo datos.txt.
     * Primero busca en src/main/resources/ y luego en el directorio raíz.
     * 
     * @return String conteniendo la expresión matemática del archivo
     * @throws IOException si el archivo no se encuentra o hay problemas al leerlo
     * 
     * Precondición: El archivo datos.txt debe existir en alguna de las ubicaciones buscadas
     * Postcondición: Retorna el contenido del archivo como String, sin espacios al inicio o final
     */
    public static String readExpression() throws IOException {
        // Intentar leer desde src/main/resources/
        if (Files.exists(Paths.get("src/main/resources/datos.txt"))) {
            return Files.readString(Paths.get("src/main/resources/datos.txt")).trim();
        }

        // Intentar leer desde el directorio raíz del proyecto
        if (Files.exists(Paths.get("datos.txt"))) {
            return Files.readString(Paths.get("datos.txt")).trim();
        }

        throw new IOException("Error: No se encontró el archivo datos.txt en ninguna ubicación esperada.");
    }
}
