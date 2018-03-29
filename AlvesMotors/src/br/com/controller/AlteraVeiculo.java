package br.com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Veiculo;
import br.com.bo.VeiculoBo;

public class AlteraVeiculo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();

		int id = Integer.parseInt(request.getParameter("id_veiculo"));
		String placa = request.getParameter("placa");

		if (placa.trim().length() == 0) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "É necessário preencher a nova placa!");
			return "sistema?acao=EditaVeiculo&id=" + id;
			
		} else if ((placa.trim().length() > 0) && (placa.trim().length() < 8)) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "Placa inválida. Deve ser preenchida corretamente!");
			return "sistema?acao=EditaVeiculo&id=" + id;
			
		} else {
			Veiculo veiculo = new Veiculo();

			veiculo.setId(id);
			veiculo.setPlaca(placa);

			try {
				bo.altera(veiculo);
				request.setAttribute("mensagemStatus", MensagemStatus.SUCESSO);
				request.setAttribute("mensagem",
						"O veículo " + request.getParameter("modelo") + " foi alterado com sucesso!");
				return "sistema?acao=ListaVeiculos";
			} catch (SQLException e) {
				request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
				request.setAttribute("mensagem", "Ocorreu um erro ao tentar alterar o veículo.");

				System.err.println(e.getMessage());
				e.printStackTrace();

				return "sistema?acao=EditaVeiculo&id=" + request.getParameter("id_veiculo");
			}
		}

	}

}
