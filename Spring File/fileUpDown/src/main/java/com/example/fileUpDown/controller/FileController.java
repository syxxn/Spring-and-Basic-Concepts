package com.example.fileUpDown.controller;

import com.example.fileUpDown.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/file")
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestParam List<MultipartFile> files) throws IOException {
        fileService.upload(files);
    }

}
