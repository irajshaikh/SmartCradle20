package com.viit.smartcradle;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.viit.smartcradle.dao.ProfileDataDao;
import com.viit.smartcradle.dao.SensorDataDao;
import com.viit.smartcradle.entity.SensorData;

@WebMvcTest(IndexController.class)
public class TestingAPI {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SensorDataDao sensorDataDao;

	@MockBean
	private ProfileDataDao profileDataDao;

	@Test
	public void getLatestShouldReturnInternalServerErrorOnException() throws Exception {
		when(sensorDataDao.get()).thenThrow(new IOException());
		this.mockMvc.perform(get("/api/feed")).andExpect(status().is5xxServerError());
	}

	@Test
	public void getLatestShouldReturnSensorData() throws Exception {
		SensorData sensorData = new SensorData("35", "true", "false");
		when(sensorDataDao.get()).thenReturn(sensorData);
		this.mockMvc.perform(get("/api/feed")).andExpect(status().isOk())
				.andExpect(content().json("{\"temperature\":35.0,\"hasWetDiaper\":true,\"isCrying\":false}"));
	}

	@Test
	public void addDataShouldReturnStatusSuccess() throws Exception {
		SensorData sensorData = new SensorData("35", "true", "false");
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/feed").contentType(MediaType.APPLICATION_JSON)
				.content("{\"temperature\":\"35\",\"hasWetDiaper\":true,\"isCrying\":false}")).andExpect(status().isOk());
	}

	@Test
	public void addDataShouldReturnBadRequestWhenTempIsNotDouble() throws Exception {
		SensorData sensorData = new SensorData("35", "true", "false");
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/feed").contentType(MediaType.APPLICATION_JSON)
				.content("{\"temperature\":\"35s\",\"hasWetDiaper\":true,\"isCrying\":false}")).andExpect(status().is4xxClientError());
	}

}