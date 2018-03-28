package interfaceSistema.Admin.AdmManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;

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
public class AdminInsert extends Entrada {

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

	public AdminInsert(String id, int xLocation, int yLocation) {
		super(xLocation,yLocation);
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
		voltarButton.setIcon(new ImageIcon(AdminInsert.class.getResource("/Resources/icon/voltabut.png")));
		voltarButton.setBounds(477, 405, 93, 34);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminManagementOptions admOptions = new AdminManagementOptions(idAdmin,getXLocation(),getYLocation());
				dispose();
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(voltarButton);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(AdminInsert.class.getResource("/Resources/icon/insertbutton.png")));
		btnAlterarSenha.setBounds(387, 343, 109, 23);
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
						AdminManagementOptions admMyInfo = new AdminManagementOptions(idAdmin,getXLocation(),getYLocation());
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
		novaSenha.setBounds(237, 269, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(237, 303, 268, 28);
		desktopPane.add(confirmacaoSenha);

		JLabel lblNewLabel = new JLabel("*Mínimo 6 caracteres");
		lblNewLabel.setBounds(248, 303, 111, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setForeground(Color.WHITE);
		desktopPane.add(lblNewLabel);

		nomeNewAdmin = new JTextField();
		nomeNewAdmin.setBounds(237, 189, 268, 28);
		desktopPane.add(nomeNewAdmin);
		nomeNewAdmin.setColumns(10);

		idNewAdmin = new JTextField();
		idNewAdmin.setBounds(237, 224, 268, 28);
		idNewAdmin.setColumns(10);
		desktopPane.add(idNewAdmin);
		
		JLabel formBackground = new JLabel("");
		formBackground.setIcon(new ImageIcon(AdminInsert.class.getResource("/Resources/icon/insertadminback.png")));
		formBackground.setBounds(101, 161, 418, 230);
		desktopPane.add(formBackground);
		
		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(AdminInsert.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4logo);
		
		JLabel insertAdminBanner = new JLabel("");
		insertAdminBanner.setIcon(new ImageIcon(AdminInsert.class.getResource("/Resources/icon/inseriradminback.png")));
		insertAdminBanner.setBounds(248, 28, 339, 86);
		desktopPane.add(insertAdminBanner);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
