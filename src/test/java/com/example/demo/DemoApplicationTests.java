package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.Controller.ConfigController;
import com.example.demo.Entity.ConfigEntity;
import com.example.demo.Service.ConfigService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ConfigController.class)
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ConfigService keyValueService;

	@Autowired
	private CacheManager cacheManager;

	@Test
	public void testAddConfig() throws Exception {
		String key = "testKey";
		String value = "testValue";

		mockMvc.perform(post("/Config")
						.param("key", key)
						.param("value", value))
				.andExpect(status().isOk());

	}

	@Test
	public void testGetConfig() throws Exception {
		String key = "testKey";
		ConfigEntity configEntity = new ConfigEntity();
		configEntity.setKey(key);
		configEntity.setValue("testValue");

		mockMvc.perform(get("/Config/{key}", key))
				.andExpect(status().isOk());


	}
}
