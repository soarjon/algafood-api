package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> listar() {
		return estadoRepository.listar();
	}
	
	public Estado buscar(Long estadoId) {
		Estado estado = null;
		try {
			estado = estadoRepository.buscar(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há nenhum estado cadastrado com o código %d", estadoId));
		}
		
		return estado;
		
	}

	public Estado salvar(Estado estado) {
		return estadoRepository.salvar(estado);
	}
	
	public Estado atualizar(Estado estado, Long estadoId) {
		Estado estadoAtual = null;
		try {
			estadoAtual = estadoRepository.buscar(estadoId);
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			estadoRepository.salvar(estadoAtual);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há nenhum estado cadastrado com o código %d", estadoId));
		}
		
		return estadoAtual;
	}
	
	public void deletar(Long estadoId) {
		try {
			estadoRepository.deletar(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há nenhum estado cadastrado com o código %d", estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Entidade de código %d não pode ser excluida, pois está sendo usada", estadoId));
		}
	}
}
