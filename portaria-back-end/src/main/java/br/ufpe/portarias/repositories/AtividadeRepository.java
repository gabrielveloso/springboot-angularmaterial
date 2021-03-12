package br.ufpe.portarias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpe.portarias.domain.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}
