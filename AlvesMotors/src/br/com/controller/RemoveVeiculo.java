package br.com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Veiculo;
import br.com.bo.VeiculoBo;

public class RemoveVeiculo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(Integer.parseInt(request.getParameter("id")));
		
		try { 
			bo.remove(veiculo);
			request.setAttribute("mensagem", "Veículo removido com sucesso!");
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Ocorreu um erro ao tentar remover o veículo.");
		}
		
		return "sistema?acao=ListaVeiculos";
	}

}
