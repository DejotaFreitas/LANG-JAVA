package br.com.quicontrole.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quicontrole.conexao.Conexao;
import br.com.quicontrole.entidades.Fornecedor;

public class FornecedorDAO {
	
	public void cadastrar(Fornecedor f) {
		String sql = "INSERT INTO FORNECEDOR(nome, razao_social, cnpj, cpf, inscricao_estadual, "
				+ "inscricao_municipal, telefone, email, endereco, descricao, desativado) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, f.getNome());
			ps.setString(2, f.getRazao_social());
			ps.setString(3, f.getCnpj());
			ps.setString(4, f.getCpf());
			ps.setString(5, f.getInscricao_estadual());
			ps.setString(6, f.getInscricao_municipal());
			ps.setString(7, f.getTelefone());
			ps.setString(8, f.getEmail());
			ps.setString(9, f.getEndereco());
			ps.setString(10, f.getDescricao());
			ps.setBoolean(11, f.getDesativado());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Fornecedor f) {
		String sql = "UPDATE FORNECEDOR SET nome = ?, razao_social = ?, cnpj = ?, "
				+ "cpf = ?, inscricao_estadual = ?, inscricao_municipal = ?, "
				+ "telefone = ?, email = ?, endereco = ?, descricao = ?, desativado = ? "
				+ "WHERE id_fornecedor = ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, f.getNome());
			ps.setString(2, f.getRazao_social());
			ps.setString(3, f.getCnpj());
			ps.setString(4, f.getCpf());
			ps.setString(5, f.getInscricao_estadual());
			ps.setString(6, f.getInscricao_municipal());
			ps.setString(7, f.getTelefone());
			ps.setString(8, f.getEmail());
			ps.setString(9, f.getEndereco());
			ps.setString(10, f.getDescricao());
			ps.setBoolean(11, f.getDesativado());
			ps.setInt(12, f.getId_fornecedor());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	
	public void excluir(Fornecedor f) {
		String sql = "DELETE FROM FORNECEDOR WHERE id_fornecedor = ? ";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {		
			ps.setInt(1, f.getId_fornecedor());
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Fornecedor buscaID(int id_fornecedor) {
			String sql = "SELECT * FROM FORNECEDOR WHERE id_fornecedor = ?";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {			
			ps.setInt(1, id_fornecedor);
			ResultSet rs = ps.executeQuery();				
			while (rs.next()) {
				Fornecedor f = new Fornecedor();				
				f.setId_fornecedor(rs.getInt("id_fornecedor"));
				f.setNome(rs.getString("nome"));
				f.setRazao_social(rs.getString("razao_social"));
				f.setCnpj(rs.getString("cnpj"));
				f.setCpf(rs.getString("cpf"));
				f.setInscricao_estadual(rs.getString("inscricao_estadual"));
				f.setInscricao_municipal(rs.getString("inscricao_municipal"));
				f.setTelefone(rs.getString("telefone"));
				f.setEmail(rs.getString("email"));				
				f.setEndereco(rs.getString("endereco"));
				f.setDescricao(rs.getString("descricao"));
				f.setDesativado(rs.getBoolean("desativado"));
				rs.close();
				return f;
				}
			rs.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Fornecedor> listar() {
		List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
		String sql = "SELECT * FROM FORNECEDOR";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Fornecedor f = new Fornecedor();				
				f.setId_fornecedor(rs.getInt("id_fornecedor"));
				f.setNome(rs.getString("nome"));
				f.setRazao_social(rs.getString("razao_social"));
				f.setCnpj(rs.getString("cnpj"));
				f.setCpf(rs.getString("cpf"));
				f.setInscricao_estadual(rs.getString("inscricao_estadual"));
				f.setInscricao_municipal(rs.getString("inscricao_municipal"));
				f.setTelefone(rs.getString("telefone"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setDescricao(rs.getString("descricao"));
				f.setDesativado(rs.getBoolean("desativado"));
				listFornecedor.add(f);
			}
			return listFornecedor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Object> listarComboBox() {
		List<Object> listFornecedor = new ArrayList<Object>();
		String sql = "SELECT * FROM FORNECEDOR WHERE desativado = false ORDER BY nome";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Fornecedor f = new Fornecedor();				
				f.setId_fornecedor(rs.getInt("id_fornecedor"));
				f.setNome(rs.getString("nome"));			
				listFornecedor.add(f);
			}
			return listFornecedor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Fornecedor> pesquisarNome(String nome) {
		List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
		String sql = "SELECT * FROM FORNECEDOR WHERE LOWER(nome) LIKE LOWER(?)";
		try (PreparedStatement ps = Conexao.conectar().prepareStatement(sql)) {
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Fornecedor f = new Fornecedor();				
				f.setId_fornecedor(rs.getInt("id_fornecedor"));
				f.setNome(rs.getString("nome"));
				f.setRazao_social(rs.getString("razao_social"));
				f.setCnpj(rs.getString("cnpj"));
				f.setCpf(rs.getString("cpf"));
				f.setInscricao_estadual(rs.getString("inscricao_estadual"));
				f.setInscricao_municipal(rs.getString("inscricao_municipal"));
				f.setTelefone(rs.getString("telefone"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setDescricao(rs.getString("descricao"));
				f.setDesativado(rs.getBoolean("desativado"));
				listFornecedor.add(f);
			}
			return listFornecedor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	


}
