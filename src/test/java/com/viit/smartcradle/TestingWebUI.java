package com.viit.smartcradle;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestingWebUI {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnDashboardAsHomePage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("temp.jpg");
	}
	
	@Test
	public void shouldReturnEditProfilePage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/edit-profile",
				String.class)).contains("My profile");
	}
}