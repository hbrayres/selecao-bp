package br.com.hbrayres.jurosapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "LimiteCreditoRequest", value = "LimiteCreditoRequest")
public class LimiteCreditoRequest implements Serializable {

	private static final long serialVersionUID = -8751496064815702513L;

	@ApiModelProperty(value = "Nome do cliente", position = 1, example = "José da Silva")
	private String nomeCliente;

	@ApiModelProperty(value = "Limite de Crédito", position = 2, example = "12.300")
	private BigDecimal limiteCredito;
	
	@ApiModelProperty(value = "Risco de crédito", position = 3, example = "A")
	private Risco risco;
	
}
