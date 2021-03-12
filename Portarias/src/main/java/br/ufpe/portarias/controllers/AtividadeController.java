package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.Atividade;
import br.ufpe.portarias.services.AtividadeService;

@RestController
public class AtividadeController {
	
	
	@Autowired
	private AtividadeService nivelService;		
	
	
	
	@RequestMapping(value="/atividade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarAtividade(@PathVariable Integer id) {
		Atividade temp = this.nivelService.buscar(id);
		return ResponseEntity.ok().body(temp);
	}
	
	@RequestMapping(value="/atividade", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNiveis() {
		List<Atividade> temp = this.nivelService.getAll();
		return ResponseEntity.ok().body(temp);
	}

}
