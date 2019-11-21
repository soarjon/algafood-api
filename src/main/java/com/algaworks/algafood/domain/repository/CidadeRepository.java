package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

	public List<Cidade> listar();

	public Cidade salvar(Cidade cidade);

	public Cidade buscar(Long id);

	public void deletar(Cidade cidade);
}
