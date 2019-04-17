package OrdenarObjetosStringNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList teste = new ArrayList();
        teste.add (new Presidente ("Luis Inacio", 2002, 2005));
        teste.add (new Presidente ("Fernando Henrique", 1998, 2001));
        teste.add (new Presidente ("Fernando Henrique", 1994, 1997));
        

        OrdenarPorNome(teste);
        System.out.println (teste);
        OrdenarPorNumero(teste);
        System.out.println (teste);

	}
	
	public static void OrdenarPorNumero(ArrayList teste){
        Collections.sort(teste, new Comparator() {
            public int compare(Object o1, Object o2) {
                Presidente p1 = (Presidente) o1;
                Presidente p2 = (Presidente) o2;
                return p1.inicio < p2.inicio ? -1 : (p1.inicio > p2.inicio ? +1 : 0);
            }
        });
	}
	public static void OrdenarPorNome(ArrayList teste){
	      Collections.sort(teste, new Comparator() {
	            public int compare(Object o1, Object o2) {
	                Presidente p1 = (Presidente) o1;
	                Presidente p2 = (Presidente) o2;
	                return p1.nome.compareTo(p2.nome);
	            }
	        });
	}
	
}
//classe do Objeto
class Presidente {
    String nome; 
    int inicio; 
    int fim; 
    public Presidente(String n, int i, int f) {
        nome = n; inicio = i; fim = f;
    }
    public String toString() {
        return nome + ": de " + inicio + " até " + fim;
    }
}
