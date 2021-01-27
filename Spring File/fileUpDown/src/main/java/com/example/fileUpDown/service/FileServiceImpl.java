package com.example.fileUpDown.service;

import com.example.fileUpDown.entity.File;
import com.example.fileUpDown.entity.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public void upload(List<MultipartFile> files) throws IOException {
        for(MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            java.io.File dest = new java.io.File("D:/File/"+originalFileName);
            file.transferTo(dest);

            fileRepository.save(
                    File.builder()
                            .originalName(originalFileName)
                            .path(dest.getPath())
                            .build()
            );
        }
    }

    @Override
    public ResponseEntity<Resource> download(Integer id) throws IOException {
        File file = fileRepository.findById(id)
                .orElseThrow(FileNotFoundException::new);

        Path path = Paths.get(file.getPath());

        String contentType = Files.probeContentType(path);

        HttpHeaders httpHeaders = new HttpHeaders();
        // httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType); 가져온 contentType으로 Response의 contentType 설정
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; fileName="+path.getFileName().toString()); //다운로드
                /*Content-Disposition은 컨텐츠가 브라우저에 인라인 되어야 하거나 웹 페이지의 일부인지,
                    아니면 첨부 파일로 다운로드 되거나 로컬에 저장될 용도로 쓰이는 것인지를 알려주는 헤더이다.*/
                /* attachment는 반드시 다운로드하고, fileName이 있고 존재한다면 그 이름을 새 이름으로 미리 채워줌 */

        Resource resource = new InputStreamResource(Files.newInputStream(path));
        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK); //파일, 헤더, 상태코드 반환

    }

}
