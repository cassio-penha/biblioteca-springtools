package br.org.serratec.biblioteca.services;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.biblioteca.dtos.FakeStoreUserDto;
import br.org.serratec.biblioteca.dtos.RestApiDto;


@Service
public class ClientRestService {
	public FakeStoreUserDto findByIndFromFakeApi(Integer userId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://fakestoreapi.com/users/{id}";
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("id", userId.toString());
		
		FakeStoreUserDto dto = restTemplate.getForObject(uri, FakeStoreUserDto.class, params);
		
		return dto;	
	}
	
	public FakeStoreUserDto findByIndFromFakeApi2(String userId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://fakestoreapi.com/users/" + userId;
		
		FakeStoreUserDto dto = restTemplate.getForObject(uri, FakeStoreUserDto.class);
		
		return dto;	
	}

	public RestApiDto fakeStoreUserDto(Integer userId) {
		return null;
	}

}