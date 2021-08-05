package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajuste(Funcionario func, Desempenho desempenho) {

		BigDecimal percentual = desempenho.percetualReajuste();
		BigDecimal reajuste = func.getSalario().multiply(percentual);
		func.reajusteSalario(reajuste);
	}

}
