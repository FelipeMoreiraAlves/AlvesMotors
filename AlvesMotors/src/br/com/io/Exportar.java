package br.com.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Veiculo;
import br.com.bo.VeiculoBo;

public class Exportar {

	public String fileSrc = "D:/veiculos2017.csv";
	public ArrayList<Veiculo> exportar(ArrayList<Veiculo> veiculos) throws IOException, SQLException {
	//	VeiculoBo bo = new VeiculoBo();
		//ArrayList<Veiculo> veiculos = bo.getListaPorAno(2017);
		

		if (veiculos.size() > 0) {
			this.fileSrc = fileSrc;
			FileWriter outputStream = new FileWriter(fileSrc);
			PrintWriter arquivoSaida = new PrintWriter(outputStream);

			arquivoSaida.println("ANO,PLACA,MODELO,MOTOR");
			for (Veiculo veiculo : veiculos) {
				arquivoSaida.println(veiculo.getAno() + "," + veiculo.getPlaca() + "," + veiculo.getModelo() + ","
						+ veiculo.getMotor());
			}

			arquivoSaida.close();
			outputStream.close();

		}
		return veiculos;
	}
}
