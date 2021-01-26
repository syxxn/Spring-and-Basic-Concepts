package com.example.fileUpDown.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<String> upload(List<MultipartFile> files) throws IOException {
        List<String> list = new ArrayList<>();

        for(MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            File dest = new File("C:/Image/"+ originalFileName);
            file.transferTo(dest);
        }

        return list;
    }

}
