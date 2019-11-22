package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> listar() {
		return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}

	@Override
	public Restaurante buscar(Long id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	public void deletar(Long id) {
		Restaurante restaurante = buscar(id);
		
		if(restaurante == null) {
			throw new EmptyResultDataAccessException(1);
		}
		entityManager.remove(restaurante);

	}
}
