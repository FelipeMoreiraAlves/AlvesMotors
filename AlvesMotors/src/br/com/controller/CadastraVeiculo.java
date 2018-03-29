package br.com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Veiculo;
import br.com.bo.AnoMaiorQueAnoCorrenteException;
import br.com.bo.VeiculoBo;

public class CadastraVeiculo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();
		
		String modelo = request.getParameter("modelo");
		String placa = request.getParameter("placa");
		String ano = request.getParameter("ano");
		String motor = request.getParameter("motor");

		if (modelo.trim().length() == 0 || placa.trim().length() == 0 || ano.trim().length() == 0
				|| motor.trim().length() == 0 || "0.0".equals(motor)) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "É necessário preencher todos os campos!");
			return "cadastra.jsp";
		}
		
		else if ((placa.trim().length() > 0 )&& (placa.trim().length() < 8)) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "Placa inválida. Deve ser preenchida corretamente!");
			return "cadastra.jsp";
		}
		
		else {
			Veiculo veiculo = new Veiculo();
			
			veiculo.setModelo(modelo);
			veiculo.setPlaca(placa);
			veiculo.setAno(ano);
			veiculo.setMotor(Double.parseDouble(motor));
			
			try {
				bo.adiciona(veiculo);
				request.setAttribute("mensagemStatus", MensagemStatus.SUCESSO);
				request.setAttribute("mensagem", "O veículo " + veiculo.getModelo() + " foi cadastrado com sucesso!");
				return "sistema?acao=ListaVeiculos";
			} catch (AnoMaiorQueAnoCorrenteException e) {
				request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
				request.setAttribute("mensagem", e.getMessage());
				return "cadastra.jsp";
			} catch (SQLException e) {
				request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
				request.setAttribute("mensagem", "Ocorreu um erro ao tentar cadastrar o veículo.");
				
				System.err.println(e.getMessage());
				e.printStackTrace();
				
				return "cadastra.jsp";
			}
		}
	}

}
