package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FuncionarioDAO;
import model.Funcionario;
import model.Hospede;

public class TesteFuncionario {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Inserir Funcionario");
		System.out.println("2 - Buscar Funcionario");
		System.out.println("3 - Editar Funcionario");
		System.out.println("4 - Excluir Funcionario");
		System.out.println("5 - Listar todos os Funcionario");
		int opcao = s1.nextInt();
		s1.nextLine();

		if(opcao == 1){
			Funcionario f1 = new Funcionario();
			System.out.println("Digite o Nome");
			f1.setNome(s1.nextLine());
			System.out.println("Digite o CPF");
			f1.setCpf(s1.nextLine());		
			System.out.println("Digite o Telefone");
			f1.setTelefone(s1.nextLine());
			System.out.println("Digite o Endereco");
			f1.setEndereco(s1.nextLine());
			System.out.println("Digite o Email");
			f1.setEmail(s1.nextLine());
			System.out.println("Digite o Cargo");
			f1.setCargo(s1.nextLine());
			System.out.println("Digite o Salario");
			f1.setSalario(s1.nextDouble());
			s1.nextLine();
			System.out.println("Digite a Data de Admissao");
			f1.setDataAdmissao(s1.nextLine());
			Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
	        if (funcionarioPesquisado.getIdFuncionario() == 0) {
	        	funcionarioDAO.inserir(f1);
				System.out.println("\n FUNCIONARIO CADASTRADO COM SUCESSO");
	        }
	        else{
				System.out.println("\n FUNCIONARIO JÁ CADASTRADO");
	        }
		}
		
		if(opcao == 2){
			System.out.println("Qual registro deseja buscar?");
			System.out.println("1 - Nome do Funcionario");
			System.out.println("2 - CPF do Funcionario");
			System.out.println("3 - Cargo");
			System.out.println("4 - Data de Admissao");


			int buscar = s1.nextInt();
			s1.nextLine();
			if(buscar == 1){
				System.out.println("Digite o nome do funcionario que deseja buscar");
				String nome = s1.nextLine();
				ArrayList<Funcionario> funcionarioPesquisado = funcionarioDAO.pesquisaNomeFuncionario(nome);
		        for (Funcionario f: funcionarioPesquisado) {
		            System.out.println("idFuncionario: " +f.getIdFuncionario());
		            System.out.println("Nome: " +f.getNome());
		            System.out.println("CPF: " +f.getCpf());
		            System.out.println("Telefone: " +f.getTelefone());
		            System.out.println("Endereco: " +f.getEndereco());
		            System.out.println("Email: " +f.getEmail());
		            System.out.println("Cargo: " +f.getCargo());
		            System.out.println("Salario: " +f.getSalario());
		            System.out.println("Data de Admissao: " +f.getDataAdmissao()); 
			        System.out.println("********************************");
		        }
			}	
			if(buscar == 2){
				System.out.println("Digite o cpf do funcionario que deseja buscar");
				String cpf = s1.nextLine();
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(cpf);
		        if (funcionarioPesquisado.getIdFuncionario() != 0) {
		            System.out.println("idFuncionario: " +funcionarioPesquisado.getIdFuncionario());
		            System.out.println("Nome: " +funcionarioPesquisado.getNome());
		            System.out.println("CPF: " +funcionarioPesquisado.getCpf());
		            System.out.println("Telefone: " +funcionarioPesquisado.getTelefone());
		            System.out.println("Endereco: " +funcionarioPesquisado.getEndereco());
		            System.out.println("Email: " +funcionarioPesquisado.getEmail());
		            System.out.println("Cargo: " +funcionarioPesquisado.getCargo());
		            System.out.println("Salario: " +funcionarioPesquisado.getSalario());
		            System.out.println("Data de Admissao: " +funcionarioPesquisado.getDataAdmissao()); 
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }
			}  
		
			
			if(buscar == 3){
				System.out.println("Digite o cargo que deseja buscar");
				String cargo = s1.nextLine();
				ArrayList<Funcionario> funcionarioPesquisado = funcionarioDAO.pesquisaCargo(cargo);
		        for (Funcionario f: funcionarioPesquisado) {
		            System.out.println("idFuncionario: " +f.getIdFuncionario());
		            System.out.println("Nome: " +f.getNome());
		            System.out.println("CPF: " +f.getCpf());
		            System.out.println("Telefone: " +f.getTelefone());
		            System.out.println("Endereco: " +f.getEndereco());
		            System.out.println("Email: " +f.getEmail());
		            System.out.println("Cargo: " +f.getCargo());
		            System.out.println("Salario: " +f.getSalario());
		            System.out.println("Data de Admissao: " +f.getDataAdmissao());
				    System.out.println("********************************");
		        }
			}
			
			if(buscar == 4){
				System.out.println("Digite a data de admissao que deseja buscar");
				String data = s1.nextLine();
				ArrayList<Funcionario> funcionarioPesquisado = funcionarioDAO.pesquisaDataAdmissao(data);
		        for (Funcionario f: funcionarioPesquisado) {
		            System.out.println("idFuncionario: " +f.getIdFuncionario());
		            System.out.println("Nome: " +f.getNome());
		            System.out.println("CPF: " +f.getCpf());
		            System.out.println("Telefone: " +f.getTelefone());
		            System.out.println("Endereco: " +f.getEndereco());
		            System.out.println("Email: " +f.getEmail());
		            System.out.println("Cargo: " +f.getCargo());
		            System.out.println("Salario: " +f.getSalario());
		            System.out.println("Data de Admissao: " +f.getDataAdmissao());
				    System.out.println("********************************");
		        }
			}
		}

		if(opcao == 3){
			System.out.println("Qual registro será alterado?");
			System.out.println("1 - Nome");
			System.out.println("2 - CPF");
			System.out.println("3 - Telefone");
			System.out.println("4 - Endereco");
			System.out.println("5 - Email");
			System.out.println("6 - Cargo");
			System.out.println("7 - Salario");
			System.out.println("8 - Data de Admissao");
			int editar = s1.nextInt();
			s1.nextLine();
			
			if(editar == 1){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Nome: ");
				f1.setNome(s1.nextLine());
				System.out.println("CPF do Funcionario: ");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarNome(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }
			}
			if(editar == 2){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo CPF:");
				f1.setCpf(s1.nextLine());
				System.out.println("Nome do Funcionario:");
				f1.setNome(s1.nextLine());
				funcionarioDAO.editarCpf(f1);
				ArrayList<Funcionario> funcionarioPesquisado = funcionarioDAO.pesquisaNomeFuncionario(f1.getNome());
		        for (Funcionario f: funcionarioPesquisado) {
		            System.out.println("idFuncionario: " +f.getIdFuncionario());
		            System.out.println("Nome: " +f.getNome());
		            System.out.println("CPF: " +f.getCpf());
		            System.out.println("Telefone: " +f.getTelefone());
		            System.out.println("Endereco: " +f.getEndereco());
		            System.out.println("Email: " +f.getEmail());
		            System.out.println("Cargo: " +f.getCargo());
		            System.out.println("Salario: " +f.getSalario());
		            System.out.println("Data de Admissao: " +f.getDataAdmissao()); 
			        System.out.println("********************************");
		        }
		        System.out.println("ID Do Funcionario Que Deseja Realizar a Alteração:");
				f1.setIdFuncionario(s1.nextInt());
				funcionarioDAO.editarCpf(f1);
				System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
			}
			
			if(editar == 3){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Telefone:");
				f1.setTelefone(s1.nextLine());
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarTelefone(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
			if(editar == 4){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Endereco:");
				f1.setEndereco(s1.nextLine());
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarEndereco(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
			if(editar == 5){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Email:");
				f1.setEmail(s1.nextLine());
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarEmail(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
			if(editar == 6){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Cargo:");
				f1.setCargo(s1.nextLine());
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarCargo(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
			if(editar == 7){
				Funcionario f1 = new Funcionario();
				System.out.println("Novo Salario:");
				f1.setSalario(s1.nextDouble());
				s1.nextLine();
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarSalario(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
			if(editar == 8){
				Funcionario f1 = new Funcionario();
				System.out.println("Nova Data de Admissao:");
				f1.setDataAdmissao(s1.nextLine());
				System.out.println("CPF do Funcionario:");
				f1.setCpf(s1.nextLine());
				Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
				if (funcionarioPesquisado.getIdFuncionario() == 0) {
					funcionarioDAO.editarDataAdmissao(f1);
					System.out.println("\n FUNCIONARIO EDITADO COM SUCESSO");
		        }
		        else{
					System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
		        }			
			}
		}
		
		if(opcao == 4){
			System.out.println("Informe os dados para excluir um funcionario");
			Funcionario f1 = new Funcionario();
			System.out.println("Nome:");
			f1.setNome(s1.nextLine());
			System.out.println("CPF:");
			f1.setCpf(s1.nextLine());
			Funcionario funcionarioPesquisado = funcionarioDAO.pesquisaCpfFuncionario(f1.getCpf());
			if (funcionarioPesquisado.getIdFuncionario() == 0) {
				funcionarioDAO.excluir(f1);
				System.out.println("\n FUNCIONARIO EXCLUIDO COM SUCESSO");
	        }
	        else{
				System.out.println("\n FUNCIONARIO NÃO ENCONTRADO");
	        }		
		}
		
		
		if(opcao == 5){
        ArrayList<Funcionario> funcionario = funcionarioDAO.listarFuncionarios();
        for (Funcionario f : funcionario) {
        	System.out.println("idFuncionario: " +f.getIdFuncionario());
            System.out.println("Nome: " +f.getNome());
            System.out.println("CPF: " +f.getCpf());
            System.out.println("Telefone: " +f.getTelefone());
            System.out.println("Endereco: " +f.getEndereco());
            System.out.println("Email: " +f.getEmail());
            System.out.println("Cargo: " +f.getCargo());
            System.out.println("Salario: " +f.getSalario());
            System.out.println("Data de Admissao: " +f.getDataAdmissao());
            System.out.println("********************************");
        }
       }
	}
}