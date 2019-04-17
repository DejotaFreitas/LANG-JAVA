package br.com.quicontrole.telas.componentes;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboPopup;

import br.com.quicontrole.entidades.Fornecedor;

public class CaixaCombo extends JComboBox<Object>{
	private static final long serialVersionUID = 6154421748657797383L;

	public CaixaCombo(List<Object> lista) {		
		//this.setEditable(true);
		this.setOpaque(false);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE,16));
		this.setBackground(Cor.AZUL_FUNDO);
		this.setPrototypeDisplayValue("12345678901");

		Object child = this.getAccessibleContext().getAccessibleChild(0);
		BasicComboPopup popup = (BasicComboPopup)child;
		JList<?> list = popup.getList();
		list.setSelectionBackground(Color.WHITE);
		
		if(lista!=null)
		for (Object o : lista) {
			this.addItem(o);
		}
		
		

	}
	
	public void getFornecedor(int id){
		Fornecedor fornecedor;
        for (int i = 0; i < this.getItemCount(); i++){
        	fornecedor = (Fornecedor) this.getItemAt(i);
            if (fornecedor.getId_fornecedor() == id){
            	this.setSelectedIndex(i);
                break;
            }
        }        
    }
	
	
	

}
