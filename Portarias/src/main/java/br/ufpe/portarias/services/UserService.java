package br.ufpe.portarias.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.ufpe.portarias.security.UserSS;

public class UserService {
	
	public static UserSS athenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;			
		}
	}

}
