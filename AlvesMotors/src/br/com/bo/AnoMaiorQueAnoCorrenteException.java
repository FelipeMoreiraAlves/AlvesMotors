package br.com.bo;

public class AnoMaiorQueAnoCorrenteException extends Exception {

	public AnoMaiorQueAnoCorrenteException() {
		super("O ano de fabrica��o do ve�culo n�o pode ser maior que o ano corrente.");
	}

}
