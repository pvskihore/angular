package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Document;
import com.example.documentmanagement.model.DocumentVersion;
import com.example.documentmanagement.repository.DocumentRepository;
import com.example.documentmanagement.repository.DocumentVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentVersionRepository documentVersionRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public Document storeDocument(MultipartFile file, String name, String fileType) {
        String filePath = fileStorageService.storeFile(file);

        Optional<Document> existingDocument = documentRepository.findByName(name);

        if (existingDocument.isPresent()) {
            Document document = existingDocument.get();
            DocumentVersion latestVersion = documentVersionRepository.findFirstByDocumentOrderByVersionNumberDesc(document)
                    .orElseThrow(() -> new RuntimeException("Could not find latest version for document: " + name));

            DocumentVersion newVersion = new DocumentVersion();
            newVersion.setDocument(document);
            newVersion.setVersionNumber(latestVersion.getVersionNumber() + 1);
            newVersion.setFilePath(filePath);

            DocumentVersion savedVersion = documentVersionRepository.save(newVersion);
            document.setCurrentVersion(savedVersion);
            document.setUploadDate(LocalDateTime.now());
            return documentRepository.save(document);
        } else {
            Document document = new Document();
            document.setName(name);
            document.setFileType(fileType);
            document.setUploadDate(LocalDateTime.now());

            Document savedDocument = documentRepository.save(document);

            DocumentVersion version = new DocumentVersion();
            version.setDocument(savedDocument);
            version.setVersionNumber(1);
            version.setFilePath(filePath);

            DocumentVersion savedVersion = documentVersionRepository.save(version);

            savedDocument.setCurrentVersion(savedVersion);
            return documentRepository.save(savedDocument);
        }
    }
}
