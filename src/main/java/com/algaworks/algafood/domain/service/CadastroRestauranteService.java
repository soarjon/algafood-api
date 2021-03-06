package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroCozinhaService cozinhaService;
	
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.findById(id).orElseThrow(() -> 
				new RestauranteNaoEncontradoException(id));
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);

		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante atualizar(Restaurante restaurante, Long restauranteId) {
		Restaurante restauranteAtual = buscar(restauranteId);
		
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro");
		
		return restauranteAtual;
	}
}
