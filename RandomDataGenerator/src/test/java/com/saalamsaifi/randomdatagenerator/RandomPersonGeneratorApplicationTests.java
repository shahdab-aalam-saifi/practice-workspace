package com.saalamsaifi.randomdatagenerator;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RandomDataGeneratorApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RandomPersonGeneratorApplicationTests {
	@LocalServerPort
	private int port;

	@Test
	public void testRestController() throws JSONException {
		TestRestTemplate restTemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<Object> entity = new HttpEntity<Object>(null, headers);

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromHttpUrl("http://localhost:" + port + "/generate").queryParam("size", 10);

		ResponseEntity<String> response = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET,
				entity, String.class);

		JSONArray persons = new JSONArray(response.getBody());

		Assert.assertEquals(persons.length(), 10);
	}

	@Test
	public void contextLoads() {
	}
}
