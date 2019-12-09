package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.findById(id).orElseThrow(() -> 
				new EntidadeNaoEncontradaException(String.format("Não há nenhum restaraurante cadastrado com o código %d", id)));
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não há nenhuma cozinha cadastrada com o código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante atualizar(Restaurante restaurante, Long restauranteId) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não há nenhuma cozinha cadastrada com o código %d", cozinhaId)));
	
		
		Restaurante restauranteAtual = buscar(restauranteId);
		if(restauranteAtual == null) {
			return restauranteAtual;
		}
		
		restaurante.setCozinha(cozinha);
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
		
		return restauranteAtual;
	}
}
