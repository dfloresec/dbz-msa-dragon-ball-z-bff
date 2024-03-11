package ec.com.dragonballz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.dragonballz.service.FavoritesService;
import ec.com.dragonballz.service.SecurityService;
import ec.com.dragonballz.service.dto.RequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SegFavoritesUpdateController {

	private static final String TOKEN_PREFIX = "Bearer ";

	private final SecurityService securityService;

	private final FavoritesService favoritesService;

	@PostMapping(value = "/v1/dragonballz/favorites")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestHeader("Authorization") String bearerToken, @RequestBody RequestDto req) {
		securityService.validateTolen(bearerToken.replace(TOKEN_PREFIX, ""));
		favoritesService.changeStatus(req);
	}

}
