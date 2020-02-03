package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping()
	public List<Restaurante> listar() {
		return cadastroRestauranteService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		try {
			Restaurante restaurante = cadastroRestauranteService.buscar(id);
			return ResponseEntity.ok(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.atualizar(restaurante, restauranteId);
			if(restaurante == null) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, 
			@RequestBody Map<String, Object> campos) {
		
		Restaurante restauranteAtual = cadastroRestauranteService.buscar(restauranteId);
		if(restauranteAtual == null) {
			return ResponseEntity.notFound().build();
		}
		
		merge(campos, restauranteAtual);
		
		return atualizar(restauranteId, restauranteAtual);
		
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper mapper = new ObjectMapper();
		Restaurante restauranteOrigem = mapper.convertValue(dadosOrigem, Restaurante.class);
		
//		System.out.println(restauranteOrigem);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
//			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}
}
