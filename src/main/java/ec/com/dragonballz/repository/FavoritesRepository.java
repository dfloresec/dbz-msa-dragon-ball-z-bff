package ec.com.dragonballz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ec.com.dragonballz.service.dto.RequestDto;
import ec.com.dragonballz.service.dto.charactes.GaleryDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Repository
public class FavoritesRepository {

	public List<GaleryDto> getFavorites(String user) {
		FavoritesClient client = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.target(FavoritesClient.class, "http://localhost:8082");
		return client.getFavorites(user);
	}

	public void changeStatus(RequestDto req) {
		FavoritesUpdateClient client = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.target(FavoritesUpdateClient.class, "http://localhost:8082");
		client.changeStatus(req);
	}

}
