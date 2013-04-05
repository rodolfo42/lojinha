package br.com.airu;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testCheckout() {
		Cliente zacarias = new Cliente("Zacarias");
		
		Produto caixa = new Produto("caixa de milho", 1000, Produto.COMUM);
		Produto boneca = new Produto("boneca", 3000, Produto.MANUFATURADO);
		Produto relogio = new Produto("relógio", 6000, Produto.IMPORTADO);
		
		Pedido pedido1 = new Pedido(caixa, 2);
		Pedido pedido2 = new Pedido(boneca, 1);
		Pedido pedido3 = new Pedido(relogio, 1);
		
		zacarias.addPedido(pedido1);
		zacarias.addPedido(pedido2);
		zacarias.addPedido(pedido3);
		
		assertEquals("Pedido para Zacarias\n" +
					 "Valor total: 14000\n" +
					 "Valor frete: 40\n" +
					 "Prazo de entrega: 15 dias\n", zacarias.checkout());
	}

}
