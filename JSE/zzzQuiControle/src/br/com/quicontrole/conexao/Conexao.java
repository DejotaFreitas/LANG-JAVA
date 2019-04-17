package br.com.quicontrole.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.quicontrole.telas.componentes.Msg;

public class Conexao {

    private static final String URL = 
    		"jdbc:derby:myDerby;create=true;user=derby;password=derby";
		
    private static final String DRIVER = 
    		"org.apache.derby.jdbc.EmbeddedDriver";

    public static Connection conectar() {
       
        try {
            Class.forName(DRIVER).newInstance();
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
        	Msg.m("QuiControle já está sendo executado.");
        } catch (SQLException e) {
        	Msg.m("QuiControle já está sendo executado.");           
        } catch (InstantiationException e) {
        	Msg.m("QuiControle já está sendo executado.");
		} catch (IllegalAccessException e) {
			Msg.m("QuiControle já está sendo executado.");
		}
        return null;
    }
    
    public static void desligarBandoDados(){
		 try {
				DriverManager.getConnection (
			"jdbc:derby:;shutdown=true");
			} catch (SQLException exception) {	
				
			}
    }
}