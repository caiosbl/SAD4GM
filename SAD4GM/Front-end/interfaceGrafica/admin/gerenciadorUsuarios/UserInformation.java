package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import sistema.Sistema;

import javax.swing.JDesktopPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class UserInformation extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public UserInformation(String id, String idUsuario, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
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

		JButton button = new JButton("");
		button.setSelectedIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/return-selected.png")));
		button.setBackground(new Color(0, 0, 0, 0));
		button.setIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/back-btn.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformationEntry uInformation = new UserInformationEntry(idAdmin, getXLocation(), getYLocation());

				dispose();
				uInformation.setVisible(true);
				uInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(492, 388, 78, 44);
		desktopPane.add(button);

		JTextPane nomePane = new JTextPane();
		nomePane.setText(sistema.getNomeUsuario(idUsuario));
		nomePane.setEditable(false);
		nomePane.setBounds(49, 166, 513, 33);
		desktopPane.add(nomePane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(272, 146, 46, 17);
		desktopPane.add(lblNome);

		JTextPane idPane = new JTextPane();
		idPane.setText(idUsuario);
		idPane.setEditable(false);
		idPane.setBounds(49, 229, 513, 33);
		desktopPane.add(idPane);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(284, 210, 22, 17);
		desktopPane.add(lblId);

		JTextPane auditorPane = new JTextPane();
		auditorPane.setText(sistema.getNomeAuditor(idUsuario));
		auditorPane.setEditable(false);
		auditorPane.setBounds(49, 289, 513, 33);
		desktopPane.add(auditorPane);

		JLabel lblAuditor = new JLabel("Auditor:");
		lblAuditor.setForeground(Color.WHITE);
		lblAuditor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuditor.setBounds(272, 271, 57, 17);
		desktopPane.add(lblAuditor);

		JLabel label_1 = new JLabel("VISUALIZAR");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(67, 22, 151, 29);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("USUÁRIO");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_2.setBounds(88, 48, 114, 29);
		desktopPane.add(label_2);

		String statusUsuario;
		try {
			statusUsuario = getSituacaoUsuario(idUsuario);
		} catch (SQLException e1) {
			statusUsuario = "";
		}

		JTextPane statusUsuarioPane = new JTextPane();
		statusUsuarioPane.setText(statusUsuario);
		statusUsuarioPane.setEditable(false);
		statusUsuarioPane.setBounds(49, 345, 513, 33);
		desktopPane.add(statusUsuarioPane);

		JLabel lblSituao = new JLabel("Situação:");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSituao.setBounds(270, 327, 64, 17);
		desktopPane.add(lblSituao);

	}

	public String getSituacaoUsuario(String idUsuario) throws SQLException {
		boolean situacaoUser = sistema.isUsuarioAtivo(idUsuario);

		if (situacaoUser)
			return "Ativo";
		else
			return "Inativo";
	}
}
