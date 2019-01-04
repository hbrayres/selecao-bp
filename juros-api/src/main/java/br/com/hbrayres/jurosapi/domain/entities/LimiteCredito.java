package br.com.hbrayres.jurosapi.domain.entities;

import static javax.persistence.GenerationType.AUTO;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LIMITES_CREDITOS")
public class LimiteCredito {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	
	@Column(name = "NOME_CLIENTE")
	private String nomeCliente;
	
	@Column(name = "LIMITE_CREDITO")
	private BigDecimal limiteCredito;
	
	@Column(name = "RISCO")
	private String risco;
	
	@Column(name = "JUROS")
	private BigDecimal juros;
}
