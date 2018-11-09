package interfaceGrafica.utils;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.JTable;

import javax.swing.JLabel;
import java.awt.Font;

public class EscalaSeveridade extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	public EscalaSeveridade() {

		setTitle("Escala de Severidade de Efeitos - SAD4GM");

		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Object[][] linhas = { { 1, "Efeito não percebido pelo Cliente." },
				{ 2, "Efeito bastante insignificante, percebido pelo cliente; entretanto, não faz com que o cliente busque o serviço." },
				{ 3, "Efeito insignificante, que pertuba o cliente, mas não faz com que procure o serviço." },
				{ 4, "Efeito bastante insignificante, mas pertuba o cliente, fazendo com que procure o serviço." },
				{ 5, "Efeito menor, incoveniente para o cliente; entretanto, não faz com que o cliente procure o serviço." },
				{ 6, "Efeito menor, incoveniente para o cliente, fazendo com que o cliente procure o serviço." },
				{ 7, "Efeito moderado, que prejudica o desempenho do projeto levando a uma falha grave ou a uma falha que pode impedir a execução das funções do projeto." },
				{ 8, "Efeito significativo, resultando em falha grave; entretanto,  não coloca a segurança do cliente em risco e não resulta em custo significativo da falha." },
				{ 9, "Efeito crítico que provoca a insatisfação do cliente, interrompe as funções do projeto, gera custo significativo da falha e impõe um leve risco de segurança (não ameaça a vida nem provoca incapacidade permanente) ao cliente." },
				{ 10, "Perigoso, ameaça a vida ou pode provocar a incapacidade permanente ou outro custo significativo da falha que coloca em risco a continuidade operacional da organização." } };
		
		Object[] nomesColunas = { "Indíce" + "", "Descrição" };

		table = new JTable(linhas, nomesColunas);
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setShowGrid(false);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(476);
		table.getColumnModel().getColumn(1).setCellRenderer(new TextTableRenderer());
		table.setShowGrid(true);
		table.setRowHeight(80);

		JScrollPane jsp = new JScrollPane(table);
		jsp.setEnabled(false);
		jsp.setBounds(6, 51, 472, 378);
		contentPanel.add(jsp);

		JLabel lblEscalaDeSeveridade = new JLabel("ESCALA DE SEVERIDADE DE EFEITOS");
		lblEscalaDeSeveridade.setForeground(SystemColor.desktop);
		lblEscalaDeSeveridade.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEscalaDeSeveridade.setBounds(83, 20, 314, 21);
		contentPanel.add(lblEscalaDeSeveridade);
	}
}
