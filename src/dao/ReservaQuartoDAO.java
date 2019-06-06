package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Funcionario;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.ReservaQuarto;

public class ReservaQuartoDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public ReservaQuartoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(ReservaQuarto reservaQuarto) {
        String sql = "INSERT INTO reservaQuarto (idReserva, numeroQuarto) VALUES (?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, reservaQuarto.getReserva().getIdReserva());
            stmt.setInt(2, reservaQuarto.getQuarto().getNumeroQuarto());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }

   
    public ReservaQuarto pesquisaHospede(pesquisaNomeHospede.ReservaDao) {
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
    public Reserva pesquisaIdReserva (int idOcupacaoQuarto) {
        String sql = "SELECT * FROM reserva WHERE idOcupacaoQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idOcupacaoQuarto);
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
            }
            stmt.close();
            return reserva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Reserva> listarTudo() {
        String sql = "SELECT * FROM quarto";
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
                lista.add(reserva);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
