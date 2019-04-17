package br.com.quicontrole.telas.componentes;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TabelaPersonalizada extends JTable{
	private static final long serialVersionUID = -2783337770373188862L;
	
	private TableModel modelo;
	public TabelaPersonalizada(TableModel modelo) {
		this.modelo = modelo;
		super.setModel(modelo);
		this.setOpaque(false);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
		this.getTableHeader().setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.setRowHeight(20);
		this.setDefaultRenderer(Object.class, new CellRenderer());
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//this.setRowSorter(new TableRowSorter<>(this.getModel()));
	}		

	
	@Override
	public boolean isCellEditable(int row, int col) {
        return false;
    }		
	public TableModel getModelo() {
		return modelo;
	}

	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}
	//centralizar linhas	
	public class CellRenderer extends DefaultTableCellRenderer {
		public CellRenderer() {
			super();
		}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			this.setHorizontalAlignment(CENTER);
			return super.getTableCellRendererComponent(table, value, isSelected,
					hasFocus, row, column);
		}
	}

}