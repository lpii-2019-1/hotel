package model;

public class Quarto {
	int idQuarto;
	int numeroQuarto;
	String descricao;
	double valor;
	OcupacaoQuarto ocupacaoQuarto;
	

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

	public OcupacaoQuarto getOcupacaoQuarto() {
		return ocupacaoQuarto;
	}
	public void setOcupacaoQuarto(OcupacaoQuarto ocupacaoQuarto) {
		this.ocupacaoQuarto = ocupacaoQuarto;
	}
}
