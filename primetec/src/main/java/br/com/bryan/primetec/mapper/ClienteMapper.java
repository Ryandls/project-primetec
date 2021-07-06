package br.com.bryan.primetec.mapper;

import br.com.bryan.primetec.dto.ClienteDTO;
import br.com.bryan.primetec.entitites.Cliente;

public class ClienteMapper {
		public static ClienteDTO paraClienteDTO(Cliente cliente) {
			ClienteDTO clienteDTO = new ClienteDTO();
			
			clienteDTO.setId(cliente.getCliente_id());
			clienteDTO.setNome(cliente.getNome());
			clienteDTO.setEmail(cliente.getEmail());
			clienteDTO.setCpf(cliente.getCpf());
			clienteDTO.setTelefone(cliente.getTelefone());
			clienteDTO.setEndereco(cliente.getEndereco());
			clienteDTO.setComplemento(cliente.getComplemento());
			clienteDTO.setNumero(cliente.getNumero());
			clienteDTO.setCidade(cliente.getCidade());
			
			
			
			return clienteDTO;
		}
}
