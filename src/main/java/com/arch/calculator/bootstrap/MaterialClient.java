package com.arch.calculator.bootstrap;

import com.arch.calculator.domain.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@ConfigurationProperties(prefix = "rune.materials", ignoreUnknownFields = false)
public class MaterialClient {

    private final RestTemplate restTemplate;
    private String apihost;

    public MaterialClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Response getMaterialById(Long id) {
        Response response = new Response();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        try {
            restTemplate.setMessageConverters(messageConverters);
            response = restTemplate.getForObject(apihost + id, Response.class);
        } catch (Exception e) {
            log.error("error -> " + e.toString());
        }
        return response;
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
