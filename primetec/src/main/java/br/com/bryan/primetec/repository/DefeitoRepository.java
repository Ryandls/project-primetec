package br.com.bryan.primetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bryan.primetec.entitites.Defeito;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito, Long> {
	
}
