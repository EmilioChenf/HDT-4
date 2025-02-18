package ht4.calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    /**
     * Lee la expresión matemática del archivo datos.txt
     * @return String con la expresión matemática
     * @throws IOException si hay error al leer el archivo
     */
    public static String readExpression() throws IOException {
        try {
            // Lee todo contenido del archivo
            Path path = Paths.get("datos.txt");
            String content = Files.readString(path);
            
            // Elimina espacios extra y retorna
            return content.trim();
            
        } catch (IOException e) {
            throw new IOException("Error al leer datos.txt: " + e.getMessage());
        }
    }
}