package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.Folder;
import com.example.documentmanagement.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @PostMapping
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
        Folder createdFolder = folderService.createFolder(folder);
        return ResponseEntity.ok(createdFolder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFolderById(@PathVariable Long id) {
        return folderService.getFolderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Folder>> getFoldersByYear(@PathVariable int year) {
        List<Folder> folders = folderService.getFoldersByYear(year);
        return ResponseEntity.ok(folders);
    }
}
