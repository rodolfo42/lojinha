package br.com.airu;

/**
 * Representa o cupom de desconto mencionado no enunciado
 */
public class Cupom {
	
	private final String codigo;
	
	private final float desconto;
	
	private final float valorMinimo;

	/**
	 * Construtor padrão.
	 * 
	 * @param codigo
	 * @param desconto
	 * @param valorMinimo
	 */
	public Cupom(final String codigo, final float desconto, final float valorMinimo) {
		this.codigo = codigo;
		this.desconto = desconto;
		this.valorMinimo = valorMinimo;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getDesconto() {
		return desconto;
	}
	
	/**
	 * Verifica se o cupom pode ser utilizado, dado o valor da compra.
	 * 
	 * @param total
	 * @return
	 */
	public boolean permiteUtilizacao(float total) {
		return valorMinimo <= total;
	}
}
