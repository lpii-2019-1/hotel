package model;

public class Reserva {
	private int idReserva;
	private String inicioOcupacao;
	private String fimOcupacao;
	private Hospede hospede;
	private Funcionario funcionario;

	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public String getInicioOcupacao() {
		return inicioOcupacao;
	}
	public void setInicioOcupacao(String inicioOcupacao) {
		this.inicioOcupacao = inicioOcupacao;
	}
	
	public String getFimOcupacao() {
		return fimOcupacao;
	}
	public void setFimOcupacao(String fimOcupacao) {
		this.fimOcupacao = fimOcupacao;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
