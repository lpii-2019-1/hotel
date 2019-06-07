package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Funcionario;
public class FuncionarioDAO {

    private Connection conexao;
    private PreparedStatement stmt;

    public FuncionarioDAO() {
        this.conexao = new Conexao().getConexao();
    }
	
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, telefone, endereco, email, cargo, salario, dataAdmissao) VALUES (?,?,?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getCargo());
            stmt.setDouble(7, funcionario.getSalario());
            stmt.setString(8, funcionario.getDataAdmissao());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Funcionario pesquisaNomeFuncionario(String nomeFuncionario) {
        String sql = "SELECT * FROM funcionario WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeFuncionario);
            ResultSet rs = stmt.executeQuery();
            Funcionario funcionario = new Funcionario();
            if (rs.next()) {
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setTelefone(rs.getString("telefone"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setSalario(rs.getDouble("salario"));
            	funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
            }
            stmt.close();
            return funcionario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Funcionario pesquisaCpfFuncionario(String cpfFuncionario) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpfFuncionario);
            ResultSet rs = stmt.executeQuery();
            Funcionario funcionario = new Funcionario();
            if (rs.next()) {
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setTelefone(rs.getString("telefone"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setSalario(rs.getDouble("salario"));
            	funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
            }
            stmt.close();
            return funcionario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Funcionario>pesquisaCargo(String cargo) {
        String sql = "SELECT * FROM funcionario WHERE cargo LIKE ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+ cargo +"%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Funcionario> cargos = new ArrayList<Funcionario>();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setTelefone(rs.getString("telefone"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setSalario(rs.getDouble("salario"));
            	funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
            	cargos.add(funcionario);
            }
            stmt.close();
            return cargos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
  
    public Funcionario pesquisaIdFuncionario(int idFuncionario) {
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();
            Funcionario funcionario = new Funcionario();
            if (rs.next()) {
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setTelefone(rs.getString("telefone"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setSalario(rs.getDouble("salario"));
            	funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
            }
            stmt.close();
            return funcionario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Funcionario> listarFuncionarios() {
        String sql = "SELECT * FROM funcionario";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setTelefone(rs.getString("telefone"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setSalario(rs.getDouble("salario"));
            	funcionario.setDataAdmissao(rs.getString("dataAdmissao"));
            	lista.add(funcionario);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean editarNome(Funcionario funcionario){
        String sql ="UPDATE funcionario SET nome = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
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
    public boolean editarCpf(Funcionario funcionario){
        String sql ="UPDATE funcionario SET cpf = ? WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
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
    public boolean editarTelefone(Funcionario funcionario){
        String sql ="UPDATE funcionario SET telefone = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getTelefone());
            stmt.setString(2, funcionario.getCpf());
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
    public boolean editarEndereco(Funcionario funcionario){
        String sql ="UPDATE funcionario SET endereco = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getEndereco());
            stmt.setString(2, funcionario.getCpf());
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
    public boolean editarEmail(Funcionario funcionario){
        String sql ="UPDATE funcionario SET email = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getEmail());
            stmt.setString(2, funcionario.getCpf());
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
    public boolean editarCargo(Funcionario funcionario){
        String sql ="UPDATE funcionario SET cargo = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getCargo());
            stmt.setString(2, funcionario.getCpf());
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
    
    public boolean editarSalario(Funcionario funcionario){
        String sql ="UPDATE funcionario SET salario = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, funcionario.getSalario());
            stmt.setString(2, funcionario.getCpf());
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
    
    public boolean editarDataCadastro(Funcionario funcionario){
        String sql ="UPDATE funcionario SET dataAdmissao = ? WHERE cpf = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getDataAdmissao());
            stmt.setString(2, funcionario.getCpf());
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
        
    public boolean excluir(Funcionario funcionario){
        String sql ="DELETE FROM funcionario where nome = ? and cpf = ?";        
        try {
            stmt = conexao.prepareStatement(sql);
        	stmt.setString(1, funcionario.getNome());
        	stmt.setString(2, funcionario.getCpf());

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
