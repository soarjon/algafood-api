package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
<<<<<<< HEAD
	
	List<Restaurante> findComFreteGratis(String nome);
=======
>>>>>>> e03505b7859d303ce221fe3c0a7964b4d612366e

}