package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.controllers.exceptions.ObjectNotFoundException;
import br.ufpe.portarias.domain.Atividade;
import br.ufpe.portarias.repositories.AtividadeRepository;


@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository rep;
	
	public Atividade buscar(Integer id) {
		Optional<Atividade> temp = rep.findById(id);		
		return temp.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Atividade.class.getName()));
		
		
	}
	
	public List<Atividade> getAll(){
		List<Atividade> temp = rep.findAll();
		return temp;
	}

}
