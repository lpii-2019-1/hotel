package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Pagamento;
import model.ReservaQuarto;
import dao.ReservaQuartoDAO;

public class PagamentoDAO {
	private Connection conexao;
    private PreparedStatement stmt;

    public PagamentoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(Pagamento pagamento) {
        String sql = "INSERT INTO reserva (valorTotal, valorPago, idReservaQuarto) VALUES (?,?,?)";
        try {
        	stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, pagamento.getValorTotal());
            stmt.setDouble(2, pagamento.getValorPago());
            stmt.setInt(3, pagamento.getReservaQuarto().getIdReservaQuarto());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
}