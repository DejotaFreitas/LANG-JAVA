
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.CreateTables;
import dao.PessoaDao;
import model.Pessoa;

public class DerbyTest {
    public static void main(String[] args) {
        criarTabelas();
        inserirPessoas();
        listarPessoas();
        try {
			DriverManager.getConnection ("jdbc:derby:;shutdown=true");
		} catch (SQLException e) {	}
    }

    private static void criarTabelas() {
    	new CreateTables().createTablePessoas();
    	new CreateTables().createTableTelefones();
    }

    private static void inserirPessoas() {
        PessoaDao dao = new PessoaDao();

        Pessoa p1 = new Pessoa();
        p1.setNome("Ana Maria");
        p1.setIdade(65);
        dao.save(p1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Francisco");
        p2.setIdade(40);
        dao.save(p2);
        
        Pessoa p3 = new Pessoa();
        p3.setNome("Xuxa");
        p3.setIdade(66);
        dao.save(p3);

    }

    private static void listarPessoas() {
        List<Pessoa> pessoas = new PessoaDao().findPessoas();
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }
    }
}
