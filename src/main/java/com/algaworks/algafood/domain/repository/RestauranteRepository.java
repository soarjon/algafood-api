package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> e03505b7859d303ce221fe3c0a7964b4d612366e
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
<<<<<<< HEAD
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {
=======
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
>>>>>>> e03505b7859d303ce221fe3c0a7964b4d612366e
	
	//prefixoFindBy
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
//	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	
	// prefixo findBy
//	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	//Key word chamada First, que retorna apenas uma unica entidade; Usado após o prefixo find e antes do By
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
<<<<<<< HEAD
	

=======
	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
	
	
	
>>>>>>> e03505b7859d303ce221fe3c0a7964b4d612366e
}
