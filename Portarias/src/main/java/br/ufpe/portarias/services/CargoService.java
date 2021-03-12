package br.ufpe.portarias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.portarias.domain.Cargo;
import br.ufpe.portarias.repositories.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository rep;
	
	public Cargo buscar(Integer id) {
		Optional<Cargo> temp = rep.findById(id);
		return temp.orElse(null);
	}
	
	public List<Cargo> getAll(){
		List<Cargo> temp = rep.findAll();
		return temp;
	}
	
	public void deletar(Integer id){
		rep.deleteById(id);		
	}
	
	public Cargo inserir(Cargo cargo){
		Cargo c = rep.save(cargo);
		return c;
	}

}
