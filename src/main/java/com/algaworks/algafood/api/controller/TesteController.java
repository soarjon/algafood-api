package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restaraunteRepository;

	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExists(@RequestParam String nome) {
		return cozinhaRepository.existsByNome(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaraurantePorTaxaFrete(@RequestParam BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restaraunteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome-cozinha")
	public List<Restaurante> restaraurantePorTaxaFrete(@RequestParam String nome, Long cozinhaId) {
		return restaraunteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroPorNome(@RequestParam String nome) {
		return restaraunteRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restarauntesTop2PorNome(@RequestParam String nome) {
		return restaraunteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> porNomeEFrete(@RequestParam String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		return restaraunteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	
	
	
}
