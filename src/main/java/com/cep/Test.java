package com.cep;

import com.cep.services.CepService;

import java.util.Map;

public class Test {

    public static void main(String[] args){
        String cep = null;
        Map<String, Object> map = null;
        CepConfiguration cepConfiguration = new CepConfiguration();

        cep = "30180-001"; //ok
        map = new CepService(cepConfiguration).get(cep);
        System.out.println(map);

        cep = "301200";  //erro
        map = new CepService(cepConfiguration).get(cep);
        System.out.println(map);
    }
}
