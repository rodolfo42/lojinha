package br.com.airu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void testCheckoutSimples() {
		Cliente yokomizor = new Cliente("Rogério");
		Produto xbox = new Produto("xbox", 1.00f, ProdutoCalculo.COMUM);
		Pedido pedido = new Pedido(yokomizor);
		pedido.addProduto(xbox);
		assertEquals("Pedido para Rogério\n" +
				 "Valor total: 1.00\n" +
				 "Valor frete: 10.00\n" +
				 "Prazo de entrega: 3 dias\n", pedido.checkout());
	}

	@Test
	public void testCheckoutQuantidades() {
		Cliente emiguelt = new Cliente("Edwin");
		
		Produto caixa = new Produto("caixa de milho", 10.00f, ProdutoCalculo.COMUM);
		Produto boneca = new Produto("boneca", 39.99f, ProdutoCalculo.MANUFATURADO);
		Produto relogio = new Produto("relógio", 45.50f, ProdutoCalculo.IMPORTADO);
		Produto presunto = new Produto("presunto", 4.57f, ProdutoCalculo.PERECIVEL);
		
		Pedido pedido = new Pedido(emiguelt);
		pedido.addProduto(caixa);
		pedido.addProduto(boneca);
		pedido.addProduto(boneca); // deve adicionar duas bonecas
		pedido.addProduto(relogio, 2);
		pedido.addProduto(presunto, 4);
		
		assertEquals("Pedido para Edwin\n" +
					 "Valor total: 244.76\n" +
					 "Valor frete: 140.00\n" +
					 "Prazo de entrega: 15 dias\n", pedido.checkout());
	}

	
	@Test
	public void testCheckoutCupomOk() {
		Cliente yokomizor = new Cliente("Rogério");
		Produto xbox = new Produto("xbox", 360.00f, ProdutoCalculo.COMUM);
		Pedido pedido = new Pedido(yokomizor);
		pedido.addProduto(xbox);
		
		Cupom cupom = new Cupom("XBOX360", 60.00f, 360.00f);
		pedido.setCupom(cupom);
		
		assertEquals("Pedido para Rogério\n" +
				 "Valor total: 360.00\n" +
				 "Valor frete: 10.00\n" +
				 "Prazo de entrega: 3 dias\n" +
				 "Desconto: 60.00\n" +
				 "Valor final: 300.00\n", pedido.checkout());
	}
	
	@Test
	public void testCheckoutCupomNaoPermitido() {
		Cliente emiguelt = new Cliente("Edwin");
		
		Produto caixa = new Produto("caixa de milho", 10.00f, ProdutoCalculo.COMUM);
		Produto boneca = new Produto("boneca", 39.99f, ProdutoCalculo.MANUFATURADO);
		Produto relogio = new Produto("relógio", 45.50f, ProdutoCalculo.IMPORTADO);
		Produto presunto = new Produto("presunto", 4.57f, ProdutoCalculo.PERECIVEL);
		
		Pedido pedido = new Pedido(emiguelt);
		pedido.addProduto(caixa);
		pedido.addProduto(boneca);
		pedido.addProduto(boneca); // deve adicionar duas bonecas
		pedido.addProduto(relogio, 2);
		pedido.addProduto(presunto, 4);
		
		// nao podera ter o desconto por causa do valor minimo
		Cupom cupom = new Cupom("PRESUNTADA", 44.76f, 400.00f);
		pedido.setCupom(cupom);
		
		
		assertEquals("Pedido para Edwin\n" +
					 "Valor total: 244.76\n" +
					 "Valor frete: 140.00\n" +
					 "Prazo de entrega: 15 dias\n", pedido.checkout());
	}
}
