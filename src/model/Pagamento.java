package model;

public class Pagamento {
	private int idPagamento;
	private double valorTotal;
	private double valorPago;
	private ReservaQuarto reservaQuarto;
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
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
	public ReservaQuarto getReservaQuarto() {
		return reservaQuarto;
	}
	public void setReservaQuarto(ReservaQuarto reservaQuarto) {
		this.reservaQuarto = reservaQuarto;
	}
}