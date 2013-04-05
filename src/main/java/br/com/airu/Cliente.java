package br.com.airu;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private final String nome;
	private final List<Pedido> pedidos = new ArrayList<Pedido>();

	public Cliente(final String nome) {
		this.nome = nome;
	}

	public void addPedido(final Pedido pedido) {
		pedidos.add(pedido);
	}

	public String getName() {
		return nome;
	}

	public String checkout() {
		int total = 0;
		int prazo = 0;
		int frete = 0;
		String result = "Pedido para " + getName() + "\n";
		for (final Pedido pedido : pedidos) {
			switch (pedido.getProduto().getTipo()) {
			case Produto.COMUM:
				total += pedido.getProduto().getPreco() * pedido.getQuantidade();
				prazo = prazo < 3 ? 3 : prazo;
				frete += 10;
				break;
			case Produto.MANUFATURADO:
				total += pedido.getProduto().getPreco() * pedido.getQuantidade();
				prazo = prazo < 5 ? 5 : prazo;
				frete += 10;
				break;
			case Produto.IMPORTADO:
				total += pedido.getProduto().getPreco() * pedido.getQuantidade() * 1.5;
				prazo = prazo < 15 ? 15 : prazo;
				frete += 20;
				break;
			}
		}
		result += "Valor total: " + total + "\n";
		result += "Valor frete: " + frete + "\n";
		result += "Prazo de entrega: " + prazo + " dias\n";
		return result;
	}
	
}
