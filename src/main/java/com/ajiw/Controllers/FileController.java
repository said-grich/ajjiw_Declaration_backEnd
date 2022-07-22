package com.ajiw.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.ajiw.entities.FileDB;
import com.ajiw.service.FileStorageService;
import com.ajiw.service.ResponseFile;
import com.ajiw.service.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class FileController {
//    @Autowired
//    private FileStorageService storageService;
//
////    @PostMapping("/upload")
////    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
////       return storageService.uploadFile(file);
////    }
//    @GetMapping("/files")
//    public ResponseEntity<List<ResponseFile>> getListFiles() {
//       return storageService.getListFiles();
//    }
//    @GetMapping("/files/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//        FileDB fileDB = storageService.getFile(id);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
//                .body(fileDB.getData());
//    }
}