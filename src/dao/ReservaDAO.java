package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;

import conexao.Conexao;
import model.Reserva;
import dao.HospedeDAO;
import dao.FuncionarioDAO;

public class ReservaDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public ReservaDAO() {
        this.conexao = new Conexao().getConexao();
    }
    
    public void inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (inicioOcupacao, fimOcupacao, idHospede, idFuncionario, valorTotal, valorPago) VALUES (?,?,?,?,?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getInicioOcupacao());
            stmt.setString(2, reserva.getFimOcupacao());
            stmt.setInt(3, reserva.getHospede().getIdHospede());
            stmt.setInt(4, reserva.getFuncionario().getIdFuncionario());
            stmt.setDouble(5, reserva.getValorTotal());
            stmt.setDouble(6, reserva.getValorPago());
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
}
