package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import conexao.Conexao;
import model.Reserva;
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
    
    public ArrayList<Reserva> listarReservas() {
        String sql = "SELECT * FROM reservas";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Reserva> lista = new ArrayList<Reserva>();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao"));      	
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospde")));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setValorTotal(rs.getDouble("valorTotal"));
            	reserva.setValorTotal(rs.getDouble("valorPago"));             	
            	lista.add(reserva);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean finalizarReserva(Reserva reserva){
        String sql = "UPDATE reserva SET fimOcupacao = ?, horaSaida = ?, valorTotal = ?, valorPago = ? WHERE inicioOcupacao = ?, idHospede = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getFimOcupacao());
            stmt.setString(2, reserva.getHoraSaida());
            stmt.setDouble(3, reserva.getValorTotal());
            stmt.setDouble(4, reserva.getValorPago());
            stmt.setString(5, reserva.getInicioOcupacao());
            stmt.setInt(6, reserva.getHospede().getIdHospede());
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
    
    public boolean pagarEstadia(Reserva reserva){
        String sql = "UPDATE reserva SET valorPago = ? WHERE idHospede = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, reserva.getValorPago());
            stmt.setInt(2, reserva.getHospede().getIdHospede());
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
