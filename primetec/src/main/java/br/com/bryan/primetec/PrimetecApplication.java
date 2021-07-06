package br.com.bryan.primetec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bryan.primetec.entitites.Defeito;
import br.com.bryan.primetec.enuns.EnumDefeito;
import br.com.bryan.primetec.repository.DefeitoRepository;

@SpringBootApplication
public class PrimetecApplication implements CommandLineRunner {

	@Autowired
	DefeitoRepository defeitoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimetecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Defeito> defeitosIniciais = new ArrayList<>();
		
		for (EnumDefeito defeito : EnumDefeito.values()) {
			defeitosIniciais.add(new Defeito(defeito.getDescricao()));
		}
		
		defeitoRepository.saveAll(defeitosIniciais);
		
	}

}
