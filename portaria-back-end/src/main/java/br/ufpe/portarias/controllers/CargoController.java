package br.ufpe.portarias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.portarias.domain.Atividade;
import br.ufpe.portarias.domain.Cargo;
import br.ufpe.portarias.services.AtividadeService;
import br.ufpe.portarias.services.CargoService;

@RestController
@RequestMapping(value = "/cargo")
public class CargoController {
	
	
	
	@Autowired
	private CargoService cargoService;	
	
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ResponseEntity<?> buscarCargos() {
		List<Cargo> temp = this.cargoService.getAll();
		return ResponseEntity.ok().body(temp);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCargos(@PathVariable Integer id) {
		this.cargoService.deletar(id);
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping()
	public ResponseEntity<?> inserirCargo(@RequestBody Cargo cargo ) {
		Cargo c = this.cargoService.inserir(cargo);
		return ResponseEntity.ok().body(c);
	}
	


}
