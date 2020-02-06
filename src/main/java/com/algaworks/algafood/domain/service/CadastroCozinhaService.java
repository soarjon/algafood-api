package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	private static final String MSG_COZINHA_NAO_EXISTENTE = "Não existe cozinha cadastrada com o código %d";
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha); 
	}
	
	public void excluir(Long id) {
		try {
			cozinhaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_COZINHA_NAO_EXISTENTE, id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("A entidade de código %d não pode ser excluida, pois está em uso", id));
		}
		
	}

	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_COZINHA_NAO_EXISTENTE, cozinhaId)));
	}
}
