package com.example.fileUpDown.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void upload(List<MultipartFile> files) throws IOException;
    ResponseEntity<Resource> download(Integer id) throws IOException;
}
