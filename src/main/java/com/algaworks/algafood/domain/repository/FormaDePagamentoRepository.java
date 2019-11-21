package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaDePagamento;

public interface FormaDePagamentoRepository {

	public List<FormaDePagamento> listar();
	
	public FormaDePagamento buscar(Long id);
	
	public FormaDePagamento salvar(FormaDePagamento formaDePagamento);
	
	public void excluir(FormaDePagamento formaDePagamento); 
}
