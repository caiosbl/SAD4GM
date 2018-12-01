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
import interfaceGrafica.utils.EscalaSeveridade;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertEfeito extends Main {

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
	private JComboBox<Object> boxSeveridade;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public InsertEfeito(String id, int xLocation, int yLocation, int chaveModoFalha) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(InsertEfeito.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setBounds(514, 408, 78, 44);
		btnVoltar.setIcon(new ImageIcon(InsertEfeito.class.getResource("/Resources/icon/back-btn.png")));
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
		btnInserir
				.setSelectedIcon(new ImageIcon(InsertEfeito.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setBounds(56, 408, 103, 21);
		btnInserir.setIcon(new ImageIcon(InsertEfeito.class.getResource("/Resources/icon/patch/insert-off.png")));

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (!sistema.hasEfeito(chaveModoFalha)) {

						String descricao = new String(descricaoPane.getText().trim());
						String titulo = new String(tituloField.getText().trim());

						if (isEmpty(titulo))
							JOptionPane.showMessageDialog(null, "Título Inválido!");
						else if (isEmpty(descricao))
							JOptionPane.showMessageDialog(null, "Descrição Inválida!");

						else {
							double indiceSeveridade = boxSeveridade.getSelectedIndex() + 1;
							JOptionPane.showMessageDialog(null,
									sistema.inserirEfeito(titulo, descricao, indiceSeveridade, chaveModoFalha));
							ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
							dispose();
							insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
							insert.setVisible(true);
							insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

						}

					}

					else
						JOptionPane.showMessageDialog(null, "O Modo de Falha já possui um Efeito cadastrado!");

				}

				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

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

		JLabel lblModoDeFalha = new JLabel("EFEITO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(26, 49, 214, 29);
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

		JLabel lblIndceSeveridade = new JLabel("Indíce Severidade:");
		lblIndceSeveridade.setForeground(Color.WHITE);
		lblIndceSeveridade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceSeveridade.setBounds(229, 287, 152, 20);
		desktopPane.add(lblIndceSeveridade);

		Object[] escalaSeveridade = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };

		boxSeveridade = new JComboBox<Object>(escalaSeveridade);
		boxSeveridade.setBounds(50, 308, 508, 51);
		desktopPane.add(boxSeveridade);

		JButton btnEscala = new JButton("Ver Escala de Severidade");
		btnEscala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscalaSeveridade escala = new EscalaSeveridade();
				escala.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				escala.setVisible(true);
				escala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEscala.setBounds(389, 368, 169, 28);
		desktopPane.add(btnEscala);
	}
}
