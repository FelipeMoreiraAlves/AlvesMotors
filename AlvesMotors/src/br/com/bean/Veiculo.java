package br.com.bean;

import java.io.Serializable;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String modelo;	
	private String placa;	
	private String ano;	
	private double motor;

	public int getId() {
		return id;
	}

	public void setId(int id_veiculo) {
		this.id = id_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	}
}
