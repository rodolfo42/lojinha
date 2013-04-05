package br.com.airu;

public class Produto {

	public static final int COMUM = 0;
	public static final int MANUFATURADO = 1;
	public static final int IMPORTADO = 2;
	
	private final String titulo;
	private final int preco;
	private int tipo;
	
	public Produto(final String titulo, final int preco, final int tipo) {
		this.titulo = titulo;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getPreco() {
		return preco;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(final int tipo) {
		this.tipo = tipo;
	}

}
