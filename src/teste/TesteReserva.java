package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.HospedeDAO;
import model.Hospede;

import dao.FuncionarioDAO;
import model.Funcionario;

import dao.ReservaDAO;
import model.Reserva;

import dao.QuartoDAO;
import model.Quarto;


public class TesteReserva {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		ReservaDAO reservaDAO = new ReservaDAO();
		HospedeDAO hospedeDAO = new HospedeDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		QuartoDAO quartoDAO = new QuartoDAO();
		System.out.println("QUARTOS DISPONIVEIS\n");
		ArrayList<Quarto> quarto = quartoDAO.pesquisaOcupacaoQuarto(0);	
		for (Quarto q: quarto) {
			System.out.println("Numero: " +q.getNumeroQuarto());
	        System.out.println("Descricao: " +q.getDescricao());
	        System.out.println("Valor da diaria: " +q.getValor());
	        System.out.println("********************************");
	    }
		System.out.println("RESERVAS");
		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Nova Reserva");
		System.out.println("2 - Buscar Reserva");
		System.out.println("3 - Editar Reserva");
		System.out.println("4 - Excluir Reserva");
		System.out.println("5 - Listar todos as Reservas");
		int opcao = s1.nextInt();
		s1.nextLine();

		if(opcao == 1) {
			Hospede h1 = new Hospede();
			System.out.println("Nome Hospede");
			String nomeHospede = s1.nextLine();
			h1.setNome(nomeHospede);
			System.out.println("Cpf Hospede");
			String cpfHospede = s1.nextLine();
			h1.setCpf(cpfHospede);
			
			Funcionario f1 = new Funcionario();
			System.out.println("Nome Funcionario");
			String nomeFuncionario = s1.nextLine();
			f1.setNome(nomeFuncionario);

			Reserva r1 = new Reserva();
			System.out.println("Data de Inicio de Ocupacao: ");
			r1.setInicioOcupacao(s1.nextLine());
			System.out.println("Data de Fim de Ocupacao: ");
			r1.setFimOcupacao(s1.nextLine());
			
			if (hospedeDAO.pesquisaCpfHospede(h1.getCpf()).getIdHospede()== 0) {
				 hospedeDAO.inserir(h1);
	         }
			h1 = hospedeDAO.pesquisaCpfHospede(h1.getCpf());
			r1.setHospede(h1);
			if (funcionarioDAO.pesquisaNomeFuncionario(f1.getNome()).getIdFuncionario()== 0) {
				 funcionarioDAO.inserir(f1);
	        }
			f1 = funcionarioDAO.pesquisaNomeFuncionario(f1.getNome());
			r1.setFuncionario(f1);

			System.out.println("Valor Total da Reserva: ");
			r1.setValorTotal(s1.nextDouble());
			s1.nextLine();
			System.out.println("Valor Pago: ");
			r1.setValorPago(s1.nextDouble());
			s1.nextLine();
			
			reservaDAO.inserir(r1);
			System.out.println("FIM");
		}
	}
}
