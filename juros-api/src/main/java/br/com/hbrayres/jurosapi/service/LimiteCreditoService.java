package br.com.hbrayres.jurosapi.service;

import static org.modelmapper.convention.MatchingStrategies.STRICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hbrayres.jurosapi.domain.entities.LimiteCredito;
import br.com.hbrayres.jurosapi.domain.enums.Risco;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoPersist;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoRequest;
import br.com.hbrayres.jurosapi.domain.response.LimiteCreditoResponse;
import br.com.hbrayres.jurosapi.repository.LimiteCreditoRepository;

@Service
public class LimiteCreditoService {

	@Autowired
	private LimiteCreditoRepository limiteCreditoRepository;

	public ResponseEntity<?> salvar(final LimiteCreditoPersist request) {

		LimiteCredito persist = new LimiteCredito();

		persist.setJuros(request.getRisco().getTaxaJuros());

		requestToEntity(request, persist);

		persist = limiteCreditoRepository.save(persist);

		return buildResponse(persist, CREATED);
	}

	public ResponseEntity<?> alterar(final Long id, final LimiteCreditoRequest request) {

		limiteCreditoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));

		LimiteCredito persist = limiteCreditoRepository.findById(id).get();

		persist.setJuros(request.getRisco().getTaxaJuros());

		requestToEntity(request, persist);

		persist = limiteCreditoRepository.save(persist);

		return buildResponse(persist, CREATED);
	}

	public ResponseEntity<?> listar(final LimiteCreditoRequest request) {

		LimiteCredito limiteCredito = new LimiteCredito();

		requestToEntity(request, limiteCredito);

		Example<LimiteCredito> limiteQuery = Example.of(limiteCredito);

		final List<LimiteCredito> resultado = limiteCreditoRepository.findAll(limiteQuery);

		return new ResponseEntity<List<LimiteCredito>>(resultado, OK);
	}

	public void remover(final Long id) {

		limiteCreditoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));

		limiteCreditoRepository.deleteById(id);

	}

	public ResponseEntity<?> recuperar(Long id) {

		limiteCreditoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));

		return buildResponse(limiteCreditoRepository.findById(id).get(), OK);

	}

	private void requestToEntity(final Object request, LimiteCredito persist) {

		final ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(STRICT);

		mapper.map(request, persist);

	}

	private ResponseEntity<?> buildResponse(LimiteCredito persist, HttpStatus status) {

		final LimiteCreditoResponse response = LimiteCreditoResponse.builder().id(persist.getId())
				.nomeCliente(persist.getNomeCliente()).limiteCredito(persist.getLimiteCredito())
				.juros(persist.getJuros()).risco(Risco.valueOf(persist.getRisco())).build();

		return new ResponseEntity<LimiteCreditoResponse>(response, status);
	}

}
