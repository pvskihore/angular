package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.DocumentVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.documentmanagement.model.Document;
import java.util.Optional;

@Repository
public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long> {
    Optional<DocumentVersion> findFirstByDocumentOrderByVersionNumberDesc(Document document);
}
