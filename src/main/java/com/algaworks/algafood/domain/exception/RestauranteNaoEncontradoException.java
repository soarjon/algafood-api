package com.algaworks.algafood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public RestauranteNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public RestauranteNaoEncontradoException(Long restauranteId) {
		this(String.format("Não há nenhum restaurante cadastrada com o código %d", restauranteId));
	}

}
