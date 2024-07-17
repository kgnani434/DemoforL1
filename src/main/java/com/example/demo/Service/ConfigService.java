package com.example.demo.Service;

import com.example.demo.Entity.ConfigEntity;
import com.example.demo.Repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    private com.example.demo.Repository.ConfigRepository ConfigRepository;

    @CacheEvict(value = "ConfigCache", key = "#key")
    public void addKeyValue(String key, String value) {
        ConfigEntity keyValue = new ConfigEntity();
        keyValue.setKey(key);
        keyValue.setValue(value);
        ConfigRepository.save(keyValue);
    }

    @Cacheable(value = "ConfigCache", key = "#key")
    public ConfigEntity getKeyValue(String key) {
        return ConfigRepository.findByKey(key);
    }
}
