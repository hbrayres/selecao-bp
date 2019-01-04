package br.com.hbrayres.jurosapi.resource;

import static br.com.hbrayres.jurosapi.util.Constantes.PATH_API_LIMITES_CREDITO;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoPersist;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoRequest;
import br.com.hbrayres.jurosapi.domain.response.LimiteCreditoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = PATH_API_LIMITES_CREDITO, produces = APPLICATION_JSON_UTF8_VALUE , tags = {"Limites de Crédito"})
@ApiModel(value = "LimiteCreditoDefinition", description = "Recurso responsável pelas operações em Limite de Crédito")
public interface LimiteCreditoDefinition {

	@ApiOperation(value = "salvar", notes = "Adiciona um novo limite de crédito.", code = 201, response = LimiteCreditoResponse.class, produces = APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses({
		@ApiResponse(code = 201, message = "Entidade criada"),
		@ApiResponse(code = 400, message = "Erro na requisição")
	})
	public ResponseEntity<?> salvar(final LimiteCreditoPersist request);
	
	@ApiOperation(value = "alterar", notes = "Alterar um limite de crédito.", code = 200, response = LimiteCreditoResponse.class, produces = APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Entidade salva"),
		@ApiResponse(code = 400, message = "Erro na requisição"),
		@ApiResponse(code = 404, message = "Informação não encontrada")
	})
	public ResponseEntity<?> alterar(final Long id, final LimiteCreditoRequest request);
	
	@ApiOperation(value = "listar", notes = "Listar limites de créditos conforme parametros.", code = 200, response = LimiteCreditoResponse.class, produces = APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 204, message = "Dados não encontrados"),
		@ApiResponse(code = 400, message = "Erro na requisição")
	})
	public ResponseEntity<?> listar(final LimiteCreditoRequest request);
	
	@ApiOperation(value = "recuperar", notes = "Recuperar limite de Crédito conforme ID", code = 200, response = LimiteCreditoResponse.class, produces = APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Dados não encontrados"),
		@ApiResponse(code = 400, message = "Erro na requisição")
	})	
	public ResponseEntity<?> recuperar(final Long id);
	
	@ApiOperation(value = "remover", notes = "Remover um limite de Crédito conforme ID", code = 200, response = HttpStatus.class, produces = APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Dados não encontrados"),
		@ApiResponse(code = 422, message = "Erro de regras")
	})
	public ResponseEntity<?> remover(final Long id);
}
