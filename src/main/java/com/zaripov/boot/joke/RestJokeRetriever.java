package com.zaripov.boot.joke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestJokeRetriever implements JokeRetriever {
    private final Logger logger = LoggerFactory.getLogger(RestJokeRetriever.class);

    private final RestTemplate restTemplate;
    private static String url = "http://api.icndb.com/jokes/random";

    public RestJokeRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JokeImportDTO getJoke() {
        logger.debug("Joke request");
        ResponseEntity<JokeImportDTO> result = restTemplate.getForEntity(url, JokeImportDTO.class);
        logger.debug("Joke get: {}",result.getBody().value.joke);
        return result.getBody();
    }
}