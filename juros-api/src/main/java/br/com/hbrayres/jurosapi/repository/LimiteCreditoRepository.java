package br.com.hbrayres.jurosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hbrayres.jurosapi.domain.entities.LimiteCredito;

public interface LimiteCreditoRepository extends JpaRepository<LimiteCredito, Long> {

}
