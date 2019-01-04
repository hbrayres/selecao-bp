package br.com.hbrayres.jurosapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "LimiteCreditoResponse", value = "LimiteCreditoResponse")
public class LimiteCreditoResponse implements Serializable {

	private static final long serialVersionUID = 8195486432351576604L;

	@ApiModelProperty(value = "identificador do Limite", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "Nome do cliente", position = 2)
	private String nomeCliente;

	@ApiModelProperty(value = "Limite de crédito", position = 3)
	private BigDecimal limiteCredito;
	
	@ApiModelProperty(value = "Risco do cliente", position = 4)
	private Risco risco;
	
	@ApiModelProperty(value = "Juros calculado", position = 5)
	private BigDecimal juros;
	
}
