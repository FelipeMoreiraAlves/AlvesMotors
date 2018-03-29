package br.com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.VeiculoBo;

public class ListaVeiculos implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();

		try {
			request.setAttribute("veiculos", bo.getLista());
		} catch (SQLException e) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "Ocorreu um erro ao tentar retornar a lista de veículos");
			
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return "/WEB-INF/jsp/lista.jsp";
	}

}
