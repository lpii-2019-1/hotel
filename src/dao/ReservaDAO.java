package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import conexao.Conexao;
import model.Reserva;
import model.Hospede;
import model.Funcionario;
import model.Quarto;
import dao.HospedeDAO;
import dao.FuncionarioDAO;
import dao.QuartoDAO;

public class ReservaDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public ReservaDAO() {
        this.conexao = new Conexao().getConexao();
    }
    
    public void inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (inicioOcupacao, horaEntrada, idHospede, idFuncionario, valorPago) VALUES (?,?,?,?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getInicioOcupacao());
            stmt.setString(2, reserva.getHoraEntrada());
            stmt.setInt(3, reserva.getHospede().getIdHospede());
            stmt.setInt(4, reserva.getFuncionario().getIdFuncionario());
            stmt.setDouble(5, reserva.getValorPago());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
    
    public Reserva buscarIdReserva(int idReserva) {
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idReserva);
            ResultSet rs = stmt.executeQuery();
            Reserva reserva = new Reserva();
            if (rs.next()) {
                reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao"));
                reserva.setHoraSaida(rs.getString("horaSaida"));
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospede")));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));             	
            }
            stmt.close();
            return reserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
  
    public ArrayList<Reserva> listarReservas() {
        String sql = "SELECT * FROM reserva";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> lista = new ArrayList<Reserva>();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao"));
                reserva.setHoraSaida(rs.getString("horaSaida"));
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospede")));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));             	
            	lista.add(reserva);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Reserva pesquisaHospede(String cpfHospede) {
        String sql = "SELECT * FROM reserva JOIN hospede ON reserva.idHospede = hospede.idHospede WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpfHospede);
            ResultSet rs = stmt.executeQuery();
            Reserva reserva = new Reserva();
            Hospede hospede = new Hospede();
            if (rs.next()) {
            	hospede.setIdHospede(rs.getInt("idHospede"));
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao")); 
                reserva.setHoraSaida(rs.getString("horaSaida"));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));
            }
            stmt.close();
            return reserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
    public ArrayList<Reserva> nomeHospede(String nomeHospede) {
        String sql = "SELECT * FROM reserva JOIN hospede ON reserva.idHospede = hospede.idHospede WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeHospede);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> listarReserva = new ArrayList<Reserva>();
            while (rs.next()) {
            	Reserva reserva = new Reserva();
                Hospede hospede = new Hospede();
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao")); 
                reserva.setHoraSaida(rs.getString("horaSaida"));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));             	
            	listarReserva.add(reserva);
            }
            stmt.close();
            return listarReserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Reserva> nomeFuncionario(String nomeFuncionario) {
        String sql = "SELECT * FROM reserva JOIN funcionario ON reserva.idFuncionario = funcionario.idFuncionario WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeFuncionario);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> listarReserva = new ArrayList<Reserva>();
            while (rs.next()) {
            	Reserva reserva = new Reserva();
            	Funcionario funcionario = new Funcionario();
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao")); 
                reserva.setHoraSaida(rs.getString("horaSaida"));
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospede")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));             	
            	listarReserva.add(reserva);
            }
            stmt.close();
            return listarReserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Reserva> dataReserva(String dataReserva) {
        String sql = "SELECT * FROM reserva WHERE inicioOcupacao = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, dataReserva);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> listarReserva = new ArrayList<Reserva>();
            while (rs.next()) {
            	Reserva reserva = new Reserva();
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao")); 
                reserva.setHoraSaida(rs.getString("horaSaida"));
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospede")));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorPago(rs.getDouble("valorPago"));             	
            	listarReserva.add(reserva);
            }
            stmt.close();
            return listarReserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean finalizarReserva(Reserva reserva){
        String sql = "UPDATE reserva SET fimOcupacao = ?, horaSaida = ?, valorTotal = ?, valorPago = ? WHERE idHospede = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getFimOcupacao());
            stmt.setString(2, reserva.getHoraSaida());
            stmt.setDouble(3, reserva.getValorTotal());
            stmt.setDouble(4, reserva.getValorPago());
            stmt.setInt(5, reserva.getHospede().getIdHospede());
            int n=stmt.executeUpdate();
            if (n!=0){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean excluir(Reserva reserva){
        String sql ="DELETE FROM reserva WHERE idReserva = ?";        
        try {
            stmt = conexao.prepareStatement(sql);
        	stmt.setInt(1, reserva.getIdReserva());
            int n=stmt.executeUpdate();
            if (n!=0){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
