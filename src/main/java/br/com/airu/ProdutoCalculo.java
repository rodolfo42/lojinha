package br.com.airu;

public enum ProdutoCalculo {

	COMUM(0), MANUFATURADO(1), IMPORTADO(2), PERECIVEL(3);

	private final int tipo;

	private ProdutoCalculo(int tipo) {
		this.tipo = tipo;
	}

	public float calcularPreco(float preco) {
		switch (this.tipo) {
		case 0:
		case 1:
		case 3:
			// preco normal
			break;
		case 2: // importados
				// acrescenta metade do preco
			preco *= 1.5;
			break;
		}

		return preco;
	}

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
