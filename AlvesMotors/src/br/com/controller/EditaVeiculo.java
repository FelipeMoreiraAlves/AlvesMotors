package br.com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Veiculo;
import br.com.bo.VeiculoBo;

public class EditaVeiculo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();
		
		try {
			Veiculo veiculo = bo.getVeiculo(Integer.parseInt(request.getParameter("id")));
			if (veiculo != null) {
				request.setAttribute("veiculo", veiculo);
				return "WEB-INF/jsp/edita.jsp";
			} else {
				request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
				request.setAttribute("mensagem", "Veículo não existe.");
				return "sistema?acao=ListaVeiculos";
			}
		} catch (SQLException e) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "Ocorreu um erro ao tentar recuperar o veículo.");
			
			System.err.println(e.getMessage());
			e.printStackTrace();
			
			return "sistema?acao=ListaVeiculos";
		}
	}

}
