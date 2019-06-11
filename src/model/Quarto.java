package model;

import java.util.ArrayList;

public class Quarto {
	int idQuarto;
	int numeroQuarto;
	String descricao;
	double valor;
	int ocupacaoQuarto;
	private ArrayList<Reserva> reservas;

	public int getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getOcupacaoQuarto() {
		return ocupacaoQuarto;
	}
	public void setOcupacaoQuarto(int ocupacaoQuarto) {
		this.ocupacaoQuarto = ocupacaoQuarto;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
}
