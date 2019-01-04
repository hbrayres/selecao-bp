package br.com.hbrayres.jurosapi.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoPersist;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoRequest;
import br.com.hbrayres.jurosapi.service.LimiteCreditoService;
import br.com.hbrayres.jurosapi.util.Constantes;

@RestController
@RequestMapping(value = Constantes.PATH_API_LIMITES_CREDITO)
public class LimiteCreditoResource implements LimiteCreditoDefinition {

	@Autowired
	private LimiteCreditoService limiteCreditoService;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public ResponseEntity<?> salvar(@Valid @RequestBody final LimiteCreditoPersist request) {
		return limiteCreditoService.salvar(request);
	}
	
	@ResponseStatus(OK)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> alterar(@PathVariable("id") final Long id, @RequestBody final LimiteCreditoRequest request) {
		return limiteCreditoService.alterar(id, request);
	}
	
	@GetMapping
	@ResponseStatus(OK)
	public ResponseEntity<?> listar(@ModelAttribute final LimiteCreditoRequest request) {
		return limiteCreditoService.listar(request);
	}
	
	@ResponseStatus(OK)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> recuperar(@PathVariable("id") final Long id) {
		return limiteCreditoService.recuperar(id);
	}
	
	@ResponseStatus(OK)
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> remover(@PathVariable("id") final Long id) {
		limiteCreditoService.remover(id);
		return new ResponseEntity<>(OK);
	}
	
}
