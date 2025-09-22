package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.FolderTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderTemplateRepository extends JpaRepository<FolderTemplate, Long> {
}
