package com.example.fileUpDown.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/file")
public class FileController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> upload(@RequestParam List<MultipartFile> files) throws Exception {
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            File dest = new File("D:/File/" + originalfileName);
            file.transferTo(dest);
        }
        return list;
    }

}
