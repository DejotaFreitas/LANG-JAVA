package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Tranzacao;

public class VendaDAO {
	
	public void cadastrarLista(List<Tranzacao> lista) {
		
		String sql = "INSERT INTO VENDA(produto, quantidade, valor_total, dia, mes, ano ,hora)"
				+ "VALUES (?,?,?,?,?,?,?)";
		for (Tranzacao v : lista) {
			try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
				ps.setInt(1, v.getProduto().getId_produto());
				ps.setInt(2, v.getQuantidade());
				ps.setBigDecimal(3, v.getTotal());
				ps.setString(4, v.getDia());
				ps.setString(5, v.getMes());
				ps.setString(6, v.getAno());
				ps.setString(7, v.getHora());
				ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}		
	}
	
//===================================================================================

	public List<Tranzacao> listar() {
		List<Tranzacao> list = new ArrayList<Tranzacao>();
		String sql = "SELECT * FROM VENDA ORDER BY id_venda DESC";
		//String sql = "SELECT * FROM PRODUTO FETCH FIRST 36 ROWS ONLY";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Tranzacao v = new Tranzacao();				
				v.setId(rs.getInt("id_venda"));
				v.setProduto(new ProdutoDAO().buscaID(rs.getInt("produto")));
				v.setQuantidade(rs.getInt("quantidade"));
				v.setTotal(rs.getBigDecimal("valor_total"));
				v.setDia(rs.getString("dia"));
				v.setMes(rs.getString("mes"));
				v.setAno(rs.getString("ano"));
				v.setHora(rs.getString("hora"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	
	public ArrayList<Tranzacao> pesquisaData(String dia, String mes, String ano, String hora) {
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();
		String sql = "SELECT * FROM VENDA WHERE dia LIKE ? AND mes LIKE ? AND ano LIKE ? AND hora LIKE ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, dia);
			ps.setString(2, mes);
			ps.setString(3, ano);
			ps.setString(4, hora);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tranzacao v = new Tranzacao();
				v.setId(rs.getInt("id_venda"));
				v.setProduto(new ProdutoDAO().buscaID(rs.getInt("produto")));
				v.setQuantidade(rs.getInt("quantidade"));
				v.setTotal(rs.getBigDecimal("valor_total"));
				v.setDia(rs.getString("dia"));
				v.setMes(rs.getString("mes"));
				v.setAno(rs.getString("ano"));
				v.setHora(rs.getString("hora"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
