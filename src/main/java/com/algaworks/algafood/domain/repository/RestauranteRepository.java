package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	public List<Restaurante> listar();

	public Restaurante salvar(Restaurante restaurante);

	public Restaurante buscar(Long id);

	public void deletar(Long id);
	
}
