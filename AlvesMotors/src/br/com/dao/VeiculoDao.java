package br.com.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.bean.Veiculo;

public interface VeiculoDao {
	/**
	* Insere um ve�culo no banco de dados.
	* @param veiculo O objeto do ve�culo a ser inserido
	* @throws SQLException
	*/
	public void adiciona(Veiculo veiculo) throws SQLException;
	
	/**
	* Retorna lista de ve�culos.
	* @return A lista de ve�culos
	* @throws SQLException
	*/
	public List<Veiculo> getLista() throws SQLException;
	
	/**
	* Retorna lista de ve�culos por ano.
	* @param ano O ano que ser� ultilizado para filtrar os ve�culos
	* @return A lista de ve�culos filtrada por ano
	* @throws SQLException
	*/
	public List<Veiculo> getListaPorAno(int ano) throws SQLException;
	
	/**
	* Retorna um ve�culo espec�fico.
	* @param id_veiculo O atributo referente a chave prim�ria do ve�culo
	* @return O ve�culo
	* @throws SQLException
	*/
	public Veiculo getVeiculo(int id_veiculo) throws SQLException;
	
	/**
	* Atera um ve�culo espec�fico.
	* @param veiculo O ve�culo com os atributos atualizados
	* @throws SQLException
	*/
	public void altera(Veiculo veiculo) throws SQLException;
	
	/**
	* Remove um ve�culo espec�fico.
	* @param veiculo O ve�culo a ser removido
	* @throws SQLException
	*/
	public void remove(Veiculo veiculo) throws SQLException;
	
	
}
