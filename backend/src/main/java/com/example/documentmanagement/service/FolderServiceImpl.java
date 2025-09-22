package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Folder;
import com.example.documentmanagement.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    public Optional<Folder> getFolderById(Long id) {
        return folderRepository.findById(id);
    }

    @Override
    public List<Folder> getFoldersByYear(int year) {
        return folderRepository.findByYear(year);
    }
}
