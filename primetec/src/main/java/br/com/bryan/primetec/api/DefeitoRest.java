package br.com.bryan.primetec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bryan.primetec.dto.DefeitoDTO;
import br.com.bryan.primetec.services.DefeitoService;

@RestController
@RequestMapping(value = "/defeitos")

public class DefeitoRest {
	@Autowired
	DefeitoService defeitoService;

	@GetMapping
	public ResponseEntity<List<DefeitoDTO>> listarDefeitos() {
		return new ResponseEntity<>(defeitoService.findAll(), new HttpHeaders(), HttpStatus.OK);
	}
}
