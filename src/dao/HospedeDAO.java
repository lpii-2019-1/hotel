package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Hospede;

public class HospedeDAO {

    private Connection conexao;
    private PreparedStatement stmt;

    public HospedeDAO() {
        this.conexao = new Conexao().getConexao();
    }
	
    public void inserir(Hospede hospede) {
        String sql = "INSERT INTO hospede (nome, cpf, telefone, endereco, email, dataCadastro) VALUES (?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setString(3, hospede.getTelefone());
            stmt.setString(4, hospede.getEndereco());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getDataCadastro());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Hospede pesquisaNomeHospede(String nomeHospede) {
        String sql = "SELECT * FROM hospede WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeHospede);
            ResultSet rs = stmt.executeQuery();
            Hospede hospede = new Hospede();
            if (rs.next()) {
            	hospede.setIdHospede(rs.getInt("idHospede"));
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            }
            stmt.close();
            return hospede;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Hospede pesquisaCpfHospede(String cpfHospede) {
        String sql = "SELECT * FROM hospede WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpfHospede);
            ResultSet rs = stmt.executeQuery();
            Hospede hospede = new Hospede();
            if (rs.next()) {
            	hospede.setIdHospede(rs.getInt("idHospede"));
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            }
            stmt.close();
            return hospede;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Hospede pesquisaIdHospede(int idHospede) {
        String sql = "SELECT * FROM hospede WHERE idHospede = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idHospede);
            ResultSet rs = stmt.executeQuery();
            Hospede hospede = new Hospede();
            if (rs.next()) {
            	hospede.setIdHospede(rs.getInt("idHospede"));
            	hospede.setNome(rs.getString("nome"));
            	hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            }
            stmt.close();
            return hospede;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Hospede> listarHospedes() {
        String sql = "SELECT * FROM hospede";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Hospede> lista = new ArrayList<Hospede>();
            while (rs.next()) {
            	Hospede hospede = new Hospede();
                hospede.setIdHospede(rs.getInt("idHospede"));
                hospede.setNome(rs.getString("nome"));
                hospede.setCpf(rs.getString("cpf"));
            	hospede.setTelefone(rs.getString("telefone"));
            	hospede.setEndereco(rs.getString("endereco"));
            	hospede.setEmail(rs.getString("email"));
            	hospede.setDataCadastro(rs.getString("dataCadastro"));
            	lista.add(hospede);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarNome(Hospede hospede){
        String sql ="UPDATE hospede SET nome = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
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
    
    public boolean editarCpf(Hospede hospede){
        String sql ="UPDATE hospede SET cpf = ? WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getCpf());
            stmt.setString(2, hospede.getNome());
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
    
    public boolean editarTelefone(Hospede hospede){
        String sql ="UPDATE hospede SET telefone = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getTelefone());
            stmt.setString(2, hospede.getCpf());
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
    
    public boolean editarEndereco(Hospede hospede){
        String sql ="UPDATE hospede SET endereco = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getEndereco());
            stmt.setString(2, hospede.getCpf());
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
    
    public boolean editarEmail(Hospede hospede){
        String sql ="UPDATE hospede SET email = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getEmail());
            stmt.setString(2, hospede.getCpf());
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
    
    public boolean editarDataCadastro(Hospede hospede){
        String sql ="UPDATE hospede SET dataCadastro = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, hospede.getDataCadastro());
            stmt.setString(2, hospede.getCpf());
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
        
    public boolean excluir(Hospede hospede){
        String sql ="DELETE FROM hospede WHERE nome = ? and cpf = ? and idHospede > 0";        
        try {
            stmt = conexao.prepareStatement(sql);
        	stmt.setString(1, hospede.getNome());
        	stmt.setString(2, hospede.getCpf());

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
