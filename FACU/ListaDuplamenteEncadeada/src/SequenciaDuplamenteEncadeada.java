


public class SequenciaDuplamenteEncadeada extends ListaDuplamenteEncadeada{
	
	public DNode atRank(int pos){
		if (checkRank(pos)) {
			if (pos < size() / 2) {
				DNode aux = getFirst();
				for (int i = 0; i < pos; i++) {
					aux = aux.getProx();
				}
				return aux;
			}else{
				DNode aux = getLast();
				for (int i = size() - 1; i > pos; i--) {
					aux = aux.getAnt();
				}
				return aux;
			}
		}else{
			System.out.println("Posi��o inv�lida");
			return new DNode(null, null, null);
		}		
	}
	
	public int rankOf(Object elem){
		int pos = 0;
		DNode aux = getFirst();
		while(aux != getLast().getProx()){
			if (elem.equals(aux.getElemento())) {
				return pos;
			}
			pos++;
			aux = aux.getProx();
		}
		return -1;
	}
	
	public boolean checkRank(int pos){
		return pos >= 0 && pos < size();
	}
	
}
