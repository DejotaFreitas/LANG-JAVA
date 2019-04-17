package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Cliente;

public class ClienteDAO {
	
	public void cadastrar(Cliente c) {
		String sql = "INSERT INTO CLIENTE(nome, cpf, telefone, email, endereco, descricao) "
				+ "VALUES (?,?,?,?,?,?)";
		
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCpf());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getEndereco());
			ps.setString(6, c.getDescricao());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Cliente c) {
		String sql = "UPDATE CLIENTE SET nome = ?, cpf = ?, "
				+ "telefone = ?, email = ?, endereco = ?, descricao = ? "
				+ "WHERE id_cliente = ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCpf());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getEndereco());
			ps.setString(6, c.getDescricao());
			ps.setInt(7, c.getId_cliente());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	
	public void excluir(Cliente f) {
		String sql = "DELETE FROM CLIENTE WHERE id_cliente = ? ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {		
			ps.setInt(1, f.getId_cliente());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente buscaID(int id_cliente) {
			String sql = "SELECT * FROM CLIENTE WHERE id_cliente = ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {			
			ps.setInt(1, id_cliente);
			ResultSet rs = ps.executeQuery();				
			while (rs.next()) {
				Cliente c = new Cliente();				
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));				
				c.setEndereco(rs.getString("endereco"));
				c.setDescricao(rs.getString("descricao"));
				rs.close();
				return c;
				}
			rs.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM CLIENTE";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Cliente c = new Cliente();				
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));				
				c.setEndereco(rs.getString("endereco"));
				c.setDescricao(rs.getString("descricao"));			
				lista.add(c);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	
	
	public List<Cliente> pesquisarNome(String nome) {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM CLIENTE WHERE LOWER(nome) LIKE LOWER(?)";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();				
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));				
				c.setEndereco(rs.getString("endereco"));
				c.setDescricao(rs.getString("descricao"));			
				lista.add(c);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
