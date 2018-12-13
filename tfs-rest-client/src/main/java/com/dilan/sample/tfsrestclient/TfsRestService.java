package com.dilan.sample.tfsrestclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class TfsRestService {

    private static final Logger log = LoggerFactory.getLogger(TfsRestService.class);


    public void getCommit(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("Basic","PAT");
        //headers.add("Authorization","Basic N2EzeHVqZHNvczN2ZG9jbW5xYWYyemxvcnZsenNyeGJ3YmxyNmtweGR1dGFiY3Y3dXVrYQ==");
        //log.info(restTemplate.getForObject("https://dev.azure.com/dilansalinda/dilan/_apis/tfvc/changesets?api-version=5.0-preview.3", String.class));
        ResponseEntity<String> d =
                restTemplate.exchange(
                "https://dev.azure.com/dilansalinda/dilan/_apis/tfvc/changesets?api-version=5.0-preview.3", HttpMethod.GET, new HttpEntity<>(headers),
                String.class);

        System.out.println(d);
    }
}
