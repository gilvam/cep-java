package com.cep.services;

import com.cep.CepConfiguration;
import com.cep.responses.CepResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class CepService {
	private CepConfiguration cep;
	private final String GET_CEP = CepConfiguration.url("/%s/json");

	public CepService(CepConfiguration cepConfiguration) {
		this.cep = cepConfiguration;
	}

	public Map<String, Object> get(String cep){
		Map<String, Object> map = new HashMap<>();

		try{
			Response response = this.cep.getNewClientNotAuth().target(String.format(GET_CEP, cep)).request().get();

			int ResponseStatus = response.getStatus();

			if (ResponseStatus == 200){
				map.put("status", "success");
				map.put("result", response.readEntity(CepResponse.class));
				return map;
			}
			else if(ResponseStatus != 200){
				map.put("status", "error");
				map.put("error", "CEP inválido");
				return map;
			}
			//error
			if(response.hasEntity()){
				throw new Exception("Error canceling invoice with cep: ");
			}

			response.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return map;
	}
}
