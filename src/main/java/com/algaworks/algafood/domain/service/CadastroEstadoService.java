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
	
	private static final String MSG_ESTADO_EM_USO = "Entidade de código %d não pode ser excluida, pois está sendo usada";
	private static final String MSG_ESTADO_INEXISTENTE = "Não há nenhum estado cadastrado com o código %d";
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	public Estado buscar(Long estadoId) {
			return estadoRepository.findById(estadoId).orElseThrow(() -> 
				new EntidadeNaoEncontradaException(
					String.format(MSG_ESTADO_INEXISTENTE, estadoId)));
	}

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public Estado atualizar(Estado estado, Long estadoId) {
		Estado estadoAtual = buscar(estadoId);
		
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		estadoRepository.save(estadoAtual);
	
		return estadoAtual;
	}
	
	public void deletar(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_ESTADO_INEXISTENTE, estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}
}
