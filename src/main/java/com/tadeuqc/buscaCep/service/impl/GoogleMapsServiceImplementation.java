package com.tadeuqc.buscaCep.service.impl;

import com.tadeuqc.buscaCep.model.MapsResult;
import com.tadeuqc.buscaCep.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.env.Environment;
import java.util.regex.*;
@Service
public class GoogleMapsServiceImplementation implements GoogleMapsService {

    @Autowired
    private Environment env;

    private static final Logger log = LoggerFactory.getLogger(GoogleMapsServiceImplementation.class);
    private static final String MAPS_URI = "https://maps.googleapis.com/maps/api/geocode/json";

    @Override
    public MapsResult BuscaCep(String Cep) {
        MapsResult result = new MapsResult();
        if(Pattern.matches("^\\d{5}-\\d{3}$", Cep)) {
            result = GetAddress(Cep);
        }
        else {
            result.setStatus("Cep Inválido");
            log.error(String.format("CEP %s inválido, não será feita consulta no Google Maps", Cep));
        }
        return result;
    }

    private MapsResult GetAddress(String Address) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(MAPS_URI)
                .queryParam("address", Address)
                .queryParam("key", env.getProperty("google.apiKey"));

        log.info(String.format("Request URI: %s",builder.toUriString()));
        MapsResult result = restTemplate.getForObject(builder.toUriString(), MapsResult.class);
        log.info(result != null ? result.toString() : "Sem resposta");
        return result;
    }
}
