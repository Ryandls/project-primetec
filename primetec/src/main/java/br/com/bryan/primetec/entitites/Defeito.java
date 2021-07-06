package br.com.bryan.primetec.entitites;



import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Defeito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_defeitos;

	private String descricao;

	public Long getId_defeitos() {
		return id_defeitos;
	}

	public void setId_defeitos(Long id_defeitos) {
		this.id_defeitos = id_defeitos;
	}

	public Defeito() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_defeitos);
	}

	public Defeito(String descricao) {
		super();
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Defeito other = (Defeito) obj;
		return Objects.equals(id_defeitos, other.id_defeitos);
	}

	public Defeito(Long id_defeitos) {
		super();
		this.id_defeitos = id_defeitos;
	}
  
	
	
}
