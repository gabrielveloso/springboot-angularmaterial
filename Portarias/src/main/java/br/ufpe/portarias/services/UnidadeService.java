package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.domain.UnidadeOrganizacional;
import br.ufpe.portarias.repositories.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository rep;
	
	public UnidadeOrganizacional buscar(Integer id) {
		Optional<UnidadeOrganizacional> temp = rep.findById(id);
		return temp.orElse(null);
	}
	
	public List<UnidadeOrganizacional> getAll(){
		List<UnidadeOrganizacional> temp = rep.findAll();
		return temp;
	}

}
