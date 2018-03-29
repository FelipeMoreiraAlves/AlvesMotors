package br.com.bo;

public class AnoMaiorQueAnoCorrenteException extends Exception {

	public AnoMaiorQueAnoCorrenteException() {
		super("O ano de fabricação do veículo não pode ser maior que o ano corrente.");
	}

}
