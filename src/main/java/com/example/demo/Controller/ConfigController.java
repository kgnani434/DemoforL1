package com.example.demo.Controller;

import com.example.demo.Entity.ConfigEntity;
import com.example.demo.Service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Config")
public class ConfigController {

    @Autowired
    private ConfigService ConfigService;

    @PostMapping
    public void addConfig(@RequestParam String key, @RequestParam String value) {
        ConfigService.addKeyValue(key, value);
    }

    @GetMapping("/{key}")
    public ConfigEntity getConfig(@PathVariable String key) {
        return ConfigService.getKeyValue(key);
    }
}
