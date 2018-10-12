package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextPane descricaoPane;
	private Sistema sistema;
	private JTextField tituloField;
	private JLabel title;
	@SuppressWarnings("rawtypes")
	private JComboBox boxOcorrencias;
	@SuppressWarnings("rawtypes")
	private JComboBox boxDeteccao;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InsertModoFalha(String id, int xLocation, int yLocation, int chaveFalha) {
		super(xLocation, yLocation);
		sistema = new Sistema();
		this.idUsuario = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(
				new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setBounds(514, 408, 78, 44);
		btnVoltar.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insert.setVisible(true);
				insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setSelectedIcon(
				new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setBounds(56, 408, 103, 21);
		btnInserir.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/patch/insert-off.png")));

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String descricao = new String(descricaoPane.getText().trim());
				String titulo = new String(tituloField.getText().trim());

				if (isEmpty(titulo))
					JOptionPane.showMessageDialog(null, "Título Inválido!");
				else if (isEmpty(descricao))
					JOptionPane.showMessageDialog(null, "Descrição Inválida!");

				else {
					double indiceOcorrencia = boxOcorrencias.getSelectedIndex() + 1;
					double indiceDeteccao = boxDeteccao.getSelectedIndex() + 1;
					JOptionPane.showMessageDialog(null,
							sistema.inserirModoFalha(titulo, descricao, chaveFalha, indiceOcorrencia, indiceDeteccao));

				}

			}
		});

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		homeBtn.setSelectedIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);

		JButton myDataBtn = new JButton("");
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);

		JButton logoutBtn = new JButton("");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		logoutBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(47, 170, 511, 116);
		desktopPane.add(jsp);

		descricaoPane = new JTextPane();
		jsp.setViewportView(descricaoPane);
		descricaoPane.setEditable(true);

		tituloField = new JTextField();
		tituloField.setBounds(45, 110, 514, 34);
		desktopPane.add(tituloField);
		tituloField.setColumns(10);

		title = new JLabel("INSERIR");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(67, 22, 110, 29);
		desktopPane.add(title);

		JLabel lblModoDeFalha = new JLabel("MODO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(35, 51, 200, 29);
		desktopPane.add(lblModoDeFalha);

		JLabel lblTtulo = new JLabel("Título:");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTtulo.setBounds(267, 90, 54, 20);
		desktopPane.add(lblTtulo);

		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescrio.setBounds(257, 150, 84, 20);
		desktopPane.add(lblDescrio);

		JLabel lblIndceOcorrncia = new JLabel("Indíce Ocorrência:");
		lblIndceOcorrncia.setForeground(Color.WHITE);
		lblIndceOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceOcorrncia.setBounds(229, 287, 148, 20);
		desktopPane.add(lblIndceOcorrncia);

		String[] escalaOcorrencias = { "1 - Extremamente remoto, altamente improvável", "2 - Remoto, improvável",
				"3 - Pequena chance de ocorrências", "4 - Pequeno número de ocorrências",
				"5 - Espera-se um número ocasional de falhas", "6 - Ocorrência moderada", "7 - Ocorrência frequente",
				"8 - Ocorrência elevada", "9 - Ocorrência muito elevada", "10 -Ocorrência certa" };

		String[] escalaDeteccao = { "1 - É quase certo que será detectado", "2 - Probabilidade muito alta de detecção",
				"3 - Alta probabilidade de detecção", "4 - Chance moderada de detecção", "5 - Chance média de detecção",
				"6 - Alguma probabilidade de detecção", "7 - Baixa probabilidade  de detecção",
				"8 - Probabilidade muito baixa de detecção", "9 - Probabilidade remota de detecção",
				"10 - Detecção quase impossível" };

		boxOcorrencias = new JComboBox(escalaOcorrencias);
		boxOcorrencias.setBounds(50, 308, 508, 34);
		desktopPane.add(boxOcorrencias);

		JLabel lblIndceDeteco = new JLabel("Indíce Detecção:");
		lblIndceDeteco.setForeground(Color.WHITE);
		lblIndceDeteco.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceDeteco.setBounds(229, 341, 148, 20);
		desktopPane.add(lblIndceDeteco);

		boxDeteccao = new JComboBox(escalaDeteccao);
		boxDeteccao.setBounds(50, 362, 508, 34);
		desktopPane.add(boxDeteccao);
	}
}
