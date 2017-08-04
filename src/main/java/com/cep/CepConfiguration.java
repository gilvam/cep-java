package com.cep;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class CepConfiguration {

	private final static String URL = "https://viacep.com.br/ws";

	public Client getNewClientNotAuth() {
		return ClientBuilder.newClient();
	}

	public static String url(String endpoint) {
		return URL + endpoint;
	}

}