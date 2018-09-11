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


import sistema.Sistema;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertUser extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private Sistema sistema = new Sistema();
	private JPasswordField novaSenha;
	private JPasswordField confirmacaoSenha;
	private JTextField userName;
	private JTextField auditorName;
	private JTextField newIdUser;
	private JToggleButton tglbtnAdmin;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public InsertUser(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
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

		JButton voltarButton = new JButton("");
		voltarButton.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/voltabut.png")));
		voltarButton.setBounds(492, 428, 84, 27);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admOptionsUser = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());
				dispose();
				admOptionsUser
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptionsUser.setVisible(true);
				admOptionsUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(voltarButton);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/insertbutton.png")));
		btnAlterarSenha.setBounds(433, 365, 112, 21);
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newUserName = new String(userName.getText().trim());
				String idUser = new String(newIdUser.getText().trim());
				String auditor = new String(auditorName.getText().trim());
				String newPassword = new String(novaSenha.getPassword()).trim();
				String confirmationPassword = new String(confirmacaoSenha.getPassword()).trim();

				boolean has = false;

				try {
					has = sistema.hasIdUsuario(idUser);
					if (isEmpty(newUserName))
						JOptionPane.showMessageDialog(null, "Insira um Nome!");
					else if (isEmpty(idUser))
						JOptionPane.showMessageDialog(null, "Insira um ID!");
					else if (isEmpty(auditor))
						JOptionPane.showMessageDialog(null, "Insira o nome do Auditor!");
					else if (idUser.length() < 4) {
						JOptionPane.showMessageDialog(null, "Insira um ID de no mínimo 4 caracteres!");
						newIdUser.setText("");
					}

					else if (has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						newIdUser.setText("");
					}

					else if (isEmpty(newPassword) && isEmpty(confirmationPassword))
						JOptionPane.showMessageDialog(null, "Preencha os campos com a Senha!");
					else if (isEmpty(newPassword))
						JOptionPane.showMessageDialog(null, "Preencha o campo da Senha!");
					else if (isEmpty(confirmationPassword))
						JOptionPane.showMessageDialog(null, "Preencha o campo de confirmação com a Senha!");
					else if (newPassword.length() < 6) {
						JOptionPane.showMessageDialog(null, "Digite uma senha de no mínimo 6 caracteres!");
						novaSenha.setText("");
						confirmacaoSenha.setText("");
					}

					else if (!newPassword.equals(confirmationPassword)) {
						JOptionPane.showMessageDialog(null,
								"As senhas diferem, por favor insira uma senha válida e a repita!");
						novaSenha.setText("");
						confirmacaoSenha.setText("");
					}

					else {
						boolean isAdmin = tglbtnAdmin.isSelected();
						sistema.cadastrarUsuario(newUserName, idUser, newPassword, auditor,isAdmin);
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						UserManagementOptions userOptions = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());
						dispose();
						userOptions.setIconImage(
								new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						userOptions.setVisible(true);
						userOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!");
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

		
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(110, 266, 435, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(110, 314, 435, 28);
		desktopPane.add(confirmacaoSenha);

		userName = new JTextField();
		userName.setBounds(110, 116, 435, 28);
		desktopPane.add(userName);
		userName.setColumns(10);

		auditorName = new JTextField();
		auditorName.setBounds(110, 210, 435, 28);
		auditorName.setColumns(10);
		desktopPane.add(auditorName);

		newIdUser = new JTextField();
		newIdUser.setBounds(110, 156, 435, 28);
		newIdUser.setColumns(10);
		desktopPane.add(newIdUser);
		
		tglbtnAdmin = new JToggleButton("");
		tglbtnAdmin.setBackground(new Color(0,0,0,0));
		desktopPane.setLayer(tglbtnAdmin, 0);
		tglbtnAdmin.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/toogle-off.png")));
		tglbtnAdmin.setSelectedIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/toogle-on.png")));
		tglbtnAdmin.setBounds(144, 353, 94, 52);
		desktopPane.add(tglbtnAdmin);
				
				JLabel title = new JLabel("INSERIR");
				title.setForeground(Color.WHITE);
				title.setFont(new Font("Tahoma", Font.BOLD, 24));
				title.setBounds(67, 22, 110, 29);
				desktopPane.add(title);
				
				JLabel lblUsurio = new JLabel("USUÁRIO");
				lblUsurio.setForeground(Color.WHITE);
				lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblUsurio.setBounds(67, 50, 114, 29);
				desktopPane.add(lblUsurio);
				
				JLabel lblNome = new JLabel("Nome:");
				lblNome.setForeground(Color.WHITE);
				lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNome.setBounds(44, 119, 54, 20);
				desktopPane.add(lblNome);
				
				JLabel lblId = new JLabel("ID:");
				lblId.setForeground(Color.WHITE);
				lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblId.setBounds(74, 160, 54, 20);
				desktopPane.add(lblId);
				
				JLabel lblmnimoCaracteres = new JLabel("*Mínimo 4 Caracteres");
				lblmnimoCaracteres.setForeground(Color.WHITE);
				lblmnimoCaracteres.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblmnimoCaracteres.setBounds(338, 187, 207, 20);
				desktopPane.add(lblmnimoCaracteres);
				
				JLabel lblAuditor = new JLabel("Auditor:");
				lblAuditor.setForeground(Color.WHITE);
				lblAuditor.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblAuditor.setBounds(34, 213, 84, 20);
				desktopPane.add(lblAuditor);
				
				JLabel lblSenha = new JLabel("Senha:");
				lblSenha.setForeground(Color.WHITE);
				lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSenha.setBounds(47, 269, 84, 20);
				desktopPane.add(lblSenha);
				
				JLabel lblRepitaASenha = new JLabel("Repita");
				lblRepitaASenha.setForeground(Color.WHITE);
				lblRepitaASenha.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblRepitaASenha.setBounds(44, 309, 54, 20);
				desktopPane.add(lblRepitaASenha);
				
				JLabel lblASenha = new JLabel("a Senha:");
				lblASenha.setForeground(Color.WHITE);
				lblASenha.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblASenha.setBounds(34, 323, 71, 20);
				desktopPane.add(lblASenha);
				
				JLabel lblAdministrador = new JLabel("Administrador:");
				lblAdministrador.setForeground(Color.WHITE);
				lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblAdministrador.setBounds(26, 365, 122, 20);
				desktopPane.add(lblAdministrador);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
