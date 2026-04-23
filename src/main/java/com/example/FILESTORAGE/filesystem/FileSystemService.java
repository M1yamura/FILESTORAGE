package com.example.FILESTORAGE.filesystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//Ни малейшего понятия зачем этот каловый класс нужен. Архитектуру генерил ИИ
//23.04.2026
//тут будут базовые методы контроллеры, им нужен шаблон отображения
@Controller
@RequestMapping("/storage")
public class FileSystemService {
    //public static Path basePath = Path.of("");
    //экспериментальный метод, чтобы понять как что-то отображать
//    @GetMapping("")
//    public String femboy() {
//        return "femboy";
//    }


//    @PostMapping("/newFolder")
//    private String CreateDirectory(@RequestHeader("Path") String newDir) {
//        try {
//            Files.createDirectory(Path.of(basePath+ newDir));
//        } catch (IOException e) {
//            System.out.println("Не удалось создать новую папку:(");
//            System.out.println(e.getMessage());
//        }
//        return "index";
//    }
}