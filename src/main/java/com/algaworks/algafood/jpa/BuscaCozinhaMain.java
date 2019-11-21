package com.algaworks.algafood.jpa;

import java.util.Objects;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		Cozinha cozinha = cadastroCozinha.buscar(6L);
		if(!Objects.isNull(cozinha)) {
			System.out.println(cozinha.getNome());
		} else {
			System.out.println("Cozinha não encontrada!");
		}
		
				
	}
}
