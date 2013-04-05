package br.com.airu;

public class Pedido {

	private final Produto produto;
	private final int quantidade;

	public Pedido(final Produto produto, final int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
