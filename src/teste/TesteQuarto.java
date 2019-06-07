package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.QuartoDAO;
import model.Quarto;

public class TesteQuarto {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
	
		QuartoDAO quartoDAO = new QuartoDAO();
		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Inserir Quarto");
		System.out.println("2 - Buscar Quarto");
		System.out.println("3 - Editar Quarto");
		System.out.println("4 - Excluir Quarto");
		System.out.println("5 - Listar Quartos Disponiveis");
		System.out.println("6 - Listar todos os Quartos");
		int opcao = s1.nextInt();
		s1.nextLine();
		
		if(opcao == 1){
			Quarto q1 = new Quarto();
			System.out.println("Numero do Quarto");
			q1.setNumeroQuarto(s1.nextInt());
			s1.nextLine();
			System.out.println("Descricao");
			q1.setDescricao(s1.nextLine());		
			System.out.println("Valor da diaria");
			q1.setValor(s1.nextDouble());
			q1.setOcupacaoQuarto(0);
			quartoDAO.inserir(q1);
			System.out.println("FIM");
		}
		
		if(opcao == 2){
			System.out.println("Qual registro deseja buscar?");
			System.out.println("1 - Numero do Quarto");
			System.out.println("2 - Descricao");
			System.out.println("3 - Valor da Diaria");
			int buscar = s1.nextInt();
			s1.nextLine();
			
			if(buscar == 1){
				System.out.println("Digite o numero do quarto que deseja buscar");
				int numero = s1.nextInt();
				Quarto quartoPesquisado = quartoDAO.pesquisaNumero(numero);
		        System.out.println("Numero do Quarto: " +quartoPesquisado.getNumeroQuarto());
		        System.out.println("Descricao: " +quartoPesquisado.getDescricao());
		        System.out.println("Valor da diaria: " +quartoPesquisado.getValor());
		        System.out.println("Disponibilidade: " +quartoPesquisado.getOcupacaoQuarto());
			}
			if(buscar == 2){
				System.out.println("Digite a descricao do quarto que deseja buscar");
				String descricao = s1.nextLine();
				ArrayList<Quarto> quartoPesquisado = quartoDAO.pesquisaDescricao(descricao);
				for (Quarto q: quartoPesquisado) {
					System.out.println("Numero: " +q.getNumeroQuarto());
				    System.out.println("Descricao: " +q.getDescricao());
				    System.out.println("Valor da diaria: " +q.getValor());
			        System.out.println("Disponibilidade: " +q.getOcupacaoQuarto());
				    System.out.println("********************************");
				}
			}
			if(buscar == 3){
				System.out.println("Digite o valor do quarto que deseja");
				double valor = s1.nextDouble();
				ArrayList<Quarto> quartoPesquisado = quartoDAO.pesquisaValor(valor);
				for (Quarto q: quartoPesquisado) {
					System.out.println("Numero: " +q.getNumeroQuarto());
				    System.out.println("Descricao: " +q.getDescricao());
				    System.out.println("Valor da diaria: " +q.getValor());
			        System.out.println("Disponibilidade: " +q.getOcupacaoQuarto());
				    System.out.println("********************************");
				}
			}
		 }
		
		if(opcao == 3){
			System.out.println("Qual registro será alterado?");
			System.out.println("1 - Numero do Quarto");
			System.out.println("2 - Descricao");
			System.out.println("3 - Valor da Diaria");
			System.out.println("4 - Ocupacao");
			int editar = s1.nextInt();
			s1.nextLine();
			
			if(editar == 1){
				Quarto q1 = new Quarto();
				System.out.println("Novo Numero");
				q1.setNumeroQuarto(s1.nextInt());
				System.out.println("idQuarto");
				q1.setIdQuarto(s1.nextInt());
				quartoDAO.editarNumero(q1);
				System.out.println("FIM");
			}
			if(editar == 2){
				Quarto q1 = new Quarto();
				System.out.println("Novo Descricao");
				q1.setDescricao(s1.nextLine());
				System.out.println("Numero do Quarto");
				q1.setNumeroQuarto(s1.nextInt());
				quartoDAO.editarDescricao(q1);
				System.out.println("FIM");
			}
			if(editar == 3){
				Quarto q1 = new Quarto();
				System.out.println("Novo Valor da Diaria");
				q1.setValor(s1.nextInt());
				System.out.println("Numero do Quarto");
				q1.setNumeroQuarto(s1.nextInt());
				quartoDAO.editarValor(q1);
				System.out.println("FIM");
			}
		}
		
		if(opcao == 4){
			Quarto q1 = new Quarto();
			System.out.println("Informe o quarto que será excluido");
			q1.setNumeroQuarto(s1.nextInt());
			quartoDAO.excluir(q1);
			System.out.println("FIM");
		}
		
		if (opcao ==5){
			System.out.println("QUARTOS DISPONIVEIS");
	        System.out.println("********************************");
			ArrayList<Quarto> quarto = quartoDAO.pesquisaOcupacaoQuarto(0);	
			for (Quarto q: quarto) {
				System.out.println("Numero: " +q.getNumeroQuarto());
		        System.out.println("Descricao: " +q.getDescricao());
		        System.out.println("Valor da diaria: " +q.getValor());
		        System.out.println("********************************");
		    }
		}
		if(opcao == 6){
			 ArrayList<Quarto> quarto = quartoDAO.listarQuartos();
		     for (Quarto q : quarto) {
		            System.out.println("Numero: " + q.getNumeroQuarto());
		            System.out.println("Descricao: " +q.getDescricao());
		            System.out.println("Valor da diaria: " +q.getValor());
		            System.out.println("Disponibilidade: " +q.getOcupacaoQuarto());
		            System.out.println("********************************");
		        }
		}
	}
}
