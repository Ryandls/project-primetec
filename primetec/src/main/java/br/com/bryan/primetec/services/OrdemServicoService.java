package br.com.bryan.primetec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bryan.primetec.entitites.OrdemServico;
import br.com.bryan.primetec.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	public void finalizar(Long idOrdem) {
		OrdemServico ordem = ordemServicoRepository.getById(idOrdem);
		ordem.setAndamento("Finalizado");
		ordemServicoRepository.save(ordem);
	}

}
