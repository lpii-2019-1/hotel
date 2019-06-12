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
		System.out.println("2 - Finalizar Reserva");
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
	        
			System.out.println("\nESCOLHA OS QUARTOS");
	        System.out.println("Informe a Quantidade de Quartos que Deseja Reservar: ");
			int qtd = s1.nextInt();
			ArrayList<Quarto> quartos = new ArrayList<Quarto>();
			for (int i = 1; i >= qtd; i++){
				Quarto q1 = new Quarto();
				System.out.println("Numero do Quarto");
				q1.setNumeroQuarto(s1.nextInt());
				Quarto quartoPesquisado = quartoDAO.pesquisaNumero(q1.getNumeroQuarto());
				if (quartoPesquisado.getIdQuarto() == 0) {
					System.out.println("\n QUARTO NÃO ENCONTRADO");
		        }
				q1 = quartoDAO.pesquisaNumero(q1.getNumeroQuarto());
            	quartos.add(q1);
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
			System.out.println("\n RESERVA FINALIZADA");
		}	
		
		if(opcao == 2){
			Hospede h1 = new Hospede();
			System.out.println("Cpf do Hospede");
			String cpfHospede = s1.nextLine();
			h1.setCpf(cpfHospede);
			Hospede hospedePesquisado = hospedeDAO.pesquisaCpfHospede(cpfHospede);
			if (hospedePesquisado.getIdHospede() == 0) {
				System.out.println("\n HOSPEDE NÃO ENCONTRADO \n");
	        }
			else{
				Reserva reservaPesquisada = reservaDAO.pesquisaHospede(cpfHospede);
				if(reservaPesquisada.getIdReserva() != 0){
					System.out.println("Nome: " +reservaPesquisada.getHospede().getNome());
		            System.out.println("CPF: " +reservaPesquisada.getHospede().getCpf());
		            System.out.println("Telefone: " +reservaPesquisada.getHospede().getTelefone());
		            System.out.println("idReserva: " +reservaPesquisada.getIdReserva());
		            System.out.println("Inicio Ocupacao: " +reservaPesquisada.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +reservaPesquisada.getHoraEntrada());
		            System.out.println("ValorPago: " +reservaPesquisada.getValorPago());
		            Reserva r1 = new Reserva();
					System.out.println("Data de Fim de Ocupacao: ");
					r1.setFimOcupacao(s1.nextLine());
					System.out.println("Hora da Saida: ");
					r1.setHoraSaida(s1.nextLine());
					System.out.println("Valor Total da Reserva: ");
					r1.setValorTotal(s1.nextDouble());
					s1.nextLine();
					System.out.println("Valor Pago: ");
					r1.setValorPago(s1.nextDouble());
					s1.nextLine();
					h1 = hospedeDAO.pesquisaCpfHospede(h1.getCpf());
					r1.setHospede(h1);
					reservaDAO.finalizarReserva(r1);
					System.out.println("\n RESERVA FINALIZADA");
				} 
	        }
		}  
		
		if(opcao == 3){
			System.out.println("Qual registro deseja buscar?");
			System.out.println("1 - Numero do Quarto");
			System.out.println("2 - Data da Reserva");
			System.out.println("3 - Hospede");
			System.out.println("4 - Funcionario");
			int buscar = s1.nextInt();
			s1.nextLine();
			
			if(buscar == 1){
				   
	       }
			if(buscar == 2){
				System.out.println("Digite a data de reserva que deseja buscar");
				String dataReserva = s1.nextLine();
				ArrayList<Reserva> reservaPesquisada = reservaDAO.dataReserva(dataReserva);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
		            System.out.println("Inicio Ocupacao: " +r.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +r.getHoraEntrada());
		            System.out.println("Fim Ocupacao: " +r.getFimOcupacao());
		            System.out.println("Hora da Saida: " +r.getHoraSaida());
		            System.out.println("idHospede: " +r.getHospede().getIdHospede());
		            System.out.println("Nome do Hospede: "+r.getHospede().getNome());
		            System.out.println("idFuncionario: "+r.getFuncionario().getIdFuncionario());
		            System.out.println("Nome do Funcionario: "+r.getFuncionario().getNome());
		            System.out.println("Valor Total: " +r.getValorPago());
		            System.out.println("Valor Pago: " +r.getValorPago());
			        System.out.println("********************************");
				}
			}
			if(buscar == 3){
				System.out.println("Digite o nome do hospede que deseja buscar");
				String nomeHospede = s1.nextLine();
				ArrayList<Reserva> reservaPesquisada = reservaDAO.dataReserva(nomeHospede);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
		            System.out.println("Inicio Ocupacao: " +r.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +r.getHoraEntrada());
		            System.out.println("Fim Ocupacao: " +r.getFimOcupacao());
		            System.out.println("Hora da Saida: " +r.getHoraSaida());
		            System.out.println("idHospede: " +r.getHospede().getIdHospede());
		            System.out.println("Nome do Hospede: "+r.getHospede().getNome());
		            System.out.println("idFuncionario: "+r.getFuncionario().getIdFuncionario());
		            System.out.println("Nome do Funcionario: "+r.getFuncionario().getNome());
		            System.out.println("Valor Total: " +r.getValorPago());
		            System.out.println("Valor Pago: " +r.getValorPago());
			        System.out.println("********************************");
				}
			}
			
			
			if(buscar == 4){
				System.out.println("Digite o nome do funcionario que deseja buscar");
				String nomeFuncionario = s1.nextLine();
				ArrayList<Reserva> reservaPesquisada = reservaDAO.dataReserva(nomeFuncionario);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
		            System.out.println("Inicio Ocupacao: " +r.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +r.getHoraEntrada());
		            System.out.println("Fim Ocupacao: " +r.getFimOcupacao());
		            System.out.println("Hora da Saida: " +r.getHoraSaida());
		            System.out.println("idHospede: " +r.getHospede().getIdHospede());
		            System.out.println("Nome do Hospede: "+r.getHospede().getNome());
		            System.out.println("idFuncionario: "+r.getFuncionario().getIdFuncionario());
		            System.out.println("Nome do Funcionario: "+r.getFuncionario().getNome());
		            System.out.println("Valor Total: " +r.getValorPago());
		            System.out.println("Valor Pago: " +r.getValorPago());
			        System.out.println("********************************");
				}
			}
		}
		
		if(opcao == 5){
			 Reserva r1 = new Reserva();
				System.out.println("Informe o id da Reserva que será excluida");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				r1 = reservaDAO.buscarIdReserva(r1.getIdReserva());				
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.excluir(r1);
					System.out.println("\n RESERVA EXCLUIDA COM SUCESSO");
		        }
		        else{
					System.out.println("\n RESERVA NÃO ENCONTRADA");
		        }
		}
		
		if(opcao == 6){
			 ArrayList<Reserva> reserva = reservaDAO.listarReservas();
		     for (Reserva r : reserva) {
		            System.out.println("idReserva: " +r.getIdReserva());
		            System.out.println("Inicio Ocupacao: " +r.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +r.getHoraEntrada());
		            System.out.println("Fim Ocupacao: " +r.getFimOcupacao());
		            System.out.println("Hora da Saida: " +r.getHoraSaida());
		            System.out.println("idHospede: " +r.getHospede().getIdHospede());
		            System.out.println("Nome do Hospede: "+r.getHospede().getNome());
		            System.out.println("idFuncionario: "+r.getFuncionario().getIdFuncionario());
		            System.out.println("Nome do Funcionario: "+r.getFuncionario().getNome());
		            System.out.println("Valor Total: " +r.getValorPago());
		            System.out.println("Valor Pago: " +r.getValorPago());
			        System.out.println("********************************");
				} 
	 }
	}
}
