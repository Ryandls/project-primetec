package br.com.bryan.primetec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bryan.primetec.dto.AcompanhamentoClienteDTO;
import br.com.bryan.primetec.dto.ClienteDTO;
import br.com.bryan.primetec.dto.FormularioDTO;
import br.com.bryan.primetec.entitites.Cliente;
import br.com.bryan.primetec.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")

public class ClienteRest {
	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		return new ResponseEntity<>(clienteService.findAll(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<ClienteDTO> recuperarClientePorId(@PathVariable String cpf) {
		return new ResponseEntity<>(clienteService.recuperarClientePorId(cpf), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/acompanhamento/{cpf}")
	public ResponseEntity<AcompanhamentoClienteDTO> listarAcompanhamento(@PathVariable String cpf) {
		return new ResponseEntity<>(clienteService.fetchAcompanhamento(cpf), new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AcompanhamentoClienteDTO> inserirCliente(@RequestBody FormularioDTO formulario) {

		return new ResponseEntity<>(clienteService.inserir(formulario), new HttpHeaders(), HttpStatus.OK);
	}

}
