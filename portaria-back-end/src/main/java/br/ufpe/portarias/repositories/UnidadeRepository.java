package br.ufpe.portarias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpe.portarias.domain.UnidadeOrganizacional;

public interface UnidadeRepository extends JpaRepository<UnidadeOrganizacional, Integer> {

}
