package br.com.bryan.primetec.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bryan.primetec.services.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordem-servico")

public class OrdemServicoRest {
	@Autowired
	OrdemServicoService ordemServicoService;

	@PutMapping(value = "/finalizar/{idOrdem}")
	public ResponseEntity<Void> finalizarOrdem(@PathVariable Long idOrdem) {
		ordemServicoService.finalizar(idOrdem);
		return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
	}

}
