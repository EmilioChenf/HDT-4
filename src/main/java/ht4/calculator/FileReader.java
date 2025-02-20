package ht4.calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

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
