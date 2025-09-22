package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Setting;
import com.example.documentmanagement.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    private SettingRepository settingRepository;

    @Override
    public Optional<Setting> getSetting(String key) {
        return settingRepository.findByKey(key);
    }

    @Override
    public Setting saveSetting(Setting setting) {
        return settingRepository.save(setting);
    }
}
