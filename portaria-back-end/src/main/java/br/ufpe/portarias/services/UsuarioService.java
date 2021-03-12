package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.controllers.exceptions.AuthorizationException;
import br.ufpe.portarias.domain.Usuario;
import br.ufpe.portarias.domain.enums.Perfil;
import br.ufpe.portarias.repositories.UsuarioRepository;
import br.ufpe.portarias.security.UserSS;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository rep;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario buscar(Integer id) {
		UserSS user = UserService.athenticated();
		
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		Optional<Usuario> temp = rep.findById(id);
		return temp.orElse(null);
	}
	
	public List<Usuario> getAll(){
		List<Usuario> temp = rep.findAll();
		return temp;
	}
	
	public Usuario inserir(Usuario u) {		
		u.setSenha(pe.encode(u.getSenha()));		
		Usuario temp = rep.save(u);
		return temp;
	}

}
