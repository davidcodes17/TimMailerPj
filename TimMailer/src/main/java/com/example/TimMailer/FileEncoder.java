package com.example.TimMailer;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
@Component
public class FileEncoder {

    public String encodeFileToBase64(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}
