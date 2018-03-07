package interfaceSistema.Admin.AdmManagement;

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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class AdminInsert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private Sistema sistema = new Sistema();
	private JPasswordField novaSenha;
	private JPasswordField confirmacaoSenha;
	private JTextField nomeNewAdmin;
	private JTextField idNewAdmin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public AdminInsert(String id) {
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
		button.setBounds(492, 381, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminManagementOptions admOptions = new AdminManagementOptions(idAdmin);
				dispose();
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("ADMIN");
		lblInformaes.setBounds(387, 60, 109, 37);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblInformaes);

		JLabel lblNome = new JLabel("Senha:");
		lblNome.setBounds(183, 238, 48, 19);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNome.setForeground(Color.WHITE);
		desktopPane.add(lblNome);

		JLabel lblId = new JLabel("Repita a Senha:");
		lblId.setBounds(122, 273, 109, 19);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId);

		JButton btnAlterarSenha = new JButton("Inserir");
		btnAlterarSenha.setBounds(404, 309, 112, 27);
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newUserName = new String(nomeNewAdmin.getText().trim());
				String newIdAdmin = new String(idNewAdmin.getText().trim());

				String newPassword = new String(novaSenha.getPassword()).trim();
				String confirmationPassword = new String(confirmacaoSenha.getPassword()).trim();
				boolean has = false;

				try {
					has = sistema.hasIdAdmin(newIdAdmin);
					if (isEmpty(newUserName))
						JOptionPane.showMessageDialog(null, "Insira um Nome!");
					else if (isEmpty(newIdAdmin))
						JOptionPane.showMessageDialog(null, "Insira um ID!");
					else if (newIdAdmin.length() < 4) {
						JOptionPane.showMessageDialog(null, "Insira um ID de no mínimo 4 caracteres!");
						idNewAdmin.setText("");
					}

					else if (has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						idNewAdmin.setText("");
					}

					else if (isEmpty(newPassword) && isEmpty(confirmationPassword))
						JOptionPane.showMessageDialog(null, "Preencha os campos com a Senha!");
					else if (isEmpty(newPassword))
						JOptionPane.showMessageDialog(null, "Preencha o campo da  Senha!");
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
					} else {
						sistema.inserirAdmin(newUserName, newPassword, newIdAdmin);
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						AdminManagementOptions admMyInfo = new AdminManagementOptions(idAdmin);
						dispose();
						admMyInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						admMyInfo.setVisible(true);
						admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!");
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(248, 234, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(248, 269, 268, 28);
		desktopPane.add(confirmacaoSenha);

		JLabel lblNewLabel = new JLabel("*Mínimo 6 caracteres");
		lblNewLabel.setBounds(248, 303, 111, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setForeground(Color.WHITE);
		desktopPane.add(lblNewLabel);

		nomeNewAdmin = new JTextField();
		nomeNewAdmin.setBounds(248, 157, 268, 28);
		desktopPane.add(nomeNewAdmin);
		nomeNewAdmin.setColumns(10);

		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(183, 160, 44, 19);
		lblNome_1.setForeground(Color.WHITE);
		lblNome_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblNome_1);

		idNewAdmin = new JTextField();
		idNewAdmin.setBounds(248, 191, 268, 28);
		idNewAdmin.setColumns(10);
		desktopPane.add(idNewAdmin);

		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(208, 195, 18, 19);
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId_1);

		JLabel lblmnimoCaracteres = new JLabel("*Mínimo 4 caracteres");
		lblmnimoCaracteres.setBounds(248, 220, 112, 14);
		lblmnimoCaracteres.setForeground(Color.WHITE);
		lblmnimoCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 9));
		desktopPane.add(lblmnimoCaracteres);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}

}
