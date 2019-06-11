package model;
import java.util.ArrayList;

public class Reserva {
	private int idReserva;
	private String inicioOcupacao;
	private String horaEntrada;
	private String fimOcupacao;
	private String horaSaida;
	private Hospede hospede;
	private Funcionario funcionario;
	private double valorTotal;
	private double valorPago;
	private ArrayList<Quarto> quartos;

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
	
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public String getFimOcupacao() {
		return fimOcupacao;
	}
	public void setFimOcupacao(String fimOcupacao) {
		this.fimOcupacao = fimOcupacao;
	}
	
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
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
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public ArrayList<Quarto> getQuartos() {
		return quartos;
	}
	public void setQuartos(ArrayList<Quarto> quartos) {
		this.quartos = quartos;
	}
}
