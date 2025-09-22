package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Folder;
import java.util.List;
import java.util.Optional;

public interface FolderService {
    Folder createFolder(Folder folder);
    Optional<Folder> getFolderById(Long id);
    List<Folder> getFoldersByYear(int year);
}
