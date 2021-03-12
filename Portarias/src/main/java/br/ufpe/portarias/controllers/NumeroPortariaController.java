package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.Cargo;
import br.ufpe.portarias.domain.NumeroPortaria;
import br.ufpe.portarias.domain.UnidadeOrganizacional;
import br.ufpe.portarias.services.NumeroPortariaService;
import br.ufpe.portarias.services.UnidadeService;

@RestController
public class NumeroPortariaController {
	
	
	@Autowired
	private NumeroPortariaService numeroPortariaService;	
	
	
	@RequestMapping(value="/numero/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNumero(@PathVariable Integer id) {
		NumeroPortaria temp = this.numeroPortariaService.buscar(id);
		return ResponseEntity.ok().body(temp);
	}
	
	@RequestMapping(value="/numero", method = RequestMethod.GET)
	public ResponseEntity<?> buscarNumeros() {
		List<NumeroPortaria> temp = this.numeroPortariaService.getAll();
		return ResponseEntity.ok().body(temp);
	}
	
	@RequestMapping(value="/numero/ano/{ano}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarMaxNumeroPorAno(@PathVariable Integer ano) {
		Integer temp = this.numeroPortariaService.buscarMaxPorAno(ano);
		return ResponseEntity.ok().body(temp);
	}
	
	@PostMapping(value="/numero")
	public ResponseEntity<?> inserirNumeroPortaria(@RequestBody NumeroPortaria numero ) {
		NumeroPortaria c = this.numeroPortariaService.inserir(numero);
		return ResponseEntity.ok().body(c);
	}

}
