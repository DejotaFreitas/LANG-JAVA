package trabalho.pilhaAtendimentos;

public class No {
	private Atendimento atendimento;
	private No anterior;

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

}
