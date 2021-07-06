package br.com.bryan.primetec.dto;

public class DefeitoDTO {
	private Long id;
	private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public DefeitoDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	
}
