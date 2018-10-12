package interfaceGrafica.admin.gerenciadorMaquinas.editMachines;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.admin.gerenciadorMaquinas.ViewMachinesEdit;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import sistema.Sistema;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField tituloField;
	@SuppressWarnings("rawtypes")
	private JComboBox boxOcorrencias;
	@SuppressWarnings("rawtypes")
	private JComboBox boxDeteccao;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SetModoFalha(String idUser, int xLocation, int yLocation, int chaveModoFalha) {
		super(xLocation, yLocation);
		this.idUsuario = idUser;

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
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setSelectedIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(521, 408, 78, 44);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(47, 170, 511, 116);
		desktopPane.add(jPane);

		JTextPane descricaoPane = new JTextPane();
		jPane.setViewportView(descricaoPane);
		descricaoPane.setText(sistema.getDescricaoModoFalha(chaveModoFalha));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesEdit editModoFalha = new ViewMachinesEdit(idUsuario, getXLocation(), getYLocation());
				dispose();
				editModoFalha.setVisible(true);
				editModoFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(idUser, getXLocation(), getYLocation());
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
				MyInfo myInfo = new MyInfo(idUser, getXLocation(), getYLocation());
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

		JButton btnAtualizar = new JButton("");
		btnAtualizar
				.setSelectedIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/update-selected.png")));
		btnAtualizar.setBackground(new Color(0, 0, 0, 0));
		btnAtualizar.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isEmpty(descricaoPane.getText().trim())) {
					descricaoPane.setText(sistema.getDescricaoModoFalha(chaveModoFalha));
					JOptionPane.showMessageDialog(null, "Descrição Inválida");
				} else if (isEmpty(tituloField.getText().trim())) {
					tituloField.setText(sistema.getNomeModoFalha(chaveModoFalha));
					JOptionPane.showMessageDialog(null, "Título Inválido");
				}

				else {

					JOptionPane.showMessageDialog(null,
							sistema.setNomeFalha(tituloField.getText().trim(), chaveModoFalha));
					
					JOptionPane.showMessageDialog(null,
							sistema.setDescricaoModoFalha(descricaoPane.getText().trim(), chaveModoFalha));

					JOptionPane.showMessageDialog(null,
							sistema.setIndiceOcorrencia(boxOcorrencias.getSelectedIndex() + 1, chaveModoFalha));

					JOptionPane.showMessageDialog(null,
							sistema.setIndiceDeteccao(boxDeteccao.getSelectedIndex() + 1, chaveModoFalha));

				}

			}

		});

		btnAtualizar.setBounds(37, 408, 124, 39);
		desktopPane.add(btnAtualizar);

		tituloField = new JTextField();
		tituloField.setText(sistema.getNomeModoFalha(chaveModoFalha));
		tituloField.setColumns(10);
		tituloField.setBounds(45, 110, 514, 34);
		desktopPane.add(tituloField);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEditar.setBounds(67, 22, 110, 29);
		desktopPane.add(lblEditar);

		JLabel lblModoDeFalha = new JLabel("MODO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(24, 47, 200, 29);
		desktopPane.add(lblModoDeFalha);

		JLabel label_1 = new JLabel("Título:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(269, 90, 54, 20);
		desktopPane.add(label_1);

		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescrio.setBounds(259, 150, 84, 20);
		desktopPane.add(lblDescrio);

		JLabel label_2 = new JLabel("Indíce Ocorrência:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(229, 287, 148, 20);
		desktopPane.add(label_2);

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

		int indiceOcorrencia = (int) sistema.getIndiceOcorrenciaModoFalha(chaveModoFalha);
		int indiceDeteccao = (int) sistema.getIndiceDeteccaosModoFalha(chaveModoFalha);

		JLabel lblIndceDeteco = new JLabel("Indíce Detecção:");
		lblIndceDeteco.setForeground(Color.WHITE);
		lblIndceDeteco.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceDeteco.setBounds(229, 341, 148, 20);
		desktopPane.add(lblIndceDeteco);

		boxDeteccao = new JComboBox(escalaDeteccao);
		boxDeteccao.setBounds(50, 362, 508, 34);
		desktopPane.add(boxDeteccao);
		if (indiceOcorrencia >= 1)
			boxOcorrencias.setSelectedIndex(indiceOcorrencia - 1);
		if (indiceDeteccao >= 1)
			boxDeteccao.setSelectedIndex(indiceOcorrencia - 1);

	}
}
