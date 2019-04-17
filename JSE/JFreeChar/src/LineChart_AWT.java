import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {
	private static final long serialVersionUID = -4243183311610374674L;

	public LineChart_AWT(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Years", "Number of Schools", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(15, "schools", "Janeiro");
		dataset.addValue(30, "schools", "Fervereiro");
		dataset.addValue(60, "schools", "Março");
		dataset.addValue(120, "schools", "Abril");
		dataset.addValue(240, "schools", "Maio");
		dataset.addValue(300, "schools", "Junho");
		dataset.addValue(15, "schools", "Julho");
		dataset.addValue(30, "schools", "Agosto");
		dataset.addValue(60, "schools", "Setembro");
		dataset.addValue(120, "schools", "Outubro");
		dataset.addValue(240, "schools", "Novembro");
		dataset.addValue(300, "schools", "Dezembro");
		
		return dataset;
	}

	public static void main(String[] args) {
		
		LineChart_AWT chart = new LineChart_AWT("School Vs Years", "Numer of Schools vs years");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}