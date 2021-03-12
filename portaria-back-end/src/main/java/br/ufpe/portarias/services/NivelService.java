package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.domain.Nivel;
import br.ufpe.portarias.repositories.NivelRepository;

@Service
public class NivelService {
	
	@Autowired
	private NivelRepository rep;
	
	public Nivel buscar(Integer id) {
		Optional<Nivel> temp = rep.findById(id);
		return temp.orElse(null);
	}
	
	public List<Nivel> getAll(){
		List<Nivel> temp = rep.findAll();
		return temp;
	}

}
