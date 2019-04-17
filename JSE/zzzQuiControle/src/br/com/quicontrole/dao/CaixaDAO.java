package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Caixa;

public class CaixaDAO {
	
	public void cadastrar(Caixa c) {
		
		String sql = "INSERT INTO CAIXA(valor_atual, movimentacao, tipo, dia, mes, ano ,hora)"
				+ "VALUES (?,?,?,?,?,?,?)";
			try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
				ps.setBigDecimal(1, c.getValor_atual());
				ps.setBigDecimal(2, c.getMovimentacao());
				ps.setString(3, c.getTipo());
				ps.setString(4, c.getDia());
				ps.setString(5, c.getMes());
				ps.setString(6, c.getAno());
				ps.setString(7, c.getHora());
				ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}
	
//===================================================================================

	public ArrayList<Caixa> listar() {
		ArrayList<Caixa> list = new ArrayList<Caixa>();
		String sql = "SELECT * FROM CAIXA ORDER BY id_caixa DESC FETCH FIRST 100 ROWS ONLY";
		//String sql = "SELECT * FROM PRODUTO FETCH FIRST 36 ROWS ONLY";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Caixa c = new Caixa();				
				c.setId_caixa(rs.getInt("id_caixa"));
				c.setValor_atual(rs.getBigDecimal("valor_atual"));
				c.setMovimentacao(rs.getBigDecimal("movimentacao"));
				c.setTipo(rs.getString("tipo"));
				c.setDia(rs.getString("dia"));
				c.setMes(rs.getString("mes"));
				c.setAno(rs.getString("ano"));
				c.setHora(rs.getString("hora"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	
	public ArrayList<Caixa> pesquisaData(String dia, String mes, String ano) {
		ArrayList<Caixa> list = new ArrayList<Caixa>();
		String sql = "SELECT * FROM CAIXA WHERE dia LIKE ? AND mes LIKE ? AND ano LIKE ? ORDER BY id_caixa DESC";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+dia+"%");
			ps.setString(2, "%"+mes+"%");
			ps.setString(3, "%"+ano+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Caixa c = new Caixa();				
				c.setId_caixa(rs.getInt("id_caixa"));
				c.setValor_atual(rs.getBigDecimal("valor_atual"));
				c.setMovimentacao(rs.getBigDecimal("movimentacao"));
				c.setTipo(rs.getString("tipo"));
				c.setDia(rs.getString("dia"));
				c.setMes(rs.getString("mes"));
				c.setAno(rs.getString("ano"));
				c.setHora(rs.getString("hora"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Caixa ultimoRegistro() {
		Caixa c = null;
		String sql = "SELECT * FROM CAIXA ORDER BY id_caixa DESC FETCH FIRST 1 ROWS ONLY";
		//String sql = "SELECT * FROM PRODUTO FETCH FIRST 36 ROWS ONLY";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				c = new Caixa();				
				c.setId_caixa(rs.getInt("id_caixa"));
				c.setValor_atual(rs.getBigDecimal("valor_atual"));
				c.setMovimentacao(rs.getBigDecimal("movimentacao"));
				c.setTipo(rs.getString("tipo"));
				c.setDia(rs.getString("dia"));
				c.setMes(rs.getString("mes"));
				c.setAno(rs.getString("ano"));
				c.setHora(rs.getString("hora"));
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
