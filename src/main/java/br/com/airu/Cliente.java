package br.com.airu;

public class Cliente {

	private final String nome;

	public Cliente(final String nome) {
		this.nome = nome;
	}

	// getNome ao inves de getName
	// simplesmente padronizacao
	public String getNome() {
		return nome;
	}
	
	// movida toda a logica de pedidos para Pedido
	// para diminuir o acoplamento, classe Cliente nao conhece Pedido
	// somente Pedido conhece Cliente
}
