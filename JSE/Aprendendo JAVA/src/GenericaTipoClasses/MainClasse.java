package GenericaTipoClasses;

import java.util.ArrayList;

public class MainClasse {
	public static void main(String[] args) {
		
		//UMA MESMA CLASSE PODE CRIAR OBJETOS DE TIPOS DIFERENTES ESPECIFICADOS
		//e pode acessar os metodos do tipo de objeto criado
		
		GenericoClasse<String> gs = new GenericoClasse<>();
		gs.setElemento("Valor setado");
		System.out.println(gs.getElemento().toUpperCase());
		
		GenericoClasse<Integer> gi = new GenericoClasse<>();
		gi.setElemento(965);
		System.out.println(gi.getElemento());
						
	}
	
	
	
	//METODO COM PARAMETROS GENERICO QUE ESTEDEM DE ALGUM TIPO	
	// Posso colcar int, doubles, bytes e etc PQ EXTENDEM DA CLASSE Number
	public void metodoGenerico(ArrayList<? extends Number> aln){
		System.out.println(aln.toString());
		
	}
	
}
