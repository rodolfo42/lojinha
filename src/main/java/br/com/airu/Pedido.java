package br.com.airu;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Ao re-organizar o código, esta classe agora representa o carrinho todo.
 * As classes Cliente e Produto estão mais coesas e existem bem menos dependências.
 */
public class Pedido {

	/**
	 * Contém os produtos, junto com a quantidade correspondente.
	 * 
	 * Produtos são as chaves, quantidades são os valores.
	 */
	private final Hashtable<Produto, Integer> produtos;
	// foi usado Hashtable pois este nao permite null em chaves e nem em valores

	/**
	 * Representa o cliente do pedido
	 */
	private final Cliente cliente;

	/**
	 * Representa o cupom de desconto do pedido (opcional)
	 */
	private Cupom cupom = null;

	/**
	 * Construtor padrão
	 * 
	 * @param cliente Cliente do pedido
	 */
	public Pedido(final Cliente cliente) {
		this.cliente = cliente;
		this.produtos = new Hashtable<Produto, Integer>();
	}

	public Hashtable<Produto, Integer> getProdutos() {
		return this.produtos;
	}
	
	
	/**
	 * Adiciona um produto no carrinho com apenas uma unidade.
	 * 
	 * Caso o produto ja exista no carrinho, incrementa sua quantidade.
	 * 
	 * @param produto
	 */
	public void addProduto(Produto produto) {
		addProduto(produto, 1);
	}
	
	
	/**
	 * Adiciona um produto no carrinho com a quantidade especificada.
	 * 
	 * Caso o produto ja exista no carrinho, incrementa sua quantidade.
	 * 
	 * @param produto o Produto
	 */
	public void addProduto(Produto produto, int quantidade) {
		if(quantidade <= 0) {
			// usei uma unchecked exception para evitar complexidade
			throw new IllegalArgumentException("Quantidade precisa ser maior que zero!");
		}
		
		// incrementa a qtde atual caso exista
		if(produtos.containsKey(produto)) {
			quantidade += produtos.get(produto);
		}
		
		produtos.put(produto, quantidade);
	}
	
	/**
	 * Adiciona um cupom de desconto ao pedido
	 * 
	 * @param cupom
	 */
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	/**
	 * Finaliza a compra
	 * 
	 * @return Resumo da compra
	 */
	public String checkout() {
		// precos precisam ser float para suportarem centavos
		// o ideal mesmo seria BigDecimal, mas nao implementei para evitar complexidade
		float total = 0;
		int prazo = 0;
		float frete = 0;
		// agora o Cliente é um atributo de Pedido
		String result = "Pedido para " + cliente.getNome() + "\n";

		// variáveis usadas na iteração das linhas do pedido
		Produto produto = null;
		int quantidade = 0;

		// itera pelas linhas (pares de produto-quantidade)
		Iterator<Entry<Produto, Integer>> it = this.produtos.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Produto, Integer> linha = it.next();
			quantidade = linha.getValue();
			// prevenção contra quantidades zeradas ou negativas
			if (quantidade <= 0) {
				continue;
			} else {
				produto = linha.getKey();
				switch (produto.getTipo()) {
					case Produto.COMUM:
						total += produto.getPreco() * quantidade;
						prazo = prazo < 3 ? 3 : prazo;
						frete += 10 * quantidade;
						break;
					case Produto.MANUFATURADO:
						total += produto.getPreco() * quantidade;
						prazo = prazo < 5 ? 5 : prazo;
						frete += 10;
						break;
					case Produto.IMPORTADO:
						total += produto.getPreco() * quantidade * 1.5;
						prazo = prazo < 15 ? 15 : prazo;
						frete += 20;
						break;
					// novo tipo de produto
					// poderia aplicar DRY, mas mantive assim para brevidade
					case Produto.PERECIVEL:
						total += produto.getPreco() * quantidade;
						prazo = prazo < 3 ? 3 : prazo;
						frete += (10 * 10); // mantive conta para legibilidade
						break;
				}
			}
		}
		
		result += "Valor total: " + String.format("%.2f", total) + "\n";
		result += "Valor frete: " + String.format("%.2f", frete) + "\n";
		result += "Prazo de entrega: " + prazo + " dias\n";
		
		if(cupom != null) {
			// verifica o valor minimo contra o total da compra
			if(cupom.permiteUtilizacao(total)) {
				result += "Desconto: " + String.format("%.2f", cupom.getDesconto()) + "\n";
				
				// fiquei em duvida se deveria aplicar o desconto ja no valor total
				// então coloquei mais uma linha informando o valor final (com desconto)
				result += "Valor final: " + String.format("%.2f", total - cupom.getDesconto()) + "\n";
			}
		}
		
		return result;
	}
}
