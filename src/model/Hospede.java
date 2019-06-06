package model;

public class Hospede extends Pessoa {
	private int idHospede;
	private String dataCadastro;
	
	public int getIdHospede() {
		return idHospede;
	}
	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
