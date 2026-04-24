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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;



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
    //Нужно добавить автоген имён файлов
    @PostMapping("/upload")
    public String handleUpload(@RequestParam("files") List<MultipartFile> files) throws IOException {
        if (!files.isEmpty()) {
            for (MultipartFile file : files) {
                Files.copy(file.getInputStream(),
                        Paths.get(basePath.toString(), file.getOriginalFilename()).normalize(),
                        StandardCopyOption.REPLACE_EXISTING );
            }

        }
        return "redirect:/files";
    }



}
