package br.ufpe.portarias.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"atividade_id" , "nivel_id", "unidade_id"})})
public class Cargo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "atividade_id")
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name = "nivel_id")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private UnidadeOrganizacional unidade;
	
	
	
	public Cargo() {
		
	}


	public Cargo(Integer id, Atividade atividade, Nivel nivel, UnidadeOrganizacional unidade) {
		super();
		this.id = id;
		this.atividade = atividade;
		this.nivel = nivel;
		this.unidade = unidade;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Atividade getAtividade() {
		return atividade;
	}


	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}


	public Nivel getNivel() {
		return nivel;
	}


	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}


	public UnidadeOrganizacional getUnidade() {
		return unidade;
	}


	public void setUnidade(UnidadeOrganizacional unidade) {
		this.unidade = unidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
