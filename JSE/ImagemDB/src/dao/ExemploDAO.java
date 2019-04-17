/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Exemplo;

/**
 *
 * @author marcelosiedler
 */
public class ExemploDAO {
    
    public Boolean inserir(Exemplo exemplo)
    {
        Boolean retorno = false;
        String sql = "INSERT INTO exemplo (imagem) values (?)";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try
        {
            pst.setBytes(1, exemplo.getImagem());
            pst.executeUpdate();
            retorno = true;
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return retorno;
    
    }
    
    public Exemplo buscar(Integer id)
    {
        Exemplo retorno = null;
        String sql = "SELECT id,imagem from exemplo where id=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                retorno = new Exemplo();
                retorno.setId(rs.getInt("id"));
                retorno.setImagem(rs.getBytes("imagem"));
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }
        
        return retorno;
    
    }
    
}
