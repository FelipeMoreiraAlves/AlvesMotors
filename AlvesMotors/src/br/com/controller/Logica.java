package br.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	/**
	 * Executa a lógica necessária de acordo com o parametro acao
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return A página para qual o request dispatch será realizado
	 */
	String executa(HttpServletRequest request, HttpServletResponse response);
}
