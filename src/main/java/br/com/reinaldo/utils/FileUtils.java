package br.com.reinaldo.utils;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileUtils {

    public static  void ensureDirectoryExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public static void deleteFileIfExists(Path filePath) throws IOException {
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao deletar arquivo: "+ e.getMessage());
        }
    }

    public static void saveFile(InputStream inputStream, Path target, CopyOption... options) throws IOException {
        Files.copy(inputStream, target, options);
    }
}
