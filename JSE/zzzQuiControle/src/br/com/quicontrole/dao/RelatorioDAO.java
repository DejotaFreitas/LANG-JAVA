package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Tranzacao;

public class RelatorioDAO {
	

	public ArrayList<Tranzacao> listarProdutosMaisVendidosMensal() {
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();
		String sql = "SELECT SUM(quantidade) AS quantidade, "
				+ "produto, mes, ano "
				+ "FROM VENDA "
				+ "GROUP BY produto, mes, ano  "
				+ "ORDER BY mes ASC, quantidade DESC "
				+ "FETCH FIRST 100 ROWS ONLY ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Tranzacao v = new Tranzacao();				
				v.setProduto(new ProdutoDAO().buscaID(rs.getInt("produto")));
				v.setQuantidade(rs.getInt("quantidade"));
				v.setMes(rs.getString("mes"));
				v.setAno(rs.getString("ano"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Tranzacao> listarValorVendaTotalMensal(String ano) {
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();
		String sql = "SELECT SUM(valor_total) AS valor_total, "
				+ "mes "
				+ "FROM VENDA "
				+ "WHERE ano LIKE ? "			
				+ "GROUP BY mes "
				+ "ORDER BY mes ASC "
				+ "FETCH FIRST 12 ROWS ONLY ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, ano);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tranzacao v = new Tranzacao();
				v.setTotal(rs.getBigDecimal("valor_total"));
				v.setMes(rs.getString("mes"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Tranzacao> listarValorCompraTotalMensal(String ano) {
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();
		String sql = "SELECT SUM(valor_total) AS valor_total, "
				+ "mes "
				+ "FROM COMPRA "
				+ "WHERE ano LIKE  ? "
				+ "GROUP BY mes "
				+ "ORDER BY mes ASC "
				+ "FETCH FIRST 12 ROWS ONLY ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, ano);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tranzacao v = new Tranzacao();
				v.setTotal(rs.getBigDecimal("valor_total"));
				v.setMes(rs.getString("mes"));
				list.add(v);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Tranzacao> listarValorVendaTotalAnual(String anoInicio, String anoFim) {		
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();	
		System.out.println(anoInicio+" "+anoFim);
		int inicio = Integer.parseInt(anoInicio);
		int fim = Integer.parseInt(anoFim);		
		ArrayList<String> anos = listaAnos();
		ArrayList<Integer> anosInt = new ArrayList<Integer>();
		for (Object ano : anos) {
			anosInt.add(Integer.parseInt(ano.toString()));
			System.out.println(ano.toString());
		}		
		for (Integer ano : anosInt) {
			if (ano >= inicio && ano <= fim) {
				String sql = "SELECT SUM(valor_total) AS valor_total, "
						+ "ano "
						+ "FROM VENDA "
						+ "WHERE ano = ? "			
						+ "GROUP BY ano ";
				try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
					ps.setString(1, ano.toString());
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Tranzacao t = new Tranzacao();
						t.setTotal(rs.getBigDecimal("valor_total"));
						t.setAno(rs.getString("ano"));
						list.add(t);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}		
		return list;
	}
	
	public ArrayList<Tranzacao> listarValorCompraTotalAnual(String anoInicio, String anoFim) {		
		ArrayList<Tranzacao> list = new ArrayList<Tranzacao>();		
		int inicio = Integer.parseInt(anoInicio);
		int fim = Integer.parseInt(anoFim);		
		ArrayList<String> anos = listaAnos();
		ArrayList<Integer> anosInt = new ArrayList<Integer>();
		for (Object ano : anos) {
			anosInt.add(Integer.parseInt(ano.toString()));
			System.out.println(ano.toString());
		}		
		for (Integer ano : anosInt) {
			if (ano >= inicio && ano <= fim) {
				String sql = "SELECT SUM(valor_total) AS valor_total, "
						+ "ano "
						+ "FROM COMPRA "
						+ "WHERE ano = ? "				
						+ "GROUP BY ano ";
				try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
					ps.setString(1, ano.toString());
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Tranzacao t = new Tranzacao();
						t.setTotal(rs.getBigDecimal("valor_total"));
						t.setAno(rs.getString("ano"));
						list.add(t);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}		
		return list;
	}
	
	public ArrayList<Object> listaAnosComboBox() {
		ArrayList<Object> list = new ArrayList<Object>();
		String sql = "SELECT ano "
				+ "FROM COMPRA "
				+ "GROUP BY ano "
				+ "ORDER BY ano DESC ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(rs.getString("ano"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> listaAnos() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT ano "
				+ "FROM COMPRA "
				+ "GROUP BY ano "
				+ "ORDER BY ano DESC ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(rs.getString("ano"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
