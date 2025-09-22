package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.Setting;
import com.example.documentmanagement.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping("/{key}")
    public ResponseEntity<Setting> getSetting(@PathVariable String key) {
        return settingsService.getSetting(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Setting> saveSetting(@RequestBody Setting setting) {
        Setting savedSetting = settingsService.saveSetting(setting);
        return ResponseEntity.ok(savedSetting);
    }
}
