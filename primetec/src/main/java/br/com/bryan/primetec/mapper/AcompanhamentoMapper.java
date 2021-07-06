package br.com.bryan.primetec.mapper;

import br.com.bryan.primetec.dto.AcompanhamentoClienteDTO;
import br.com.bryan.primetec.dto.OSparelhoDTO;
import br.com.bryan.primetec.entitites.Cliente;
import br.com.bryan.primetec.entitites.OrdemServico;

public class AcompanhamentoMapper {
	public static AcompanhamentoClienteDTO paraAcompanhamento(Cliente entity) {
		
		AcompanhamentoClienteDTO dto = new AcompanhamentoClienteDTO();
		
		dto.setId_cliente(entity.getCliente_id());
		dto.setCpf(entity.getCpf());
		
		for (OrdemServico ordem : entity.getOrdemServicos()) {
			OSparelhoDTO acompanhamento = new OSparelhoDTO();
			acompanhamento.setAndamento(ordem.getAndamento());
			acompanhamento.setId_OS(ordem.getId_ordem_servico());
			acompanhamento.setMarca(ordem.getAparelho().getAparelho_marca());
			acompanhamento.setModelo(ordem.getAparelho().getAparelho_modelo());
			acompanhamento.setId_aparelho(ordem.getAparelho().getId_aparelho());
			
			dto.getAcompanhamentos().add(acompanhamento);	
		}
		
		return dto;
	}
}
