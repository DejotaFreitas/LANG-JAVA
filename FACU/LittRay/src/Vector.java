public interface Vector {
	void inserir(Object elemento,int pos);
	Object consultar(int pos);
	Object remover(int pos);
	Object trocarElemento(Object elemento, int pos);
	boolean isEmpty();
	int size();
}
