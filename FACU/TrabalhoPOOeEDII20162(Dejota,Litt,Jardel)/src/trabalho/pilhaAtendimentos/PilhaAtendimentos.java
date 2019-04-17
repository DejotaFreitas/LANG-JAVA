package trabalho.pilhaAtendimentos;

import trabalho.imprimivel.Imprimivel;

public class PilhaAtendimentos implements Imprimivel {
	
	private No topo;

	public void add(Atendimento atendimento) {
		No novo = new No();
		novo.setAtendimento(atendimento);
		novo.setAnterior(topo);
		topo = novo;
	}
	
	public void clean(Atendimento atendimento) {
		topo = null;
	}

	public void imprimir() {
		if (topo != null) {
			No aux = topo;
			while (aux != null) {
				System.out.println(aux.getAtendimento());
				aux = aux.getAnterior();
			}
		} else {
			System.out.println("Relatório de atendimentos vazio.");
		}
	}

}
