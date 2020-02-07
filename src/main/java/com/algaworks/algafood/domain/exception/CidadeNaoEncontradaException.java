package com.algaworks.algafood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public CidadeNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format("Não há nenhuma cidade cadastrada com o código %d", cidadeId));
	}

}
