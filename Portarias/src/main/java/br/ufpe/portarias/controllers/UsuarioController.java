package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.Usuario;
import br.ufpe.portarias.services.UsuarioService;

@RestController
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService nivelService;	
	
	
	@RequestMapping(value="/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarUsuario(@PathVariable Integer id) {
		Usuario temp = this.nivelService.buscar(id);
		return ResponseEntity.ok().body(temp);
	}
	
	@RequestMapping(value="/usuario", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNiveis() {
		List<Usuario> temp = this.nivelService.getAll();
		return ResponseEntity.ok().body(temp);
	}

}
