package trabalho;

import javax.swing.JOptionPane;

import trabalho.filaDePrioridades.FilaDePrioridades;
import trabalho.imprimivel.CentralDeImpressao;
import trabalho.operacoes.CaixaNormal;
import trabalho.operacoes.CaixaRapido;
import trabalho.operacoes.Furao;
import trabalho.operacoes.Gestante;
import trabalho.operacoes.Idoso;
import trabalho.operacoes.Operacao;

public class Principal {

	public static void main(String[] args) {
		FilaDePrioridades fila = new FilaDePrioridades();
		boolean loop = true;
		String[] opcoes1 = {"Enfileirar","Desinfileirar","Imprimir","Relatório de Atendimentos"
							,"Relatório de Multas","Sair"};
		String[] opcoes2 = {"Gestante","Idoso","Cx. Rápido","Cx. Normal","Furão"};
	
		while (loop) {
			try {
				
				
				int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu Principal",
						JOptionPane.YES_NO_OPTION, 3, null, opcoes1, 0);
				
			switch (opcao) {			
			case 0:
				int submenu = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu Enfileirar",
						JOptionPane.YES_NO_OPTION, 3, null, opcoes2, 1);
					
				Operacao operacao = pegarInstancia(submenu);
				if(operacao != null){
					fila.enfilheirar(operacao);
				}
				break;
			case 1:
				try {
					//removendo o primeiro da filha e mostrando mensagem de quem foi removido
					showBoxMsg(fila.desinfileirar().getDono()+" Foi removido da Fila");
				} catch (Exception e) {
					//tratando erro de remover de uma fila vazia
					showBoxMsg("Não é possivel remover de uma fila vazia.");
				}
				
				break;
			case 2:
				//imprimir fila
				CentralDeImpressao.impimir(fila);
				System.out.println();
				break;
			case 3:
				//Imprimir pilha de pessoas que ja foram atendidas
				fila.relatorioDeAtendimentos();
				System.out.println();
				break;
			case 4:
				//imprimir relatorio de multas
				fila.relatorioDeMultas();
				System.out.println();
				break;
			case 5:
				loop = false;
				break;
				
			default:
				showBoxMsg("Insira um número correpondete a uma das opções do menu.");
				break;
			}
						
			} catch (Exception e) {
				showBoxMsg("Ocorreu algum erro, tente novamente.");
			}	
		}
		//fim do  loop
	}
	

	//mostra caixa de texto com mensagem
	public static void showBoxMsg(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	//recebe um inteiro e retorna uma instancia correspondente a um dos filhos de Operacao
	public static Operacao pegarInstancia(int tipo){
		Operacao operacao = null;
		if (tipo >= 0 && tipo <=4) {
			String nome = JOptionPane.showInputDialog("Insira o nome da cliente.");
			if ("".equals(nome)) {
				showBoxMsg("Insira o nome da cilente.");
				return pegarInstancia(tipo);				
			} else if (nome==null){
				return null;
			} else if (tipo == 0) {
				operacao = new Gestante(nome);
			} else if(tipo == 1){
				operacao = new Idoso(nome);
			} else if(tipo == 2){
				operacao = new CaixaRapido(nome);
			} else if(tipo == 3){
				operacao = new CaixaNormal(nome);
			} else if (tipo == 4){
				operacao = new Furao(nome);
			}
			return operacao;
		} else {
			return null;
		}
		
	}
	
	
	
}
