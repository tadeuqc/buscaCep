package com.tadeuqc.buscaCep.service;

import com.tadeuqc.buscaCep.model.MapsResult;

public interface GoogleMapsService {
    MapsResult BuscaCep(String Cep);
}
