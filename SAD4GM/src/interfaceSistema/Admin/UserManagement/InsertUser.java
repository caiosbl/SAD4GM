package interfaceSistema.Admin.UserManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
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
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertUser extends JFrame {

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

	public InsertUser(String id) {
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(43, 62, 120, 34);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(21, 17, 161, 45);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JLabel lblGerenciarUsurios = new JLabel("INSERIR");
		lblGerenciarUsurios.setBounds(377, 24, 139, 37);
		lblGerenciarUsurios.setForeground(Color.WHITE);
		lblGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblGerenciarUsurios);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 107, 593, 12);
		desktopPane.add(separator);

		JButton button = new JButton("Voltar");
		button.setBounds(495, 418, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admOptionsUser = new UserManagementOptions(idAdmin);
				dispose();
				admOptionsUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptionsUser.setVisible(true);
				admOptionsUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("USUÁRIO");
		lblInformaes.setBounds(377, 60, 144, 37);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblInformaes);

		JLabel lblNome = new JLabel("Senha:");
		lblNome.setBounds(183, 270, 48, 19);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNome.setForeground(Color.WHITE);
		desktopPane.add(lblNome);

		JLabel lblId = new JLabel("Repita a Senha:");
		lblId.setBounds(122, 310, 109, 19);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId);

		JButton btnAlterarSenha = new JButton("Inserir");
		btnAlterarSenha.setBounds(407, 346, 112, 27);
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
						UserManagementOptions userOptions = new UserManagementOptions(idAdmin);
						dispose();
						userOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
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
		novaSenha.setBounds(251, 266, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(251, 306, 268, 28);
		desktopPane.add(confirmacaoSenha);

		JLabel lblNewLabel = new JLabel("*Mínimo 6 Caracteres");
		lblNewLabel.setBounds(251, 340, 111, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setForeground(Color.WHITE);
		desktopPane.add(lblNewLabel);

		userName = new JTextField();
		userName.setBounds(251, 157, 268, 28);
		desktopPane.add(userName);
		userName.setColumns(10);

		JLabel nome = new JLabel("Nome:");
		nome.setBounds(183, 160, 44, 19);
		nome.setForeground(Color.WHITE);
		nome.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(nome);

		auditorName = new JTextField();
		auditorName.setBounds(251, 231, 268, 28);
		auditorName.setColumns(10);
		desktopPane.add(auditorName);

		JLabel auditor = new JLabel("Auditor:");
		auditor.setBounds(175, 236, 66, 19);
		auditor.setForeground(Color.WHITE);
		auditor.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(auditor);

		JLabel lblmnimoCaracteres = new JLabel("*Mínimo 4 caracteres");
		lblmnimoCaracteres.setBounds(426, 215, 112, 14);
		lblmnimoCaracteres.setForeground(Color.WHITE);
		lblmnimoCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 9));
		desktopPane.add(lblmnimoCaracteres);

		newIdUser = new JTextField();
		newIdUser.setBounds(251, 189, 268, 28);
		newIdUser.setColumns(10);
		desktopPane.add(newIdUser);

		JLabel idUsuario = new JLabel("ID:");
		idUsuario.setBounds(210, 192, 44, 19);
		idUsuario.setForeground(Color.WHITE);
		idUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(idUsuario);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}

	
}
