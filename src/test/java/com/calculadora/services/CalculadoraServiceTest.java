package com.calculadora.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.exceptions.OperationNotSupportException;

@SpringBootTest
class CalculadoraServiceTest {

	@Autowired
	CalculadoraService  calculadoraService;
	
	@Test
	void sumaEnterosTest() throws Exception {

		Double EXPECTED = (double)7;
		
		String operador = "SUMA";
		BigDecimal ope1 = new BigDecimal(3);
		BigDecimal ope2 = new BigDecimal(4);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}

	@Test
	void sumaDecimaleTest() throws Exception {

		Double EXPECTED = 7.8;
		
		String operador = "SUMA";
		BigDecimal ope1 = new BigDecimal(3.4);
		BigDecimal ope2 = new BigDecimal(4.4);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}
	
	@Test
	void restaEnterosTest() throws Exception {

		Double EXPECTED = (double)-1;
		
		String operador = "RESTA";
		BigDecimal ope1 = new BigDecimal(3);
		BigDecimal ope2 = new BigDecimal(4);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}

	
	@Test
	void restaDecimalesTest() throws Exception {

		Double EXPECTED = -1.1;
		
		String operador = "RESTA";
		BigDecimal ope1 = new BigDecimal(3.4);
		BigDecimal ope2 = new BigDecimal(4.5);
		
		Double actual 
			= calculadoraService.ejecutar(operador, ope1, ope2);
		
		assertThat(actual, is(EXPECTED));
		
	}
	

	@Test
	void operacionNoSoportadaTest() throws Exception {

		String operador = "MULTIPLICACION";
		BigDecimal ope1 = new BigDecimal(3);
		BigDecimal ope2 = new BigDecimal(4);
		
		try {
			calculadoraService.ejecutar(operador, ope1, ope2);
		} catch (Exception e) {
			assertThat(true, is(e instanceof OperationNotSupportException));
		}
		
		
	} 
}
