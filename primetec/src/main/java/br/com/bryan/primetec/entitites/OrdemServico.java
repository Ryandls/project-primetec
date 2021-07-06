package br.com.bryan.primetec.entitites;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ordem_servico;
	
	private String andamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_aparelho")
	private Aparelho aparelho;
	
	public OrdemServico() {
		
	}

	public OrdemServico(Long id_ordem_servico, String andamento, Cliente cliente) {
		super();
		this.id_ordem_servico = id_ordem_servico;
		this.andamento = andamento;
		this.cliente = cliente;
	}

	public Long getId_ordem_servico() {
		return id_ordem_servico;
	}

	public void setId_ordem_servico(Long id_ordem_servico) {
		this.id_ordem_servico = id_ordem_servico;
	}

	public String getAndamento() {
		return andamento;
	}

	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_ordem_servico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id_ordem_servico, other.id_ordem_servico);
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	
	
}
	
