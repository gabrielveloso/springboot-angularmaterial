package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.UnidadeOrganizacional;
import br.ufpe.portarias.services.UnidadeService;

@RestController
public class UnidadeController {
	
	
	@Autowired
	private UnidadeService unidadeService;	
	
	
	@RequestMapping(value="/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarUnidade(@PathVariable Integer id) {
		UnidadeOrganizacional temp = this.unidadeService.buscar(id);
		return ResponseEntity.ok().body(temp);
	}
	
	@RequestMapping(value="/unidade", method = RequestMethod.GET)
	public ResponseEntity<?> buscarUnidades() {
		List<UnidadeOrganizacional> temp = this.unidadeService.getAll();
		return ResponseEntity.ok().body(temp);
	}

}
