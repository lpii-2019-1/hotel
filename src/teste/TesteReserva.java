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
		System.out.println("2 - Encerrar Reserva");
		System.out.println("3 - Buscar Reserva");
		System.out.println("4 - Editar Reserva");
		System.out.println("5 - Excluir Reserva");
		System.out.println("6 - Listar todos as Reservas");
		int opcao = s1.nextInt();
		s1.nextLine();

		if(opcao == 1) {
			Hospede h1 = new Hospede();
			System.out.println("\nINFORME OS DADOS DO HOSPEDE");
			System.out.println("Nome do Hospede");
			String nomeHospede = s1.nextLine();
			h1.setNome(nomeHospede);
			System.out.println("Cpf do Hospede");
			String cpfHospede = s1.nextLine();
			h1.setCpf(cpfHospede);
			Hospede hospedePesquisado = hospedeDAO.pesquisaCpfHospede(cpfHospede);
	        if (hospedePesquisado.getIdHospede() != 0) {
	            System.out.println("______________________________________________");
	        	System.out.println("DADOS DO HOSPEDE");
	        	System.out.println("idHospede: " +hospedePesquisado.getIdHospede());
	            System.out.println("Nome: " +hospedePesquisado.getNome());
	            System.out.println("CPF: " +hospedePesquisado.getCpf());
	            System.out.println("Telefone: " +hospedePesquisado.getTelefone());
	            System.out.println("Endereco: " +hospedePesquisado.getEndereco());
	            System.out.println("Email: " +hospedePesquisado.getEmail());
	            System.out.println("Data de Cadastro: " +hospedePesquisado.getDataCadastro());
	            System.out.println("______________________________________________");
	        }
	        else{
				System.out.println("\n HOSPEDE NÃO ENCONTRADO \n");
	        }
			System.out.println("\nINFORME OS DADOS DO FUNCIONARIO");
			Funcionario f1 = new Funcionario();
			System.out.println("Nome do Funcionario");
			String nomeFuncionario = s1.nextLine();
			f1.setNome(nomeFuncionario);
			System.out.println("Cpf do Funcionario");
			String cpfFuncionario = s1.nextLine();
			f1.setCpf(cpfFuncionario);
			Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(cpfFuncionario);
	        if (funcionarioPesquisado.getIdFuncionario() != 0) {
	            System.out.println("______________________________________________");
	        	System.out.println("DADOS DO FUNCIONARIO");
	        	System.out.println("idFuncionario: " +funcionarioPesquisado.getIdFuncionario());
	            System.out.println("Nome: " +funcionarioPesquisado.getNome());
	            System.out.println("CPF: " +funcionarioPesquisado.getCpf());
	            System.out.println("Telefone: " +funcionarioPesquisado.getTelefone());
	            System.out.println("Endereco: " +funcionarioPesquisado.getEndereco());
	            System.out.println("Email: " +funcionarioPesquisado.getEmail());
	            System.out.println("Cargo: " +funcionarioPesquisado.getCargo());
	            System.out.println("Salario: " +funcionarioPesquisado.getSalario());
	            System.out.println("Data de Admissao: " +funcionarioPesquisado.getDataAdmissao());
	            System.out.println("______________________________________________");
	        }
	        else{
				System.out.println("\n FUNCIONARIO NÃO ENCONTRADO \n");
	        }
			
			Reserva r1 = new Reserva();
			System.out.println("\nINFOME OS DADOS NECESSARIOS PARA RESERVA \n");

			System.out.println("Data de Inicio de Ocupacao:");
			r1.setInicioOcupacao(s1.nextLine());
			System.out.println("Hora da entrada:");
			r1.setHoraEntrada(s1.nextLine());
	
			h1 = hospedeDAO.pesquisaCpfHospede(h1.getCpf());
			r1.setHospede(h1);
			
			f1 = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
			r1.setFuncionario(f1);
			
	
			System.out.println("Valor Pago: ");
			r1.setValorPago(s1.nextDouble());
			reservaDAO.inserir(r1);			
			System.out.println("FIM");
		}
			
		
		if(opcao == 2){
				Reserva r1 = new Reserva();
				System.out.println("Data de Fim de Ocupacao: ");
				r1.setFimOcupacao(s1.nextLine());
				System.out.println("Hora da Saida: ");
				r1.setHoraEntrada(s1.nextLine());
				System.out.println("Valor Total da Reserva: ");
				r1.setValorTotal(s1.nextDouble());
				s1.nextLine();
				System.out.println("Valor Pago: ");
				r1.setValorPago(s1.nextDouble());
				s1.nextLine();
				System.out.println("Data de Inicio de Ocupacao: ");
				r1.setInicioOcupacao(s1.nextLine());
				
				Hospede h1 = new Hospede();
				System.out.println("Nome do Hospede");
				String nomeHospede = s1.nextLine();
				h1.setNome(nomeHospede);
				System.out.println("Cpf do Hospede");
				String cpfHospede = s1.nextLine();
				h1.setCpf(cpfHospede);
				h1 = hospedeDAO.pesquisaCpfHospede(h1.getCpf());
				r1.setHospede(h1);
				reservaDAO.finalizarReserva(r1);
				System.out.println("Reserva Finalizada.");
		        
				if (hospedeDAO.pesquisaCpfHospede(h1.getCpf()).getIdHospede() == 0) {
		         					System.out.println("Hospede não encontrado.");
		        }
				
			}
	}
}
