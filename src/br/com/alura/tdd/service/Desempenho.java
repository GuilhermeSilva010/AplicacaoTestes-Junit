package br.com.alura.tdd.service;

import java.math.BigDecimal;

public enum Desempenho {
	
	RUIM {
		@Override
		public BigDecimal percetualReajuste() {
			return new BigDecimal("0.03");
		}
		
	},
	
	MEDIO{
		@Override
		public BigDecimal percetualReajuste() {
			return new BigDecimal("0.10");
		}
	},
	
	BOM{
		@Override
		public BigDecimal percetualReajuste() {
			return new BigDecimal("0.15");
		}
	},
	
	EXCELENTE{
		@Override
		public BigDecimal percetualReajuste() {
			return new BigDecimal("0.20");
		}
	};
	
	public abstract BigDecimal percetualReajuste();
	

}
