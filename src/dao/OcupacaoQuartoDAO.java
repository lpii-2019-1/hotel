package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.OcupacaoQuarto;

public class OcupacaoQuartoDAO {

	private Connection conexao;
	private PreparedStatement stmt;
	
	public OcupacaoQuartoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(OcupacaoQuarto ocupacaoQuarto) {
		String sql = "INSERT INTO ocupacaoQuarto (disponibilidade) VALUES (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, ocupacaoQuarto.getDisponibilidade());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(OcupacaoQuarto ocupacaoQuarto) {
		String sql = "UPDATE ocupacaoQuarto SET disponibilidade = ? WHERE idOcupacaoQuarto = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, ocupacaoQuarto.getDisponibilidade());
			stmt.setInt(2, ocupacaoQuarto.getIdOcupacaoQuarto());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public OcupacaoQuarto pesquisaDisponibilidade(String disponibilidadeQuarto) {
		String sql = "SELECT * FROM ocupacaoQuarto WHERE disponibilidade = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disponibilidadeQuarto);
			ResultSet rs = stmt.executeQuery();
			OcupacaoQuarto ocupacaoQuarto = new OcupacaoQuarto();
			if (rs.next()) {
				ocupacaoQuarto.setIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto"));
				ocupacaoQuarto.setDisponibilidade(rs.getString("disponibilidade"));
			}
			return ocupacaoQuarto;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public OcupacaoQuarto pesquisaIdOcupacaoQuarto(int idOcupacaoQuarto) {
		String sql = "SELECT * FROM ocupacaoQuarto WHERE idOcupacaoQuarto = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idOcupacaoQuarto);
			ResultSet rs = stmt.executeQuery();
			OcupacaoQuarto ocupacaoQuarto = new OcupacaoQuarto();
			if (rs.next()) {
				ocupacaoQuarto.setIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto"));
				ocupacaoQuarto.setDisponibilidade(rs.getString("disponibilidade"));
			}
			return ocupacaoQuarto;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<OcupacaoQuarto> listarTudo() {
		String sql = "SELECT * FROM ocupacaoQuarto";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<OcupacaoQuarto> lista = new ArrayList<OcupacaoQuarto>();
			while (rs.next()) {
				OcupacaoQuarto ocupacaoQuarto = new OcupacaoQuarto();
				ocupacaoQuarto.setIdOcupacaoQuarto(rs.getInt("idOcupacaoQuarto"));
				ocupacaoQuarto.setDisponibilidade(rs.getString("disponibilidade"));
				lista.add(ocupacaoQuarto);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}