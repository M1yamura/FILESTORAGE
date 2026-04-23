package com.example.FILESTORAGE.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Controller
@RequestMapping("/files")
public class FileController {
    final Path basePath;

    public FileController(@Value("${storage.root}")Path path) {
        this.basePath = path;
    }

    @GetMapping
    public String files() {
        return "files";
    }

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("myFile") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            Path destination = basePath.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        }
        // Редирект обратно на страницу выбора файлов
        return "redirect:/files";
    }



}
