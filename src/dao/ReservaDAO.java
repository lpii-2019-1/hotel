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
        String sql = "INSERT INTO reserva (idQuarto, inicioOcupacao, horaEntrada, idHospede, idFuncionario, valorTotal, valorPago) VALUES (?,?,?,?,?,?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, reserva.getQuarto().getIdQuarto());
            stmt.setString(2, reserva.getInicioOcupacao());
            stmt.setString(3, reserva.getHoraEntrada());
            stmt.setInt(4, reserva.getHospede().getIdHospede());
            stmt.setInt(5, reserva.getFuncionario().getIdFuncionario());
            stmt.setDouble(6, reserva.getValorTotal());
            stmt.setDouble(7, reserva.getValorPago());
            stmt.execute();
            stmt.close();
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
                QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
                reserva.setHoraEntrada(rs.getString("horaEntrada"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao"));
                reserva.setHoraSaida(rs.getString("horaSaida"));
                HospedeDAO hospedeDAO = new HospedeDAO();
                reserva.setHospede(hospedeDAO.pesquisaIdHospede(rs.getInt("idHospede")));
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
    
    public Reserva buscarIdReserva(int idReserva) {
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idReserva);
            ResultSet rs = stmt.executeQuery();
            Reserva reserva = new Reserva();
            if (rs.next()) {
                reserva.setIdReserva(rs.getInt("idReserva"));
                QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
            	QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
   
    public ArrayList<Reserva> numeroQuarto(int numero) {
        String sql = "SELECT * FROM reserva JOIN quarto ON reserva.idQuarto = quarto.idQuarto WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> listarReserva = new ArrayList<Reserva>();
            while (rs.next()) {
            	Reserva reserva = new Reserva();
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
            	hospede.setIdHospede(rs.getInt("idHospede"));
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
            	QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
            	QuartoDAO quartoDAO = new QuartoDAO();
                reserva.setQuarto(quartoDAO.pesquisaIdQuarto(rs.getInt("idQuarto")));
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
    
    public boolean editarInicioOcupacao(Reserva reserva){
        String sql = "UPDATE reserva SET inicioOcupacao = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getInicioOcupacao());
            stmt.setInt(2, reserva.getIdReserva());
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
    
    public boolean editarHoraEntrada(Reserva reserva){
        String sql = "UPDATE reserva SET horaEntrada = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getHoraEntrada());
            stmt.setInt(2, reserva.getIdReserva());
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
    public boolean editarFimOcupacao(Reserva reserva){
        String sql = "UPDATE reserva SET fimOcupacao = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getFimOcupacao());
            stmt.setInt(2, reserva.getIdReserva());
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
    
    public boolean editarHoraSaida(Reserva reserva){
        String sql = "UPDATE reserva SET horaSaida = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getHoraSaida());
            stmt.setInt(2, reserva.getIdReserva());
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
    public boolean editarValorTotal(Reserva reserva){
        String sql = "UPDATE reserva SET valorTotal = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, reserva.getValorTotal());
            stmt.setInt(2, reserva.getIdReserva());
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
    public boolean editarValorPago(Reserva reserva){
        String sql = "UPDATE reserva SET valorPago = ? WHERE idReserva = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, reserva.getValorPago());
            stmt.setInt(2, reserva.getIdReserva());
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
