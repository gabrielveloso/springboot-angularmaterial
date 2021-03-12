package br.ufpe.portarias.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.ufpe.portarias.domain.NumeroPortaria;

public interface NumeroPortariaRepository extends JpaRepository<NumeroPortaria, Integer> {	
	
	@Transactional(readOnly=true)
	@Query("select max(obj.numero) from NumeroPortaria obj where obj.ano = :ano")
	public Integer findMaxByAno(@Param("ano") Integer ano);

}
