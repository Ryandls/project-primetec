package br.com.bryan.primetec.dto;

public class OSparelhoDTO {
	
	private Long id_OS;
	private Long id_aparelho;
	private String marca;
	private String modelo;
	private String andamento;
	public Long getId_OS() {
		return id_OS;
	}
	public void setId_OS(Long id_OS) {
		this.id_OS = id_OS;
	}
	public Long getId_aparelho() {
		return id_aparelho;
	}
	public void setId_aparelho(Long id_aparelho) {
		this.id_aparelho = id_aparelho;
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
	public String getAndamento() {
		return andamento;
	}
	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}
	
	
}
