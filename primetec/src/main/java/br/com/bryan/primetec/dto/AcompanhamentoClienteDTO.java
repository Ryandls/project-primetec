package br.com.bryan.primetec.dto;

import java.util.ArrayList;
import java.util.List;

public class AcompanhamentoClienteDTO {
	
	private Long id_cliente;
	private String cpf;
	private List<OSparelhoDTO> acompanhamentos = new ArrayList<>();
	
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<OSparelhoDTO> getAcompanhamentos() {
		return acompanhamentos;
	}
	public void setAcompanhamentos(List<OSparelhoDTO> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}	
	
}
