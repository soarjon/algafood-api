package com.algaworks.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "grupo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "grupo_permissao", 
		joinColumns = @JoinColumn(name = "grupo_id"), 
		inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes = new ArrayList<>();

}
