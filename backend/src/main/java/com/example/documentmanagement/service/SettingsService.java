package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Setting;
import java.util.Optional;

public interface SettingsService {
    Optional<Setting> getSetting(String key);
    Setting saveSetting(Setting setting);
}
