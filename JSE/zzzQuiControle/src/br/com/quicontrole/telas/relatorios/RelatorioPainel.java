package br.com.quicontrole.telas.relatorios;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.quicontrole.dao.RelatorioDAO;
import br.com.quicontrole.entidades.Tranzacao;
import br.com.quicontrole.telas.Janela;
import br.com.quicontrole.telas.componentes.Botao;
import br.com.quicontrole.telas.componentes.CaixaCombo;
import br.com.quicontrole.telas.componentes.Data;

@SuppressWarnings("serial")
public class RelatorioPainel extends ChartPanel implements ActionListener {

	private Botao pesquisar;
	private ArrayList<Object> tipoPesquisaLista;
	private CaixaCombo anos;

	private static JFreeChart lineChart = ChartFactory.createLineChart("Fluxo de Caixa Mensal", "Mês", "Valor",
			createDataset(), PlotOrientation.VERTICAL, true, true, false);

	public RelatorioPainel() {
		super(lineChart);
		lineChart = ChartFactory.createLineChart("Fluxo de Caixa Mensal", "Mês", "Valor", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		setChart(lineChart);

		pesquisar = new Botao("Pesquisa");
		pesquisar.addActionListener(this);
		tipoPesquisaLista = new RelatorioDAO().listaAnosComboBox();
		anos = new CaixaCombo(tipoPesquisaLista);
		setLayout(new GridBagLayout());
		Janela.addComponente(0, 0, 1, 1, 0, 0, this, anos, 0, 0, 0, 0);
		Janela.addComponente(0, 1, 1, 1, 0, 0, this, pesquisar, 0, 0, 0, 0);
		Janela.addComponente(0, 2, 1, 1, 1, 0, this, new JLabel(), 0, 0, 0, 0);
		Janela.addComponente(1, 0, 1, 1, 0, 1, this, new JLabel(), 0, 0, 0, 0);

	}

	private static DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Data d = new Data();
		ArrayList<Tranzacao> vendas = new RelatorioDAO().listarValorVendaTotalMensal(d.getAno());
		ArrayList<Tranzacao> compras = new RelatorioDAO().listarValorCompraTotalMensal(d.getAno());

		addDataset(dataset, "Lucro", Lucro(vendas, compras));
		addDataset(dataset, "Venda", vendas);
		addDataset(dataset, "Compra", compras);

		return dataset;
	}

	private static void addDataset(DefaultCategoryDataset dataset, String tipo, ArrayList<Tranzacao> list) {
		for (Tranzacao t : list) {
			dataset.addValue(t.getTotal(), tipo, mesPorEstenso(t.getMes()));
		}
	}

	private static String mesPorEstenso(String mes) {
		switch (mes) {
		case "01":
			return "Janeiro";
		case "02":
			return "Fervereiro";
		case "03":
			return "Março";
		case "04":
			return "Abril";
		case "05":
			return "Maio";
		case "06":
			return "Junho";
		case "07":
			return "Julho";
		case "08":
			return "Agosto";
		case "09":
			return "Setembro";
		case "10":
			return "Outubro";
		case "11":
			return "Novembro";
		case "12":
			return "Dezembro";
		default:
			return "";
		}
	}

	private static ArrayList<Tranzacao> Lucro(ArrayList<Tranzacao> vendas, ArrayList<Tranzacao> compras) {
		ArrayList<Tranzacao> lucro = new ArrayList<Tranzacao>();
		for (Tranzacao t : vendas) {
			Tranzacao temp = new Tranzacao();
			temp.setTotal(t.getTotal());
			temp.setMes(t.getMes());
			temp.setAno(t.getAno());
			lucro.add(temp);
		}
		boolean achei = false;
		for (Tranzacao t : compras) {
			achei = false;
			for (Tranzacao t2 : lucro) {
				if (t2.getMes().equals(t.getMes())) {
					t2.setTotal(t2.getTotal().subtract(t.getTotal()));
					achei = true;
					break;
				}
			}

			if (achei == false) {
				lucro.add(t);
			}

		}
		return lucro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pesquisar) {

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			ArrayList<Tranzacao> vendas = new RelatorioDAO()
					.listarValorVendaTotalMensal((String) anos.getSelectedItem());
			ArrayList<Tranzacao> compras = new RelatorioDAO()
					.listarValorCompraTotalMensal((String) anos.getSelectedItem());
			addDataset(dataset, "Lucro", Lucro(vendas, compras));
			addDataset(dataset, "Venda", vendas);
			addDataset(dataset, "Compra", compras);

			JFreeChart lineChart2 = ChartFactory.createLineChart("Fluxo de Caixa Mensal", "Mês", "Valor", dataset,
					PlotOrientation.VERTICAL, true, true, false);

			this.setChart(lineChart2);
			this.repaint();
		}

	}

}