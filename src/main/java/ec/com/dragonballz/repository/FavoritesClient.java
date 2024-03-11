package ec.com.dragonballz.repository;

import java.util.List;

import ec.com.dragonballz.service.dto.charactes.GaleryDto;
import feign.Param;
import feign.RequestLine;

public interface FavoritesClient {

	@RequestLine("GET /favorites/{user}")
	public List<GaleryDto> getFavorites(@Param("user") String user);
	
}