package ec.com.dragonballz.repository;

import org.springframework.web.bind.annotation.RequestBody;

import ec.com.dragonballz.service.dto.RequestDto;
import feign.Headers;
import feign.RequestLine;

public interface FavoritesUpdateClient {

	@RequestLine("POST /favorite")
	@Headers("Content-Type: application/json")
	public void changeStatus(@RequestBody RequestDto req);

}