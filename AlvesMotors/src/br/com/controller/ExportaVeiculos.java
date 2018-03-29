package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.VeiculoBo;
import br.com.io.Exportar;

public class ExportaVeiculos implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		VeiculoBo bo = new VeiculoBo();
		Exportar ep = new Exportar();

		try {
			bo.exportarArquivo();

			request.setAttribute("mensagemStatus", MensagemStatus.SUCESSO);
			request.setAttribute("mensagem", "O arquivo de relatório foi salvo em: " + ep.fileSrc);
		} catch (IOException e) {
			request.setAttribute("mensagemStatus", MensagemStatus.ERRO);
			request.setAttribute("mensagem", "Ocorreu um erro ao tentar salva o arquivo de relatório.");

			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "sistema?acao=ListaVeiculos";
	}

}
