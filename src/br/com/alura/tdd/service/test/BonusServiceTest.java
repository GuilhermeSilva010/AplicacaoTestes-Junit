package br.com.alura.tdd.service.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

class BonusServiceTest {

	private Funcionario func;
	private BonusService service;

	@BeforeEach
	public void criarObjetos() {
		System.out.println("(BeforeEach) - executa a cada começo de um metodo de test");
		service = new BonusService();
	}
	
	@AfterEach
	public void depoisDoMetodo() {
		System.out.println("(AfterEach) - executa a cada final de um metodo de test");
	}
	
	@BeforeAll
	public static void primeiro() {
		System.out.println("(BeforeAll) - O Primeiro metodo a ser executado e executa apenas uma vez");
	}
	
	@AfterAll
	public static void ultimo() {
		System.out.println("(AfterAll) - O Ultimo metodo a ser executado e executa apenas uma vez");

	}

	@Test
	void test() {
		func = new Funcionario("Gui", LocalDate.now(), new BigDecimal("25000"));
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(func));
		
		// Segunda forma de tratar erros em testes
//		try {
//			service.calcularBonus(func);
//			fail("Não ocorreu erro");
//		} catch (Exception e) {
//			assertEquals("Salário do funcionário é maior que R$10.000 e não pode receber bonus!", e.getMessage());
//		}
		
	}

	@Test
	void test2() {
		func = new Funcionario("Gui", LocalDate.now(), new BigDecimal("2500"));
		BigDecimal calcularBonus = service.calcularBonus(func);
		assertEquals(new BigDecimal("250.00"), calcularBonus);

	}

	@Test
	void test3() {
		func = new Funcionario("Gui", LocalDate.now(), new BigDecimal("10000"));
		BigDecimal calcularBonus = service.calcularBonus(func);
		assertEquals(new BigDecimal("1000.00"), calcularBonus);

	}

}
