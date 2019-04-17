package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Produto;

public class ProdutoDAO {

	public void cadastrar(Produto p) {
		String sql = "INSERT INTO PRODUTO(nome, codigo_barra, valor_compra, valor_venda, local_estoque, "
				+ "quantidade, descricao, imagem ,desativado, fornecedor) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
				ps.setString(1, p.getNome());
				ps.setString(2, p.getCodigo_barra());
				ps.setBigDecimal(3, p.getValor_compra());
				ps.setBigDecimal(4, p.getValor_venda());
				ps.setString(5, p.getLocal_estoque());
				ps.setInt(6, p.getQuantidade());
				ps.setString(7, p.getDescricao());
				ps.setBytes(8, (p.getImagem()!=null?p.getImagem():new byte[]{}));
				ps.setBoolean(9, p.getDesativado());
				ps.setInt(10, (p.getFornecedor()!=null?p.getFornecedor().getId_fornecedor():0));
				ps.executeUpdate();			
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}		
		
	}

	public void alterar(Produto p) {
		String sql = "UPDATE PRODUTO SET nome = ?, codigo_barra = ?, valor_compra = ?,"
				+ " valor_venda = ?, local_estoque = ?, quantidade = ?, descricao = ?,"
				+ " imagem = ?,desativado = ? , fornecedor = ? WHERE id_produto = ?";
		
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCodigo_barra());
			ps.setBigDecimal(3, p.getValor_compra());
			ps.setBigDecimal(4, p.getValor_venda());
			ps.setString(5, p.getLocal_estoque());
			ps.setInt(6, p.getQuantidade());
			ps.setString(7, p.getDescricao());
			ps.setBytes(8, (p.getImagem()!=null?p.getImagem():new byte[]{}));
			ps.setBoolean(9, p.getDesativado());
			ps.setInt(10, (p.getFornecedor()!=null?p.getFornecedor().getId_fornecedor():0));
			ps.setInt(11, p.getId_produto());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}

	public void excluir(Produto p) {
		String sql = "DELETE FROM PRODUTO WHERE id_produto = ? ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setInt(1, p.getId_produto());
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	

	public List<Produto> listar() {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO";
		//String sql = "SELECT * FROM PRODUTO FETCH FIRST 36 ROWS ONLY";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public List<Produto> pesquisarListaNome(String nome) {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE LOWER(nome) LIKE LOWER(?)";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> pesquisaListaCodigoBarra(String codigoBarra) {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE codigo_barra LIKE ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+codigoBarra+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Produto buscaCodigoBarra(String codigoBarra) {
		Produto p = null;
		String sql = "SELECT * FROM PRODUTO WHERE codigo_barra = ? ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, codigoBarra);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				p = new Produto();
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Produto buscaID(int id) {
		Produto p = null;
		String sql = "SELECT * FROM PRODUTO WHERE id_produto = ? ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				p = new Produto();
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//=====LISTA DE VENDA======================================================
	

	
	public List<Produto> listarVenda() {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE desativado = false FETCH FIRST 35 ROWS ONLY" ;
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));			
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> pesquisarNomeVenda(String nome) {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE LOWER(nome) LIKE LOWER(?) AND "
				+ "desativado = false FETCH FIRST 35 ROW ONLY";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public Produto buscaCodigoBarraVenda(String CodigoBarra) {
		Produto p = null;
		String sql = "SELECT * FROM PRODUTO WHERE codigo_barra = ? AND desativado = false"
				+ " FETCH FIRST 35 ROW ONLY";
		
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, CodigoBarra);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				p = new Produto();
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//=========LISTA ATIVOS======================================
	
	public List<Produto> listarAtivos() {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE desativado = false" ;
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));			
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> pesquisarNomeAtivos(String nome) {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE LOWER(nome) LIKE LOWER(?) AND desativado = false";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	

	public List<Produto> buscaCodigoBarraAtivos(String codigoBarra) {
		List<Produto> listProduto = new ArrayList<Produto>();
		String sql = "SELECT * FROM PRODUTO WHERE codigo_barra LIKE ?  AND desativado = false";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+codigoBarra+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();				
				p.setId_produto(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setCodigo_barra(rs.getString("codigo_barra"));
				p.setValor_compra(rs.getBigDecimal("valor_compra"));
				p.setValor_venda(rs.getBigDecimal("valor_venda"));
				p.setLocal_estoque(rs.getString("local_estoque"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDescricao(rs.getString("descricao"));
				p.setImagem(rs.getBytes("imagem"));
				p.setDesativado(rs.getBoolean("desativado"));			
				p.setFornecedor(new FornecedorDAO().buscaID(rs.getInt("fornecedor")));				
				listProduto.add(p);
			}
			return listProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
