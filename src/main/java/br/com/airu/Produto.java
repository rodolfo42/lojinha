package br.com.airu;

public class Produto {

	public static final int COMUM = 0;
	public static final int MANUFATURADO = 1;
	public static final int IMPORTADO = 2;
	public static final int PERECIVEL = 3;

	private final String titulo;
	private final float preco;
	private final int tipo;

	public Produto(final String titulo, final float preco, final int tipo) {
		this.titulo = titulo;
		this.preco = preco;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public float getPreco() {
		return preco;
	}

	public int getTipo() {
		return tipo;
	}

	// Importante: implementar o hashCode() para usar Produto com key do Hashtable do Pedido
	@Override
	public int hashCode() {
		// coloquei somente o
		return titulo.hashCode();
	}

	// Importante: implementar equals() para Hashtable
	// usei somente o titulo para identificar o produto como único, pois não há um ID
	
	// Fiquei em dúvida em implementar um campo único ID, UPC ou algo do tipo
	// para não alterar demais o que já está feito
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Produto))
			return false;
		
		// podemos dar cast pois sabemos que é um Produto
		Produto p = (Produto) obj;
		
		// caso o titulo seja null
		if(titulo == null) {
			// e o do outro não for, não é
			if(p.titulo != null) {
				return false;
			}
		// e se hover titulo mas não for igual, não é
		} else if (!titulo.equals(p.titulo)) {
			return false;
		}
		
		// se for igual, é
		return true;
	}

	// não adicionei setters pois não vi necessidade deste desafio em particular
	// retirei o setTipo pelo mesmo motivo
	// e Produto se tornou imutável, bom para concorrência
}
