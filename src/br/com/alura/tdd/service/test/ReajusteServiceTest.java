package br.com.alura.tdd.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.Desempenho;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	
	private Funcionario funcionario;
	private ReajusteService service;
	
	@BeforeEach
	public void criaerObjeto(){
		funcionario = new Funcionario("Gui", LocalDate.now(),new BigDecimal("1500.00"));
		service = new ReajusteService();
	}


	@Test
	void desempenhoExcelente() {
		
		service.reajuste(funcionario, Desempenho.EXCELENTE);
		assertEquals(new BigDecimal("1800.00"), funcionario.getSalario());
		
	}
	
	@Test
	void desempenhoMedio() {
		
		service.reajuste(funcionario, Desempenho.MEDIO);
		assertEquals(new BigDecimal("1725.00"), funcionario.getSalario());
		
	}
	
	@Test
	void desempenhoBom() {
		
		service.reajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1750.00"), funcionario.getSalario());
		
	}
	
	
	@Test
	void desempenhoRuim() {
		
		service.reajuste(funcionario, Desempenho.RUIM);
		assertEquals(new BigDecimal("1545.00"), funcionario.getSalario());
		
	}

}
