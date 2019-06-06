package model;

public class ReservaQuarto {
	private int idReservaQuarto;
	private Quarto quarto;
	private Reserva reserva;
	
	public int getIdReservaQuarto() {
		return idReservaQuarto;
	}
	public void setIdReservaQuarto(int idReservaQuarto) {
		this.idReservaQuarto = idReservaQuarto;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
