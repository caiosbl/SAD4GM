package interfaceSistema.Admin.UserManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetUserPassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idUser;
	private Sistema sistema = new Sistema();
	private JPasswordField novaSenha;
	private JPasswordField confirmacaoSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetUserPassword(String id, String idUsuario) {
		this.idAdmin = id;
		this.idUser = idUsuario;
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton voltarButton = new JButton("");
		voltarButton.setIcon(new ImageIcon(SetUserPassword.class.getResource("/Resources/icon/voltabut.png")));
		voltarButton.setBounds(479, 381, 97, 27);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUser setUser = new SetUser(idAdmin, idUser);
				dispose();
				setUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUser.setVisible(true);
				setUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(voltarButton);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha
				.setIcon(new ImageIcon(SetUserPassword.class.getResource("/Resources/icon/setPasswordbutton.png")));
		btnAlterarSenha.setBounds(406, 268, 106, 23);
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newPassword = new String(novaSenha.getPassword()).trim();
				String confirmationPassword = new String(confirmacaoSenha.getPassword()).trim();

				if (isEmpty(newPassword) && isEmpty(confirmationPassword))
					JOptionPane.showMessageDialog(null, "Preencha os campos com a Nova Senha!");
				else if (isEmpty(newPassword))
					JOptionPane.showMessageDialog(null, "Preencha o campo da Nova Senha!");
				else if (isEmpty(confirmationPassword))
					JOptionPane.showMessageDialog(null, "Preencha o campo de confirmação com a Nova Senha!");
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
					sistema.setSenhaUsuario(idUser, newPassword);
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
					SetUser setUsuario = new SetUser(idAdmin, idUsuario);
					dispose();
					setUsuario
							.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
					setUsuario.setVisible(true);
					setUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(248, 193, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(248, 228, 268, 28);
		desktopPane.add(confirmacaoSenha);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(SetUserPassword.class.getResource("/Resources/icon/setsenhaform.png")));
		form.setBounds(66, 148, 470, 171);
		desktopPane.add(form);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetUserPassword.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetUserPassword.class.getResource("/Resources/icon/alterarsenhausuario1.png")));
		banner.setBounds(264, 38, 292, 76);
		desktopPane.add(banner);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}

}
