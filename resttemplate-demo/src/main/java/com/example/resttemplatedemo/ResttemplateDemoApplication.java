package com.example.resttemplatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class ResttemplateDemoApplication implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map map = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Map.class);
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println(entry.toString());
        }

        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/todos/{p}")
                .build("1");

        ResponseEntity<Map> forEntity = restTemplate.getForEntity(uri, Map.class);
        System.out.println(forEntity.getBody());

    }
}
