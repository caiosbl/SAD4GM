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
import interfaceGrafica.utils.EscalaSeveridade;

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
public class SetEfeito extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField tituloField;
	@SuppressWarnings("rawtypes")
	private JComboBox boxSeveridade;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SetEfeito(String idUser, int xLocation, int yLocation, int chaveEfeito) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(SetEfeito.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(SetEfeito.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(521, 408, 78, 44);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(47, 170, 511, 116);
		desktopPane.add(jPane);

		JTextPane descricaoPane = new JTextPane();
		jPane.setViewportView(descricaoPane);
		descricaoPane.setText(sistema.getDescricaoEfeito(chaveEfeito));
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
		btnAtualizar.setSelectedIcon(new ImageIcon(SetEfeito.class.getResource("/Resources/icon/update-selected.png")));
		btnAtualizar.setBackground(new Color(0, 0, 0, 0));
		btnAtualizar.setIcon(new ImageIcon(SetEfeito.class.getResource("/Resources/icon/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isEmpty(descricaoPane.getText().trim())) {
					descricaoPane.setText(sistema.getDescricaoModoFalha(chaveEfeito));
					JOptionPane.showMessageDialog(null, "Descrição Inválida");
				} else if (isEmpty(tituloField.getText().trim())) {
					tituloField.setText(sistema.getNomeModoFalha(chaveEfeito));
					JOptionPane.showMessageDialog(null, "Título Inválido");
				}

				else {

					JOptionPane.showMessageDialog(null,
							sistema.setNomeEfeito(tituloField.getText().trim(), chaveEfeito));

					JOptionPane.showMessageDialog(null,
							sistema.setDescricaoEfeito(descricaoPane.getText().trim(), chaveEfeito));

					JOptionPane.showMessageDialog(null,
							sistema.setIndiceSeveridade(boxSeveridade.getSelectedIndex() + 1, chaveEfeito));

				}

			}

		});

		btnAtualizar.setBounds(37, 408, 124, 39);
		desktopPane.add(btnAtualizar);

		tituloField = new JTextField();
		tituloField.setText(sistema.getNomeEfeito(chaveEfeito));
		tituloField.setColumns(10);
		tituloField.setBounds(45, 110, 514, 34);
		desktopPane.add(tituloField);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEditar.setBounds(67, 22, 110, 29);
		desktopPane.add(lblEditar);

		JLabel lblModoDeFalha = new JLabel("EFEITO");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(68, 47, 89, 29);
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

		JLabel lblIndceSeveridade = new JLabel("Indíce Severidade:");
		lblIndceSeveridade.setForeground(Color.WHITE);
		lblIndceSeveridade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceSeveridade.setBounds(229, 287, 152, 20);
		desktopPane.add(lblIndceSeveridade);

		Object[] escalaSeveridade = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		boxSeveridade = new JComboBox(escalaSeveridade);
		boxSeveridade.setBounds(50, 308, 508, 51);
		desktopPane.add(boxSeveridade);
		
		JButton btnEscalaSeveridade = new JButton("Ver Escala de Severidade");
		btnEscalaSeveridade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscalaSeveridade escala = new EscalaSeveridade();
				escala.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				escala.setVisible(true);
				escala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEscalaSeveridade.setBounds(389, 368, 169, 28);
		desktopPane.add(btnEscalaSeveridade);

		int indiceSeveridade = (int) sistema.getIndiceSeveridade(chaveEfeito);
		if (indiceSeveridade >= 1)
			boxSeveridade.setSelectedIndex(indiceSeveridade - 1);

	}
}
