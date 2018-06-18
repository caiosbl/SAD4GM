package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import sistema.Sistema;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

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
		btnAlterarSenha.setBounds(380, 364, 112, 21);
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
						sistema.cadastrarUsuario(newUserName, idUser, newPassword, auditor);
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
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(224, 284, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(224, 324, 268, 28);
		desktopPane.add(confirmacaoSenha);

		userName = new JTextField();
		userName.setBounds(224, 175, 268, 28);
		desktopPane.add(userName);
		userName.setColumns(10);

		auditorName = new JTextField();
		auditorName.setBounds(224, 249, 268, 28);
		auditorName.setColumns(10);
		desktopPane.add(auditorName);

		newIdUser = new JTextField();
		newIdUser.setBounds(224, 207, 268, 28);
		newIdUser.setColumns(10);
		desktopPane.add(newIdUser);

		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4logo);

		JLabel insertUser = new JLabel("");
		insertUser.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/insertUserBanner.png")));
		insertUser.setBounds(328, 25, 201, 94);
		desktopPane.add(insertUser);
		
		JToggleButton tglbtnAdmin = new JToggleButton("");
		desktopPane.setLayer(tglbtnAdmin, 0);
		tglbtnAdmin.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/off.png")));
		tglbtnAdmin.setSelectedIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/on-button.png")));
		tglbtnAdmin.setBounds(224, 376, 32, 20);
		desktopPane.add(tglbtnAdmin);
		
				JLabel formUser = new JLabel("");
				formUser.setIcon(new ImageIcon(InsertUser.class.getResource("/Resources/icon/forminsertuser.png")));
				formUser.setBounds(95, 145, 434, 270);
				desktopPane.add(formUser);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
