package com.example.fileUpDown.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> upload(List<MultipartFile> files) throws IOException;
}
