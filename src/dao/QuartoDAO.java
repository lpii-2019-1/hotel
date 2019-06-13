package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Quarto;

public class QuartoDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public QuartoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(Quarto quarto) {
        String sql = "INSERT INTO quarto (numeroQuarto, descricao, valor, OcupacaoQuarto) VALUES (?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumeroQuarto());
            stmt.setString(2, quarto.getDescricao());
            stmt.setDouble(3, quarto.getValor());
            stmt.setInt(4, quarto.getOcupacaoQuarto());
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
            	quarto.setIdQuarto(rs.getInt("idQuarto"));
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                quarto.setOcupacaoQuarto((rs.getInt("OcupacaoQuarto")));
            }
            stmt.close();
            return quarto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
    public Quarto pesquisaIdQuarto(int idQuarto) {
        String sql = "SELECT * FROM quarto WHERE idQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idQuarto);
            ResultSet rs = stmt.executeQuery();
            Quarto quarto = new Quarto();
            if (rs.next()) {
            	quarto.setIdQuarto(rs.getInt("idQuarto"));
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                quarto.setOcupacaoQuarto((rs.getInt("OcupacaoQuarto")));
            }
            stmt.close();
            return quarto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public  ArrayList<Quarto>pesquisaOcupacaoQuarto(int ocupacaoQuarto) {
        String sql = "SELECT * FROM quarto WHERE ocupacaoQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ocupacaoQuarto);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quarto> disponiveis = new ArrayList<Quarto>();
            while (rs.next()) {
            	Quarto quarto = new Quarto();
            	quarto.setIdQuarto(rs.getInt("idQuarto"));
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                quarto.setOcupacaoQuarto(rs.getInt("ocupacaoQuarto"));
                disponiveis.add(quarto);
            }
            stmt.close();
            return disponiveis;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Quarto>pesquisaDescricao(String descricao) {
        String sql = "SELECT * FROM quarto WHERE descricao LIKE ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+ descricao +"%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quarto> descricaoQuartos = new ArrayList<Quarto>();
            while (rs.next()) {
            	Quarto quarto = new Quarto();
            	quarto.setIdQuarto(rs.getInt("idQuarto"));
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                quarto.setOcupacaoQuarto(rs.getInt("ocupacaoQuarto"));
                descricaoQuartos.add(quarto);
            }
            stmt.close();
            return descricaoQuartos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public  ArrayList<Quarto>pesquisaValor(double valor) {
        String sql = "SELECT * FROM quarto WHERE valor = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, valor);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quarto> valorQuartos = new ArrayList<Quarto>();
            while (rs.next()) {
            	Quarto quarto = new Quarto();
            	quarto.setIdQuarto(rs.getInt("idQuarto"));
            	quarto.setNumeroQuarto(rs.getInt("numeroQuarto"));
            	quarto.setDescricao(rs.getString("descricao"));
            	quarto.setValor(rs.getDouble("valor"));
                quarto.setOcupacaoQuarto(rs.getInt("ocupacaoQuarto"));
                valorQuartos.add(quarto);
            }
            stmt.close();
            return valorQuartos;
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
                quarto.setOcupacaoQuarto(rs.getInt("ocupacaoQuarto"));
                lista.add(quarto);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarNumero(Quarto quarto){
        String sql = "UPDATE quarto SET numeroQuarto = ? WHERE idQuarto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumeroQuarto());
            stmt.setInt(2, quarto.getIdQuarto());
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
    
    public boolean ocuparQuarto(Quarto quarto){
        String sql ="UPDATE quarto SET ocupacaoQuarto = 1 WHERE numeroQuarto = ?";
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
    
    public boolean disponibilizarQuarto(Quarto quarto){
        String sql ="UPDATE quarto SET ocupacaoQuarto = 0 WHERE numeroQuarto = ?";
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
