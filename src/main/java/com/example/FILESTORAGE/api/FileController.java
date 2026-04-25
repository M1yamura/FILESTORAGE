package com.example.FILESTORAGE.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {
    final Path basePath;
    public FileController(@Value("${storage.root}")Path path) {
        this.basePath = path;
    }

    //Нужно добавить автоген имён файлов
    @PostMapping("/upload")
    public String handleUpload(@RequestParam("files") List<MultipartFile> files) throws IOException {
        if (!files.isEmpty()) {
            for (MultipartFile file : files) {

                //извлечение расширения файла
                //--------------------------------------------------------
                String originalFilename = file.getOriginalFilename();
                String extension = "";
                if (originalFilename != null && originalFilename.contains(".")) {
                    extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                }//-------------------------------------------------------


                Files.copy(file.getInputStream(),
                        basePath.resolve(UUID.randomUUID().toString() + extension).normalize(),
                        StandardCopyOption.REPLACE_EXISTING );
            }

        }
        return "redirect:/index.html";
    }
}
