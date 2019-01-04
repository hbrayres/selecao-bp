package br.com.hbrayres.jurosapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.hbrayres.jurosapi.domain.enums.Risco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "LimiteCreditoPersist", value = "LimiteCreditoPersist")
public class LimiteCreditoPersist implements Serializable {

	private static final long serialVersionUID = -1592262653381236921L;

	@NotNull(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 100, message = "Limite mínimo de 2 e máximo de 100")
	@ApiModelProperty(value = "Nome do cliente", position = 1, example = "José da Silva", required = true)
	private String nomeCliente;

	@NotNull(message = "Limite Crédito não pode ser vazio")
	@ApiModelProperty(value = "Limite de Crédito", position = 2, example = "12.300", required = true)
	private BigDecimal limiteCredito;
	
	@NotNull(message = "Risco não pode ser vazio")
	@ApiModelProperty(value = "Risco de crédito", position = 3, example = "A", required = true)
	private Risco risco;
}
