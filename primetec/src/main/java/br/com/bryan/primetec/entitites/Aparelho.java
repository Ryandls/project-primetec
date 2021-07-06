package br.com.bryan.primetec.entitites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Aparelho implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_aparelho;
	
	private String aparelho_imei;
	private String aparelho_marca;
	private String aparelho_modelo;
	private String descricao;
	
	@OneToMany(mappedBy = "aparelho", cascade = CascadeType.ALL)
	private List<OrdemServico> ordemServicos = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "Defeito_Aparelho",
			joinColumns = {@JoinColumn(name = "id_aparelho")},
			inverseJoinColumns = {@JoinColumn(name = "id_defeito")}
	)
	private List<Defeito> defeitos = new ArrayList<>();
	
	
	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public List<Defeito> getDefeitos() {
		return defeitos;
	}

	public void setDefeitos(List<Defeito> defeitos) {
		this.defeitos = defeitos;
	}

	public Aparelho() {
	}

	public Aparelho(Long id_aparelho, String aparelho_imei, String aparelho_marca, String aparelho_modelo,
			String descricao) {
		super();
		this.id_aparelho = id_aparelho;
		this.aparelho_imei = aparelho_imei;
		this.aparelho_marca = aparelho_marca;
		this.aparelho_modelo = aparelho_modelo;
		this.descricao = descricao;
	}

	public Long getId_aparelho() {
		return id_aparelho;
	}

	public void setId_aparelho(Long id_aparelho) {
		this.id_aparelho = id_aparelho;
	}

	public String getAparelho_imei() {
		return aparelho_imei;
	}

	public void setAparelho_imei(String aparelho_imei) {
		this.aparelho_imei = aparelho_imei;
	}

	public String getAparelho_marca() {
		return aparelho_marca;
	}

	public void setAparelho_marca(String aparelho_marca) {
		this.aparelho_marca = aparelho_marca;
	}

	public String getAparelho_modelo() {
		return aparelho_modelo;
	}

	public void setAparelho_modelo(String aparelho_modelo) {
		this.aparelho_modelo = aparelho_modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_aparelho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		return Objects.equals(id_aparelho, other.id_aparelho);
	}
}
