package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.HospedeDAO;
import model.Hospede;

public class TesteHospede {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		HospedeDAO hospedeDAO = new HospedeDAO();

		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Inserir Hospede");
		System.out.println("2 - Buscar Hospede");
		System.out.println("3 - Editar Hospede");
		System.out.println("4 - Excluir Hospede");
		System.out.println("5 - Listar todos os Hospedes");
		int opcao = s1.nextInt();
		s1.nextLine();

		if(opcao == 1){
			Hospede h1 = new Hospede();
			System.out.println("Nome");
			h1.setNome(s1.nextLine());
			System.out.println("CPF");
			h1.setCpf(s1.nextLine());		
			System.out.println("Telefone");
			h1.setTelefone(s1.nextLine());
			System.out.println("Endereco");
			h1.setEndereco(s1.nextLine());
			System.out.println("Email");
			h1.setEmail(s1.nextLine());
			System.out.println("Data de Cadastro");
			h1.setDataCadastro(s1.nextLine());
			hospedeDAO.inserir(h1);
			
			System.out.println("FIM");
		}
		
		if(opcao == 2){
			System.out.println("Digite o nome do hospede que deseja buscar");
			String nome = s1.nextLine();
	
			Hospede hospedePesquisado = hospedeDAO.pesquisaNomeHospede(nome);
	        if (hospedePesquisado.getIdHospede() != 0) {
	            System.out.println("idHospede: " +hospedePesquisado.getIdHospede());
	            System.out.println("Nome: " +hospedePesquisado.getNome());
	            System.out.println("CPF: " +hospedePesquisado.getCpf());
	            System.out.println("Telefone: " +hospedePesquisado.getTelefone());
	            System.out.println("Endereco: " +hospedePesquisado.getEndereco());
	            System.out.println("Email: " +hospedePesquisado.getEmail());
	            System.out.println("Data de Cadastro: " +hospedePesquisado.getDataCadastro());
	        }     
		}
		
		if(opcao == 3){
			System.out.println("Qual registro será alterado?");
			System.out.println("1 - Nome");
			System.out.println("2 - CPF");
			System.out.println("3 - Telefone");
			System.out.println("4 - Endereco");
			System.out.println("5 - Email");
			System.out.println("6 - Data de Cadastro");
			int editar = s1.nextInt();
			s1.nextLine();
			
			if(editar == 1){
				Hospede h1 = new Hospede();
				System.out.println("Novo Nome");
				h1.setNome(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
			
				hospedeDAO.editarNome(h1);
				System.out.println("FIM");
			}
			if(editar == 2){
				Hospede h1 = new Hospede();
				System.out.println("Novo CPF");
				h1.setCpf(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
				hospedeDAO.editarCpf(h1);
				System.out.println("FIM");
			}
			if(editar == 3){
				Hospede h1 = new Hospede();
				System.out.println("Novo Telefone");
				h1.setTelefone(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
				hospedeDAO.editarTelefone(h1);
				System.out.println("FIM");
			}
			if(editar == 4){
				Hospede h1 = new Hospede();
				System.out.println("Novo Endereco");
				h1.setEndereco(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
				hospedeDAO.editarEndereco(h1);
				System.out.println("FIM");
			}
			if(editar == 5){
				Hospede h1 = new Hospede();
				System.out.println("Novo Email");
				h1.setEmail(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
				hospedeDAO.editarEmail(h1);
				System.out.println("FIM");
			}
			
			if(editar == 6){
				Hospede h1 = new Hospede();
				System.out.println("Nova Data de Cadastro");
				h1.setDataCadastro(s1.nextLine());
				System.out.println("idHospede");
				h1.setIdHospede(s1.nextInt());
				hospedeDAO.editarDataCadastro(h1);
				System.out.println("FIM");
			}
		}
		
		if(opcao == 4){
			System.out.println("Informe os dados para excluir um hospede");
			Hospede h1 = new Hospede();
			System.out.println("Nome:");
			h1.setNome(s1.nextLine());
			System.out.println("CPF:");
			h1.setCpf(s1.nextLine());
			hospedeDAO.excluir(h1);
			System.out.println("FIM");
		}
		
	
		if(opcao == 5){
        ArrayList<Hospede> hospede = hospedeDAO.listarHospedes();
        for (Hospede h : hospede) {
            System.out.println("idHospede: " +h.getIdHospede());
            System.out.println("Nome: " +h.getNome());
            System.out.println("CPF: " +h.getCpf());
            System.out.println("Telefone: " +h.getTelefone());
            System.out.println("Endereco: " +h.getEndereco());
            System.out.println("Email: " +h.getEmail());
            System.out.println("Data de Cadastro: " +h.getDataCadastro());
            System.out.println("********************************");
        }
       }
	}
}