package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Document;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface DocumentService {
    Document storeDocument(MultipartFile file, String name, String fileType);
    List<Document> getAllDocuments();
}
