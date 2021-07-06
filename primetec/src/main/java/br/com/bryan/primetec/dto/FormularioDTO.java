package br.com.bryan.primetec.dto;

import java.util.Set;

public class FormularioDTO {
	
	private String cpf;
	private String nome;
	private String email;
	private String endereco;
	private String complemento;
	private String numero;
	private String telefone;
	private String imei;
	private String cidade;
	private String marca;
	private String modelo;
	private String descricao;
	
	private Set<Long> checklist;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Long> getChecklist() {
		return checklist;
	}

	public void setChecklist(Set<Long> checklist) {
		this.checklist = checklist;
	}

	@Override
	public String toString() {
		return "FormularioDTO [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", complemento=" + complemento + ", numero=" + numero + ", telefone=" + telefone + ", imei=" + imei
				+ ", marca=" + marca + ", modelo=" + modelo + ", descricao=" + descricao + ", checklist=" + checklist
				+ "]";
	}
	
	
	
	
}
