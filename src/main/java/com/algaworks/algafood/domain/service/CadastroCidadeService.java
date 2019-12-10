package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	public Cidade buscar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId).orElseThrow(() -> 
				new EntidadeNaoEncontradaException(
						String.format("Não há nenhum estado cadastrado com o código %d", cidadeId)));		
	}

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId).orElseThrow(() -> 
			new EntidadeNaoEncontradaException(
				String.format("Não há nenhum estado cadastrado com o código %d", estadoId)));
		
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}
	
	public Cidade atualizar(Cidade cidade, Long cidadeId) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow((() -> new EntidadeNaoEncontradaException(
						String.format("Não há nenhum estado cadastrado com o código %d", estadoId))));
		
		Cidade cidadeAtual = buscar(cidadeId);
		
		if(cidadeAtual == null) {
			return cidadeAtual;
		}
		
		cidade.setEstado(estado);
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		
		cidadeRepository.save(cidadeAtual);
		
		return cidadeAtual;
	}
	
	public void deletar(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não há nenhuma cidade cadastrado com o código %d", cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Entidade de código %d não pode ser excluida, pois está sendo usada", cidadeId));
		}
	}
}
