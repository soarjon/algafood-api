package com.algaworks.algafood.domain.exception;

public class EntitidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntitidadeNaoEncontradaException(String msg) {
		super(msg);
	}

}
