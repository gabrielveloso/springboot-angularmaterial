package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.domain.NumeroPortaria;
import br.ufpe.portarias.repositories.NumeroPortariaRepository;

@Service
public class NumeroPortariaService {
	
	@Autowired
	private NumeroPortariaRepository rep;
	
	public NumeroPortaria buscar(Integer id) {
		Optional<NumeroPortaria> temp = rep.findById(id);
		return temp.orElse(null);
	}
	
	public List<NumeroPortaria> getAll(){
		List<NumeroPortaria> temp = rep.findAll();
		return temp;
	}
	
	public NumeroPortaria inserir(NumeroPortaria temp){
		return rep.save(temp);
	}
	
	public Integer buscarMaxPorAno(Integer ano) {
		return rep.findMaxByAno(ano);
		
	}

}
