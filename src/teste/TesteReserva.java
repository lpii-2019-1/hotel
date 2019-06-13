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
		System.out.println("QUARTOS DISPONIVEIS \n");
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
	        
	        Quarto q1 = new Quarto();
			System.out.println("\nESCOLHA O QUARTO");
	        System.out.println("Informe o numero do quarto que deseja reservar: ");
			int numero = s1.nextInt();
			q1.setNumeroQuarto(numero);
			
			Quarto quartoPesquisado = quartoDAO.pesquisaNumero(q1.getNumeroQuarto());
			if (quartoPesquisado.getIdQuarto() == 0) {
				System.out.println("\n QUARTO NÃO ENCONTRADO");
		    }
			else {
				quartoDAO.ocuparQuarto(q1);
		    }
			
			s1.nextLine();
			System.out.println("\nINFOME OS DADOS NECESSARIOS PARA RESERVA");
	        Reserva r1 = new Reserva();
	        
	        q1 = quartoDAO.pesquisaNumero(q1.getNumeroQuarto());
			r1.setQuarto(q1);
			
			System.out.println("Data de Inicio de Ocupacao:");
			r1.setInicioOcupacao(s1.nextLine());
			System.out.println("Hora da entrada:");
			r1.setHoraEntrada(s1.nextLine());
	
			h1 = hospedeDAO.pesquisaCpfHospede(h1.getCpf());
			r1.setHospede(h1);
			f1 = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
			r1.setFuncionario(f1);
	
			System.out.println("Valor Pago:");
			r1.setValorPago(s1.nextDouble());
			reservaDAO.inserir(r1);	
			System.out.println("\n RESERVA REALIZADA");
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
					System.out.println("Nome: " +reservaPesquisada.getHospede().getNome());
		            System.out.println("CPF: " +reservaPesquisada.getHospede().getCpf());
		            System.out.println("Telefone: " +reservaPesquisada.getHospede().getTelefone());
		            System.out.println("idReserva: " +reservaPesquisada.getIdReserva());
					System.out.println("Numero do Quarto: " +reservaPesquisada.getQuarto().getNumeroQuarto());
		            System.out.println("Inicio Ocupacao: " +reservaPesquisada.getInicioOcupacao());
		            System.out.println("Hora da Entrada: " +reservaPesquisada.getHoraEntrada());
		            System.out.println("Funcionario: " +reservaPesquisada.getFuncionario().getNome());
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
					
					Quarto q1 = new Quarto();
					q1.setNumeroQuarto(reservaPesquisada.getQuarto().getNumeroQuarto());
					Quarto quartoPesquisado = quartoDAO.pesquisaNumero(q1.getNumeroQuarto());
					if (quartoPesquisado.getIdQuarto() != 0) {
						quartoDAO.disponibilizarQuarto(q1);
				    }
		
					reservaDAO.finalizarReserva(r1);
					System.out.println("\n RESERVA FINALIZADA"); 
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
				System.out.println("Digite o numero do quarto que deseja buscar");
				int numero = s1.nextInt();
				ArrayList<Reserva> reservaPesquisada = reservaDAO.numeroQuarto(numero);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
					System.out.println("idQuarto: "+r.getQuarto().getIdQuarto());
			        System.out.println("Numero do Quarto: "+r.getQuarto().getNumeroQuarto());
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
			if(buscar == 2){
				System.out.println("Digite a data de reserva que deseja buscar");
				String dataReserva = s1.nextLine();
				ArrayList<Reserva> reservaPesquisada = reservaDAO.dataReserva(dataReserva);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
					System.out.println("idQuarto: "+r.getQuarto().getIdQuarto());
			        System.out.println("Numero do Quarto: "+r.getQuarto().getNumeroQuarto());
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
				ArrayList<Reserva> reservaPesquisada = reservaDAO.nomeHospede(nomeHospede);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
					System.out.println("idQuarto: "+r.getQuarto().getIdQuarto());
			        System.out.println("Numero do Quarto: "+r.getQuarto().getNumeroQuarto());
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
				ArrayList<Reserva> reservaPesquisada = reservaDAO.nomeFuncionario(nomeFuncionario);
				for (Reserva r: reservaPesquisada) {
					System.out.println("idReserva: " +r.getIdReserva());
					System.out.println("idQuarto: "+r.getQuarto().getIdQuarto());
			        System.out.println("Numero do Quarto: "+r.getQuarto().getNumeroQuarto());
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
		
		if(opcao == 4){
			System.out.println("Qual registro deseja editar?");
			System.out.println("1 - Inicio de Ocupacao");
			System.out.println("2 - Hora da Entrada");
			System.out.println("3 - Fim da Ocupacao");
			System.out.println("4 - Hora da Saida");
			System.out.println("5 - Valor Total");
			System.out.println("6 - Valor Pago");
			int editar = s1.nextInt();
			s1.nextLine();
			
			if(editar == 1){
	            Reserva r1 = new Reserva();
				System.out.println("Nova Data de Inicio Ocupacao:");
				r1.setInicioOcupacao(s1.nextLine());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarInicioOcupacao(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
			    }
			}
			if(editar == 2){
				Reserva r1 = new Reserva();
				System.out.println("Nova Hora de Entrada:");
				r1.setHoraEntrada(s1.nextLine());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarHoraEntrada(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
			    }
			}
			if(editar == 3){
				Reserva r1 = new Reserva();
				System.out.println("Nova Data de Fim Ocupacao:");
				r1.setFimOcupacao(s1.nextLine());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarFimOcupacao(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
			    }
			}
			if(editar == 4){
				Reserva r1 = new Reserva();
				System.out.println("Nova Hora de Saida:");
				r1.setHoraSaida(s1.nextLine());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarHoraSaida(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
			    }
			}
			if(editar == 5){
				Reserva r1 = new Reserva();
				System.out.println("Novo Valor Total:");
				r1.setValorTotal(s1.nextDouble());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarValorTotal(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
			    }
			}
			
			if(editar == 6){
				Reserva r1 = new Reserva();
				System.out.println("Novo Valor Pago:");
				r1.setValorPago(s1.nextDouble());
				System.out.println("idReserva:");
				int id = s1.nextInt();
				r1.setIdReserva(id);
				Reserva reservaPesquisada = reservaDAO.buscarIdReserva(r1.getIdReserva());
				if (reservaPesquisada.getIdReserva() == id) {
					reservaDAO.editarValorPago(r1);
					System.out.println("\n RESERVA EDITADA COM SUCESSO");
			    }
			    else{
			    	System.out.println("\n RESERVA NÃO ENCONTRADA");
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
		            System.out.println("idQuarto: "+r.getQuarto().getIdQuarto());
			        System.out.println("Numero do Quarto: "+r.getQuarto().getNumeroQuarto());
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
