package teste;

import java.util.ArrayList;
import java.util.Scanner;

import dao.PagamentoDAO;
import model.Pagamento;

public class TestePagamento {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();

		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Inserir Hospede");
		System.out.println("2 - Buscar Hospede");
		System.out.println("3 - Editar Hospede");
		System.out.println("4 - Excluir Hospede");
		System.out.println("5 - Listar todos os Hospedes");
		int opcao = s1.nextInt();
		s1.nextLine();

		if(opcao == 1){
			Pagamento p1 = new Pagamento();
			System.out.println("Valor Total da Hospedagem");
			p1.setValorTotal(s1.nextDouble());
			s1.nextLine();
			System.out.println("Valor Pago");
			p1.setValorTotal(s1.nextDouble());	
			s1.nextLine();
			System.out.println("Digite o Nome do Hospede");
			String nome = s1.nextLine();
			if (ReservaQuartoDAO.pesquisaReserva(oc1.getDisponibilidade()).getIdOcupacaoQuarto() == 0) {
				 ocupacaoquartoDAO.inserir(oc1);
			 }
			 oc1 = ocupacaoquartoDAO.pesquisaDisponibilidade(oc1.getDisponibilidade());
			 
			q1.setOcupacaoQuarto(oc1);
			quartoDAO.inserir(q1);
			System.out.println("FIM");
		}
		
		if(opcao == 2){
			System.out.println("Digite o nome do hospede que deseja buscar");
			String nome = s1.nextLine();
	
			Pagamento pagamentoPesquisado = pagamentoDAO.pesquisaNomeHospede(nome);
	        if (pagamentoPesquisado.getIdHospede() != 0) {
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
			System.out.println("Informe o campo a ser alterado");
			String campo = s1.nextLine();
			System.out.println("Informe o novo valor a ser inserido");
			String valor = s1.nextLine();
			System.out.println("Digite o nome do hospede que deseja editar");
			String nome = s1.nextLine();
			Pagamento pagamentoEditado = pagamentoDAO.editarHospede(campo, valor, nome);
	        if (hospedeEditado.getIdHospede() != 0) {
	            System.out.println("idHospede: " +hospedeEditado.getIdHospede());
	            System.out.println("Nome: " +hospedeEditado.getNome());
	            System.out.println("CPF: " +hospedeEditado.getCpf());
	            System.out.println("Telefone: " +hospedeEditado.getTelefone());
	            System.out.println("Endereco: " +hospedeEditado.getEndereco());
	            System.out.println("Email: " +hospedeEditado.getEmail());
	            System.out.println("Data de Cadastro: " +hospedeEditado.getDataCadastro());
	        }
		}
		
		if(opcao == 5){
        ArrayList<Pagamento> pagamento = hospedeDAO.listarHospedes();
        for (Pagamento h : pagamento) {
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