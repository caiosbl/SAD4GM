package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import sistema.Sistema;
import java.awt.Color;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetUser extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idUser;
	private Sistema sistema = new Sistema();
	private JLabel title;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetUser(String id, String idUser, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.idUser = idUser;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation,yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton voltarBtn = new JButton("");
		voltarBtn.setSelectedIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/return-selected.png")));
		voltarBtn.setBackground(new Color(0,0,0,0));
		voltarBtn.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/back-btn.png")));
		voltarBtn.setBounds(521, 396, 78, 44);
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserEntry setUserEntry = new SetUserEntry(idAdmin,getXLocation(),getYLocation());
				dispose();
				setUserEntry.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUserEntry.setVisible(true);
				setUserEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		voltarBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(voltarBtn);

		JTextPane nome = new JTextPane();

		nome.setBounds(58, 167, 498, 35);
		nome.setText(sistema.getNomeUsuario(this.idUser));
		desktopPane.add(nome);

		JTextPane userID = new JTextPane();

		userID.setBounds(58, 226, 498, 35);
		userID.setText(idUser);
		desktopPane.add(userID);

		JTextPane auditor = new JTextPane();
		auditor.setText(sistema.getNomeAuditor(this.idUser));
		auditor.setBounds(58, 294, 498, 35);
		desktopPane.add(auditor);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setSelectedIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/set-senha-on.png")));
		btnAlterarSenha.setBackground(new Color(0,0,0,0));
		btnAlterarSenha.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/set-senha.png")));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserPassword setUserPassword = new SetUserPassword(idAdmin, idUser,getXLocation(),getYLocation());
				dispose();
				setUserPassword.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUserPassword.setVisible(true);
				setUserPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAlterarSenha.setBounds(6, 396, 144, 39);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setSelectedIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/update-selected.png")));
		btnAtualizar.setBackground(new Color(0,0,0,0));
		btnAtualizar.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasIdUsuario(userID.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (auditor.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Auditor inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (userID.getText().equals("") || userID.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "ID inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (!userID.getText().trim().equals(idUser) && has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					}

					else {
						nome.setEditable(false);
						userID.setEditable(false);
						sistema.setIdUsuario(idUser, userID.getText().trim());
						sistema.setNomeUsuario(nome.getText().trim(), idUser);
						sistema.setAuditorUsuario(idUser, auditor.getText().trim());
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(452, 340, 124, 39);
		desktopPane.add(btnAtualizar);
		
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
		
		title = new JLabel("EDITAR");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(67, 22, 93, 29);
		desktopPane.add(title);
		
		JLabel label_1 = new JLabel("USUÁRIO");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(58, 47, 114, 29);
		desktopPane.add(label_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(271, 147, 46, 17);
		desktopPane.add(lblNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(284, 210, 22, 17);
		desktopPane.add(lblId);
		
		JLabel lblAuditor = new JLabel("Auditor:");
		lblAuditor.setForeground(Color.WHITE);
		lblAuditor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuditor.setBounds(271, 276, 57, 17);
		desktopPane.add(lblAuditor);

	}
}
