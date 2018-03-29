package br.com.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.bean.Veiculo;
import br.com.dao.VeiculoDaoImpl;
import br.com.io.Exportar;

public class VeiculoBo {
	public void adiciona(Veiculo veiculo) throws AnoMaiorQueAnoCorrenteException, SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();

		int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);

		if (Integer.parseInt(veiculo.getAno()) > anoCorrente) {
			throw new AnoMaiorQueAnoCorrenteException();
		}

		dao.adiciona(veiculo);
	}

	public ArrayList<Veiculo> getLista() throws SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();

		return dao.getLista();
	}
	
	public ArrayList<Veiculo> getListaPorAno(int ano) throws SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();

		return dao.getListaPorAno(ano);
	}
	
	public Veiculo getVeiculo(int id_veiculo) throws SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();
		
		return dao.getVeiculo(id_veiculo);
	}
	
	public void altera(Veiculo veiculo) throws SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();
		
		dao.altera(veiculo);
	}
	
	public void remove(Veiculo veiculo) throws SQLException {
		VeiculoDaoImpl dao = new VeiculoDaoImpl();
		
		dao.remove(veiculo);
	}
	public ArrayList<Veiculo> exportarArquivo() throws SQLException, IOException{
		Exportar ep = new Exportar();
		
				
		return ep.exportar(getListaPorAno(2017));
	}
}
