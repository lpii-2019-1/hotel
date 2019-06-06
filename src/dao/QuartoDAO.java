package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Hospede;
import model.Quarto;

public class QuartoDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public QuartoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(Quarto quarto) {
        String sql = "INSERT INTO quarto (numeroQuarto, descricao, valor, idOcupacaoQuarto) VALUES (?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumeroQuarto());
            stmt.setString(2, quarto.getDescricao());
            stmt.setDouble(3, quarto.getValor());
            stmt.setInt(4, quarto.getOcupacaoQuarto().getIdOcupacaoQuarto());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Quarto pesquisaNumero(int numeroQuarto) {
        String sql = "SELECT * FROM quarto WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numeroQuarto);
            ResultSet rs = stmt.executeQuery();
            Quarto quarto = new Quarto();
            if (rs.next()) {
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                OcupacaoQuartoDAO ocupacaoQuartoDAO = new OcupacaoQuartoDAO();
                quarto.setOcupacaoQuarto(ocupacaoQuartoDAO.pesquisaIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto")));
            }
            stmt.close();
            return quarto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
    public  ArrayList<Quarto>pesquisaIdOcupacaoQuarto(int idOcupacaoQuarto) {
        String sql = "SELECT * FROM quarto WHERE idOcupacaoQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idOcupacaoQuarto);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quarto> disponiveis = new ArrayList<Quarto>();
            while (rs.next()) {
            	Quarto quarto = new Quarto();
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                OcupacaoQuartoDAO ocupacaoQuartoDAO = new OcupacaoQuartoDAO();
                quarto.setOcupacaoQuarto(ocupacaoQuartoDAO.pesquisaIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto")));
                disponiveis.add(quarto);
            }
            stmt.close();
            return disponiveis;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
  
    public ArrayList<Quarto> listarQuartos() {
        String sql = "SELECT * FROM quarto";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quarto> lista = new ArrayList<Quarto>();
            while (rs.next()) {
            	Quarto quarto = new Quarto();
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                OcupacaoQuartoDAO ocupacaoQuartoDAO = new OcupacaoQuartoDAO();
                quarto.setOcupacaoQuarto(ocupacaoQuartoDAO.pesquisaIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto")));
                lista.add(quarto);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarNumero(Quarto quarto){
        String sql = "UPDATE quarto SET numeroQuarto = ? WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumeroQuarto());
            stmt.setInt(2, quarto.getNumeroQuarto());
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
    
    public boolean editarDescricao(Quarto quarto){
        String sql ="UPDATE quarto SET descricao = ? WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, quarto.getDescricao());
            stmt.setInt(2, quarto.getNumeroQuarto());
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
    
    public boolean editarValor(Quarto quarto){
        String sql ="UPDATE quarto SET valor = ? WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, quarto.getValor());
            stmt.setInt(2, quarto.getNumeroQuarto());
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
    
    public boolean editarOcupacao(Quarto quarto){
        String sql ="UPDATE quarto SET idOcupacaoQuarto = ? WHERE numeroQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getOcupacaoQuarto().getIdOcupacaoQuarto());
            stmt.setInt(2, quarto.getNumeroQuarto());
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
    
    public boolean excluir(Quarto quarto){
        String sql ="DELETE FROM quarto WHERE numeroQuarto = ?";        
        try {
            stmt = conexao.prepareStatement(sql);
        	stmt.setInt(1, quarto.getNumeroQuarto());
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
