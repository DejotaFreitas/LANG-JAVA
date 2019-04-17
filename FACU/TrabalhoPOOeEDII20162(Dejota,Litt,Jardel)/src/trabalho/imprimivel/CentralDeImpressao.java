package trabalho.imprimivel;

public class CentralDeImpressao {
	
	/**
	 * Invoca o metodo imprimir() de classe passada por parametro 
	 * que implemente a interface Imprimivel
	 * @param imprimivel
	 */
	public static void impimir(Imprimivel imprimivel){
		imprimivel.imprimir();
	}
	


}
