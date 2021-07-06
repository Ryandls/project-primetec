package br.com.bryan.primetec.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.bryan.primetec.dto.DefeitoDTO;
import br.com.bryan.primetec.entitites.Defeito;

public class DefeitoMapper {

	public static DefeitoDTO paraDTO(Defeito entity) {

		return new DefeitoDTO(entity.getId_defeitos(), entity.getDescricao());
	}

	public static List<DefeitoDTO> paraDTOList(List<Defeito> entityList) {
		List<DefeitoDTO> dtoList = new ArrayList<>();

		for (Defeito defeito : entityList) {
			dtoList.add(paraDTO(defeito));
		}

		return dtoList;
	}

}
