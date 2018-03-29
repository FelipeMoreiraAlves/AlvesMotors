package br.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	/**
	 * Executa a l�gica necess�ria de acordo com o parametro acao
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return A p�gina para qual o request dispatch ser� realizado
	 */
	String executa(HttpServletRequest request, HttpServletResponse response);
}
