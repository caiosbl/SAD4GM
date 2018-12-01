package interfaceGrafica.utils;

import java.awt.BorderLayout;

import javax.management.RuntimeErrorException;
import javax.swing.JDialog;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.ValueAxis;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import sistema.Sistema;

import java.sql.SQLException;
import java.util.Map;

import javax.swing.JOptionPane;

import javax.swing.UIManager;

public class PlotGraficoXY extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final Sistema sistema;
	private int chaveMaquina;

	public PlotGraficoXY(int chaveMaquina) {
		setResizable(false);
		this.sistema = new Sistema();
		this.chaveMaquina = chaveMaquina;

		setTitle("Matriz de Risco - SAD4GM");

		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		XYDataset dataset;
		try {
			dataset = createDataset();
			JFreeChart chart = createChart(dataset);

			// based on the dataset we create the chart

			// we put the chart into a panel
			ChartPanel chartPanel = new ChartPanel(chart);
			// default size
			chartPanel.setBounds(0, 0, 894, 471);

			contentPanel.add(chartPanel);
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
		}

	}

	/**
	 * Creates a sample dataset
	 * 
	 * @throws SQLException
	 */
	private XYDataset createDataset() throws SQLException {
		final XYSeriesCollection dataset = new XYSeriesCollection();

		try {
			Map<String, Integer> mapaModosFalhas = sistema.getMapaModosFalhaPorMaquina(chaveMaquina);

			for (String nomeModoFalha : mapaModosFalhas.keySet()) {
				int chaveModoFalha = mapaModosFalhas.get(nomeModoFalha);
				double indiceOcorrencia = sistema.getIndiceOcorrenciaModoFalha(chaveModoFalha);
				double indiceSeveridade = sistema.getIndiceSeveridadePorFalha(chaveModoFalha);
				XYSeries modoFalha = new XYSeries(nomeModoFalha);
				modoFalha.add(indiceSeveridade, indiceOcorrencia);
				dataset.addSeries(modoFalha);
			}
		} catch (Exception e) {
			throw new RuntimeErrorException(null, "Falha na Conexão com o Banco de Dados!");
		}
		return dataset;
	}

	/**
	 * Creates a chart
	 */
	public JFreeChart createChart(XYDataset dataset) {

		final JFreeChart chart = ChartFactory.createXYLineChart("Matriz de Risco", // chart title
				"Severidade", // domain axis label
				"Ocorrência", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, false);

		final XYPlot plot = chart.getXYPlot();

		final ValueAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLowerMargin(0.02);
		domainAxis.setUpperMargin(0.02);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		plot.setRenderer(renderer);

		return chart;

	}
}
