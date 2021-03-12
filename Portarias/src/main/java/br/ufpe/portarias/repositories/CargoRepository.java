package br.ufpe.portarias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpe.portarias.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
