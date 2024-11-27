package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    public static String getLastPartOfPath(String fullPath) {
        // Cria o objeto Path a partir do caminho completo
        Path path = Paths.get(fullPath);

        // Retorna o último componente do caminho
        return path.getFileName().toString();
    }
}
