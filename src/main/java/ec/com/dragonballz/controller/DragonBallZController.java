package ec.com.dragonballz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.dragonballz.service.FavoritesService;
import ec.com.dragonballz.service.SecurityService;
import ec.com.dragonballz.service.dto.charactes.GaleryDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DragonBallZController {
	
	private static final String TOKEN_PREFIX = "Bearer ";

	private final SecurityService securityService;
	
	private final FavoritesService favoritesService;

	@GetMapping(value = "/v1/dragonballz/favorites/{user}")
	@ResponseStatus(HttpStatus.OK)
	private List<GaleryDto> getFavorities(@RequestHeader("Authorization") String bearerToken, @PathVariable(value = "user") String user) {
		securityService.validateTolen(bearerToken.replace(TOKEN_PREFIX, ""));
		return favoritesService.getFavorites(user);
	}

}
