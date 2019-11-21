package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;

@Component
public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaDePagamento> listar() {
		return manager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
	}

	@Override
	public FormaDePagamento buscar(Long id) {
		return manager.find(FormaDePagamento.class, id);
	}

	@Override
	public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
		return manager.merge(formaDePagamento);
	}

	@Override
	public void excluir(FormaDePagamento formaDePagamento) {
		manager.remove(formaDePagamento);
	}

}
