package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class ParService {

    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}