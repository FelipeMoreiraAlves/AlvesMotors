package br.com.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.bean.Veiculo;

public interface VeiculoDao {
	/**
	* Insere um veículo no banco de dados.
	* @param veiculo O objeto do veículo a ser inserido
	* @throws SQLException
	*/
	public void adiciona(Veiculo veiculo) throws SQLException;
	
	/**
	* Retorna lista de veículos.
	* @return A lista de veículos
	* @throws SQLException
	*/
	public List<Veiculo> getLista() throws SQLException;
	
	/**
	* Retorna lista de veículos por ano.
	* @param ano O ano que será ultilizado para filtrar os veículos
	* @return A lista de veículos filtrada por ano
	* @throws SQLException
	*/
	public List<Veiculo> getListaPorAno(int ano) throws SQLException;
	
	/**
	* Retorna um veículo específico.
	* @param id_veiculo O atributo referente a chave primária do veículo
	* @return O veículo
	* @throws SQLException
	*/
	public Veiculo getVeiculo(int id_veiculo) throws SQLException;
	
	/**
	* Atera um veículo específico.
	* @param veiculo O veículo com os atributos atualizados
	* @throws SQLException
	*/
	public void altera(Veiculo veiculo) throws SQLException;
	
	/**
	* Remove um veículo específico.
	* @param veiculo O veículo a ser removido
	* @throws SQLException
	*/
	public void remove(Veiculo veiculo) throws SQLException;
	
	
}
