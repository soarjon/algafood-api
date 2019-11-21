package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;

public class ConsultaFormaDePagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaDePagamentoRepository formaDePagamentoRepository = applicationContext.getBean(FormaDePagamentoRepository.class);
		List<FormaDePagamento> formasDePagamento = formaDePagamentoRepository.listar();	
		
		System.out.println("Nosso restaurante possui as seguintes formas de pagamento: ");
		for (FormaDePagamento formaDePagamento : formasDePagamento) {
			System.out.println(formaDePagamento.getDescricao());
		}
	}
}
