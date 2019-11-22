package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	public List<Estado> listar();

	public Estado salvar(Estado estado);

	public Estado buscar(Long id);

	public void deletar(Long id);
}
