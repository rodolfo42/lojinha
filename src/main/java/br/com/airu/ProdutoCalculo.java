package br.com.airu;

public enum ProdutoCalculo {

	COMUM(0), MANUFATURADO(1), IMPORTADO(2), PERECIVEL(3);

	private final int tipo;

	private ProdutoCalculo(int tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Calcula o preço do produto de acordo com este tipo de cálculo e com o preço do produto informado.
	 * 
	 * @param preco Preço do produto
	 * @return preço
	 */
	public float calcularPreco(float preco) {
		switch (this.tipo) {
		case 0:
		case 1:
		case 3:
			// preco normal
			break;
		case 2: // somente importados
				// acrescentar metade do preco
			preco *= 1.5;
			break;
		}

		return preco;
	}

	/**
	 * Calcula o prazo de entrega de acordo com este tipo de cálculo.
	 * 
	 * @return prazo
	 */
	public int calcularPrazo() {
		int prazo = 0;
		switch (this.tipo) {
		case 0:
		case 3:
			prazo = 3;
			break;
		case 1:
			prazo = 5;
			break;
		case 2:
			prazo = 15;
			break;
		}

		return prazo;
	}

	/**
	 * Calcula o frete de acordo com este tipo de cálculo.
	 * 
	 * @return frete
	 */
	public float calcularFrete() {
		float frete = 0;
		switch (this.tipo) {
		case 0:
		case 1:
			frete = 10.0f;
			break;
		case 2:
			frete = 20.0f;
			break;
		case 3:
			frete = 100.0f;
			break;
		}

		return frete;
	}

}
