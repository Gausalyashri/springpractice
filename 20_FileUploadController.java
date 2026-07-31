/*
Problem: File Upload Handling
Accept a multipart file upload and save it to disk, returning
the stored file name.
*/

package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private final Path uploadDir = Paths.get("uploads");

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        Files.createDirectories(uploadDir);
        Path destination = uploadDir.resolve(file.getOriginalFilename());
        file.transferTo(destination);

        return ResponseEntity.ok("Uploaded: " + file.getOriginalFilename());
    }
}
