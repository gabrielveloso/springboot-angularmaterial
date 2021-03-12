package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.Nivel;
import br.ufpe.portarias.services.NivelService;

@RestController
public class NivelController {
	
	
	@Autowired
	private NivelService nivelService;	
	
	
	@RequestMapping(value="/nivel/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNivel(@PathVariable Integer id) {
		Nivel temp = this.nivelService.buscar(id);
		return ResponseEntity.ok().body(temp);
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/nivel", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNiveis() {
		List<Nivel> temp = this.nivelService.getAll();
		return ResponseEntity.ok().body(temp);
	}

}
