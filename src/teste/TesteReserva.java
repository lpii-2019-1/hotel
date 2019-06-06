package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ReservaDAO;
import dao.HospedeDAO;
import dao.QuartoDAO;
import dao.FuncionarioDAO;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.Funcionario;

public class TesteReserva {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		QuartoDAO quartoDAO = new QuartoDAO();
		System.out.println("QUARTOS DISPONIVEIS\n");
		ArrayList<Quarto> quarto = quartoDAO.pesquisaIdOcupacaoQuarto(1);
		for (Quarto quartoPesquisado: quarto) {
			System.out.println("Numero: " +quartoPesquisado.getNumeroQuarto());
	        System.out.println("Descricao: " +quartoPesquisado.getDescricao());
	        System.out.println("Valor da diaria: " +quartoPesquisado.getValor());
	        System.out.println("********************************");
	    }
	
		ReservaDAO reservaDAO = new ReservaDAO();
		HospedeDAO hospedeDAO = new HospedeDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Hospede h1 = new Hospede();
		String nomeHospede = s1.nextLine();
		Funcionario hospedePesquisado = funcionarioDAO.pesquisaNomeFuncionario(nomeHospede);

		Funcionario f1 = new Funcionario();
		String nomeFuncionario = s1.nextLine();
		Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaNomeFuncionario(nomeFuncionario);

		Reserva r1 = new Reserva();
		r1.setInicioOcupacao("2019-05-05");
		r1.setFimOcupacao("2000-05-05");
		if (hospedeDAO.pesquisaNomeHospede(hospedePesquisado.getNome()).getIdHospede() == 0) {
			 hospedeDAO.inserir(h1);
         }
		h1 = hospedeDAO.pesquisaNomeHospede(hospedePesquisado.getNome());
		
		
		if (funcionarioDAO.pesquisaNomeFuncionario(funcionarioPesquisado.getNome()).getIdFuncionario() == 0) {
			 funcionarioDAO.inserir(f1);
        }
		f1 = funcionarioDAO.pesquisaNomeFuncionario(funcionarioPesquisado.getNome());
		
		r1.setHospede(h1);
		r1.setFuncionario(f1);
		reservaDAO.inserir(r1);
	
		System.out.println("FIM");
		}
}
