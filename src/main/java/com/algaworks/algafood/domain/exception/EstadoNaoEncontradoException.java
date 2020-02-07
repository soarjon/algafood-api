package com.algaworks.algafood.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public EstadoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public EstadoNaoEncontradoException(Long estadoId) {
		this(String.format("Não há nenhum estado cadastrado com o código %d", estadoId));
	}

}
