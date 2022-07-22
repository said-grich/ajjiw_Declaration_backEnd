package com.ajiw.service;

import com.ajiw.entities.FileDB;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PhotoService {


    public FileDB saveImage(MultipartFile imageFile, FileDB fileDB) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        System.out.println(absolutePath.toString());
        String path1=absolutePath + "/src/main/resources/static/photos/";
        Path path = Paths.get(path1 + imageFile.getOriginalFilename());
        fileDB.setPath(path.toString());
        byte[] bytes = imageFile.getBytes();
        Files.write(path, bytes);
        return fileDB;
    }
}
