package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	private static final String MSG_ENTIDADE_EM_USO = "A entidade de código %d não pode ser excluida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha); 
	}
	
	public void excluir(Long id) {
		try {
			cozinhaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException(id);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENTIDADE_EM_USO, id));
		}
		
	}

	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new CidadeNaoEncontradaException(cozinhaId));
	}
}
