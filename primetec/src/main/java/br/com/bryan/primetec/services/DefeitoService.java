package br.com.bryan.primetec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bryan.primetec.dto.DefeitoDTO;
import br.com.bryan.primetec.mapper.DefeitoMapper;
import br.com.bryan.primetec.repository.DefeitoRepository;

@Service
public class DefeitoService {
	@Autowired
	DefeitoRepository defeitoRepository;
	public List<DefeitoDTO> findAll() {
		
		return DefeitoMapper.paraDTOList(defeitoRepository.findAll());
	}
	
}
