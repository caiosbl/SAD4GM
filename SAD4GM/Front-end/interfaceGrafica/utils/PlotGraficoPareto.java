package interfaceGrafica.utils;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.management.RuntimeErrorException;
import javax.swing.JDialog;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import org.jfree.util.SortOrder;

import sistema.Sistema;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JOptionPane;

import javax.swing.UIManager;

public class PlotGraficoPareto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final Sistema sistema;
	private int chaveMaquina;

	public PlotGraficoPareto(int chaveMaquina) {
		setResizable(false);
		this.sistema = new Sistema();
		this.chaveMaquina = chaveMaquina;

		setTitle("Gráfico Pareto - SAD4GM");

		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Object[] data;
		CategoryDataset dataset;
		KeyedValues cumulative;

		try {
			data = createDataset();
			dataset = (CategoryDataset) data[0];
			cumulative = (KeyedValues) data[1];
			JFreeChart chart = createChart(dataset, cumulative);

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
	private Object[] createDataset() throws SQLException {
		final DefaultKeyedValues data = new DefaultKeyedValues();

		try {
			Map<String, Integer> mapaModosFalhas = sistema.getMapaModosFalhaPorMaquina(chaveMaquina);

			for (String nomeModoFalha : mapaModosFalhas.keySet()) {
				int chaveModoFalha = mapaModosFalhas.get(nomeModoFalha);
				double indiceOcorrencia = sistema.getIndiceOcorrenciaModoFalha(chaveModoFalha);
				double indiceSeveridade = sistema.getIndiceSeveridadePorFalha(chaveModoFalha);

				Integer rpn = (int) (indiceOcorrencia * indiceSeveridade);
				data.addValue(nomeModoFalha, rpn);

			}
		} catch (Exception e) {
			throw new RuntimeErrorException(null, "Falha na Conexão com o Banco de Dados!");
		}

		data.sortByValues(SortOrder.DESCENDING);
		final KeyedValues cumulative = DataUtilities.getCumulativePercentages(data);
		final CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Modos de Falha", data);

		return new Object[] { dataset, cumulative };
	}

	/**
	 * Creates a chart
	 */
	public JFreeChart createChart(CategoryDataset dataset, KeyedValues cumulative) {

		final JFreeChart chart = ChartFactory.createBarChart("Análise de Criticidade de Modos de Falha", // chart title
				"Legenda", // domain axis label
				"RPN", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, false);

		
		chart.setBackgroundPaint(new Color(0xBBBBDD));

		
		final CategoryPlot plot = chart.getCategoryPlot();
		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLowerMargin(0.01);
		domainAxis.setUpperMargin(0.01);
		

	
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
		

		final CategoryDataset dataset2 = DatasetUtilities.createCategoryDataset("Acumulativo", cumulative);
		final NumberAxis axis2 = new NumberAxis("Porcentagem");
		axis2.setNumberFormatOverride(NumberFormat.getPercentInstance());
		plot.setRangeAxis(1, axis2);
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		plot.mapDatasetToRangeAxis(1, 1);
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
	
		return chart;

	}
}
