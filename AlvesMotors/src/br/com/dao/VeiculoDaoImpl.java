package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bean.Veiculo;
import br.com.jdbc.ConnectionFactory;

public class VeiculoDaoImpl implements VeiculoDao {

	private Connection conn;

	public VeiculoDaoImpl() throws SQLException {
		this.conn = new ConnectionFactory().getConnection();
	}

	@Override
	public void adiciona(Veiculo veiculo) throws SQLException {
		String sql = "insert into TB_VEICULOS (id_veiculo, modelo, placa, ano, motor)"
				+ " values (SQ_VEICULO.nextval, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, veiculo.getModelo().substring(0, 1).toUpperCase().concat(veiculo.getModelo().substring(1)));
		stmt.setString(2, veiculo.getPlaca().toUpperCase());
		stmt.setString(3, veiculo.getAno());
		stmt.setDouble(4, veiculo.getMotor());
		stmt.executeUpdate();
		conn.close();
	}

	@Override
	public ArrayList<Veiculo> getLista() throws SQLException {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		String sql = "select * from TB_VEICULOS order by modelo";

		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setId(rs.getInt("id_veiculo"));
			v.setModelo(rs.getString("modelo"));
			v.setPlaca(rs.getString("placa"));
			v.setAno(rs.getString("ano"));
			v.setMotor(rs.getDouble("motor"));

			veiculos.add(v);
		}

		conn.close();
		return veiculos;
	}
	
	@Override
	public ArrayList<Veiculo> getListaPorAno(int ano) throws SQLException {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		String sql = "select * from TB_VEICULOS where ano=? order by modelo";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, Integer.toString(ano));
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setId(rs.getInt("id_veiculo"));
			v.setModelo(rs.getString("modelo"));
			v.setPlaca(rs.getString("placa"));
			v.setAno(rs.getString("ano"));
			v.setMotor(rs.getDouble("motor"));

			veiculos.add(v);
		}

		conn.close();
		return veiculos;
	}

	@Override
	public Veiculo getVeiculo(int id_veiculo) throws SQLException {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		String sql = "Select * from TB_VEICULOS where id_veiculo=? order by modelo";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id_veiculo);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setId(rs.getInt("id_veiculo"));
			v.setModelo(rs.getString("modelo"));
			v.setPlaca(rs.getString("placa"));
			v.setAno(rs.getString("ano"));
			v.setMotor(rs.getDouble("motor"));

			veiculos.add(v);
		}

		conn.close();
		if (veiculos.size() > 0) {
			return veiculos.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void altera(Veiculo veiculo) throws SQLException {
		String sql = "update TB_VEICULOS set placa=? where id_veiculo=?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, veiculo.getPlaca().toUpperCase());
		stmt.setInt(2, veiculo.getId());
		stmt.executeUpdate();
		conn.close();
	}

	@Override
	public void remove(Veiculo veiculo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("delete from TB_VEICULOS where id_veiculo=?");
		stmt.setInt(1, veiculo.getId());
		stmt.executeUpdate();
		conn.close();
	}

}
