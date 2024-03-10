package ec.com.dragonballz.service;

import org.springframework.stereotype.Service;

import ec.com.dragonballz.repository.SecurityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {

	private final SecurityRepository securityRepository;

	public void validateTolen(String token) {
		securityRepository.validateToken(token);
	}
}
