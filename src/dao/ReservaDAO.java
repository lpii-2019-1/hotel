package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Funcionario;
import model.Hospede;
import model.Reserva;
import model.ReservaQuarto;
import dao.HospedeDAO;
import dao.FuncionarioDAO;

public class ReservaDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public ReservaDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (inicioOcupacao, fimOcupacao, valorTotal, valorPago,idHospede, idFuncionario) VALUES (?,?,?,?,?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setString(1, reserva.getInicioOcupacao());
            stmt.setString(2, reserva.getFimOcupacao());
            stmt.setDouble(3, reserva.getValorTotal());
            stmt.setDouble(4, reserva.getValorPago());
            stmt.setInt(5, reserva.getHospede().getIdHospede());
            stmt.setInt(6, reserva.getFuncionario().getIdFuncionario());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
    
    public Reserva pesquisaNumero(int numeroQuarto) {
        String sql = "SELECT * FROM reserva INNER JOIN reservaquarto ON reserva.idReserva = reservaquarto.idReserva WHERE quarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numeroQuarto);
            ResultSet rs = stmt.executeQuery();
            Reserva reserva = new Reserva();
            if (rs.next()) {
            	reserva.setIdReserva(rs.getInt("idReserva"));
            	reserva.setInicioOcupacao(rs.getString("inicioOcupacao"));
            	reserva.setFimOcupacao(rs.getString("fimOcupacao"));      	
                HospedeDAO hospedeoDAO = new HospedeDAO();
                reserva.setHospede(hospedeoDAO.pesquisaIdHospede(rs.getInt("idHospde")));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("idFuncionario")));
                reserva.setFuncionario(funcionarioDAO.pesquisaIdFuncionario(rs.getInt("Quarto")));
                
            }
            stmt.close();
            return reserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
