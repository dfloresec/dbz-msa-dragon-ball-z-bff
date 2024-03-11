package ec.com.dragonballz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.dragonballz.repository.FavoritesRepository;
import ec.com.dragonballz.service.dto.RequestDto;
import ec.com.dragonballz.service.dto.charactes.GaleryDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoritesService {

	private final FavoritesRepository favoritesRepository;

	public List<GaleryDto> getFavorites(String user) {
		return favoritesRepository.getFavorites(user);
	}
	
	public List<GaleryDto> allWithFavorites(String user) {
		return favoritesRepository.allWithFavorites(user);
	}
	
	public void changeStatus(RequestDto req) {
		favoritesRepository.changeStatus(req);
	}
}
