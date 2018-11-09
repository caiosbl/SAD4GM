package interfaceGrafica.utils;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class RankingRPN extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("unused")
	private final Sistema sistema;
	private JTable table;
	private TabelaModelo modelo;

	public RankingRPN(int chaveMaquina) {
		setResizable(false);
		this.sistema = new Sistema();

		setTitle("Classificação de Modos de Falha por RPN - SAD4GM");

		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		try {

			table = createJTable(chaveMaquina);

			table.setBackground(SystemColor.inactiveCaptionBorder);
			table.setShowVerticalLines(true);
			table.setShowHorizontalLines(true);
			table.setShowGrid(false);
			table.setEnabled(false);
			table.setRowSelectionAllowed(false);
			table.setShowGrid(true);
			JScrollPane jsp = new JScrollPane(table);
			jsp.setEnabled(false);
			jsp.setBounds(0, 44, 894, 427);
			contentPanel.add(jsp);
			
			JLabel lblClassificaoDeModos = new JLabel("CLASSIFICAÇÃO DE MODOS DE FALHA POR NÚMERO DE PRIORIDADE DE RISCO");
			lblClassificaoDeModos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblClassificaoDeModos.setBounds(106, 11, 651, 20);
			contentPanel.add(lblClassificaoDeModos);
		}

		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
		}

	}

	public JTable createJTable(int chaveMaquina) throws SQLException {
		ArrayList<String[]> dados = new ArrayList<String[]>();
		Sistema sistema = new Sistema();
		String[] colunas = new String[] { "Modo de Falha", "Indíce de Ocorrência", "Indíce de Severidade", "RPN" };
		// Alimenta as linhas de dados

		try {

			Map<String, Integer> mapaModosFalhas = sistema.getMapaModosFalhaPorMaquina(chaveMaquina);

			Object[] keys = mapaModosFalhas.keySet().toArray();

			Arrays.sort(keys, new Comparator<Object>() {
				@Override
				public int compare(Object b1, Object b2) {

					try {
						int rpn1 = (int) (sistema.getIndiceOcorrenciaModoFalha(mapaModosFalhas.get(b1))
								* sistema.getIndiceSeveridadePorFalha(mapaModosFalhas.get(b1)));
						int rpn2 = (int) (sistema.getIndiceOcorrenciaModoFalha(mapaModosFalhas.get(b2))
								* sistema.getIndiceSeveridadePorFalha(mapaModosFalhas.get(b2)));
						return rpn2 - rpn1;
					}

					catch (Exception e) {
						return 0;
					}

				}
			});

			for (Object nomeModoFalha : keys) {
				int chaveModoFalha = mapaModosFalhas.get(nomeModoFalha);

				Double indiceOcorrencia = sistema.getIndiceOcorrenciaModoFalha(chaveModoFalha);
				Double indiceSeveridade = sistema.getIndiceSeveridadePorFalha(chaveModoFalha);
				Double rpn = indiceOcorrencia * indiceSeveridade;

				String[] data = { String.valueOf(nomeModoFalha), String.valueOf(indiceOcorrencia),
						String.valueOf(indiceSeveridade), String.valueOf(rpn) };
				dados.add(data);
			}

		}

		catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

		modelo = new TabelaModelo(dados, colunas);
		table = new JTable(modelo);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(476);
		table.getColumnModel().getColumn(0).setCellRenderer(new TextTableRenderer());
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setCellRenderer(new TextTableRenderer());
		table.setShowGrid(true);
		table.setRowHeight(80);

		// jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return table;
	}
}
