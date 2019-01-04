package br.com.hbrayres.jurosapi;

import static java.math.BigDecimal.TEN;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.com.hbrayres.jurosapi.domain.entities.LimiteCredito;
import br.com.hbrayres.jurosapi.domain.enums.Risco;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoPersist;
import br.com.hbrayres.jurosapi.domain.request.LimiteCreditoRequest;
import br.com.hbrayres.jurosapi.repository.LimiteCreditoRepository;
import br.com.hbrayres.jurosapi.service.LimiteCreditoService;

@RunWith(MockitoJUnitRunner.class)
public class LimiteCreditoServiceTest {

	@Mock
	private LimiteCreditoRepository limiteCreditoRepository;

	@InjectMocks
	private LimiteCreditoService limiteCreditoService;

	private LimiteCreditoPersist requestPersistMock;

	private LimiteCreditoRequest requestUpdateMock;

	private LimiteCredito entitySavedMock;

	@Before
	public void init() {

		requestPersistMock = LimiteCreditoPersist.builder().nomeCliente("TESTE").limiteCredito(TEN).risco(Risco.A)
				.build();

		entitySavedMock = new LimiteCredito();

		final ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(STRICT);

		mapper.map(requestPersistMock, entitySavedMock);

		entitySavedMock.setId(10L);

		requestUpdateMock = LimiteCreditoRequest.builder().nomeCliente("TESTE").limiteCredito(TEN).risco(Risco.A)
				.build();
	}

	@Test
	public void salvarTest() {

		when(limiteCreditoRepository.save(Mockito.any(LimiteCredito.class))).thenReturn(entitySavedMock);

		limiteCreditoService.salvar(requestPersistMock);

		verify(limiteCreditoRepository, times(1)).save(Mockito.any(LimiteCredito.class));

	}

	@Test
	public void alterarTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.of(entitySavedMock);

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		when(limiteCreditoRepository.save(Mockito.any(LimiteCredito.class))).thenReturn(entitySavedMock);

		limiteCreditoService.alterar(10l, requestUpdateMock);

		verify(limiteCreditoRepository, times(1)).save(Mockito.any(LimiteCredito.class));

	}

	@Test(expected = RuntimeException.class)
	public void alterarErroNaoEncontradoTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.empty();

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		limiteCreditoService.alterar(10l, requestUpdateMock);

	}

	@Test(expected = RuntimeException.class)
	public void removerErroNaoEncontradoTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.empty();

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		limiteCreditoService.remover(10l);

	}

	@Test
	public void removerTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.of(entitySavedMock);

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		limiteCreditoService.remover(10l);
		
		verify(limiteCreditoRepository, times(1)).deleteById(Mockito.anyLong());

	}
	
	@Test
	public void recuperarTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.of(entitySavedMock);

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		limiteCreditoService.recuperar(10l);
		
		verify(limiteCreditoRepository, times(2)).findById(Mockito.anyLong());

	}
	
	@Test(expected = RuntimeException.class)
	public void recuperarNaoEncontradoTest() {

		final Optional<LimiteCredito> optionalEntity = Optional.empty();

		when(limiteCreditoRepository.findById(Mockito.anyLong())).thenReturn(optionalEntity);

		limiteCreditoService.recuperar(10l);
		
		verify(limiteCreditoRepository, times(2)).findById(Mockito.anyLong());

	}

}
