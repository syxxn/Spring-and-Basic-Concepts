package com.example.fileUpDown.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void upload(List<MultipartFile> files) throws IOException {
        for(MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            File dest = new File("D:/File/"+ originalFileName);
            file.transferTo(dest);
        }
    }

}
