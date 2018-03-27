package interfaceSistema.User;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1255872476730391091L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private Sistema sistema = new Sistema();

	
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(100, 100, 621, 497);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/usuarioareaicon.png")));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBackground(new Color(0, 0, 51));
		label_2.setBounds(393, 11, 202, 117);
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 15);
		desktopPane.add(separator);

		user = new JTextField();

		user.setColumns(10);
		user.setBackground(Color.WHITE);
		user.setBounds(226, 233, 180, 25);
		desktopPane.add(user);

		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setBounds(226, 269, 180, 25);
		desktopPane.add(password);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/loginbutton.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = user.getText().trim();
				String senha = new String(password.getPassword()).trim();
				if (isUserEmpty(id) && isPasswordEmpty(senha))
					JOptionPane.showMessageDialog(null, "Preencha os Campos ID e Senha!");
				else if (isUserEmpty(id))
					JOptionPane.showMessageDialog(null, "Preencha o Campo ID!");
				else if (isPasswordEmpty(senha))
					JOptionPane.showMessageDialog(null, "Preencha o Campo Senha!");
				else if (id.length() < 4) {
					JOptionPane.showMessageDialog(null, "Usuário Inválido!");
					user.setText("");
					password.setText("");
				} else if (senha.length() < 6) {
					JOptionPane.showMessageDialog(null, "Senha Inválida!");
					user.setText("");
					password.setText("");
				}

				else {

					try {
						if (sistema.autenticaUsuario(id, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo " + sistema.getNomeUsuario(id) + "!");
							Options uOptions = new Options(id);
							dispose();
							uOptions.setVisible(true);
							uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						} else {
							JOptionPane.showMessageDialog(null, "ID ou Senha Inválidos!");
							user.setText("");
							password.setText("");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

					}

				}

			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(Color.WHITE);
		button.setBounds(336, 306, 70, 25);
		desktopPane.add(button);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(489, 389, 90, 27);
		desktopPane.add(btnVoltar);
		
		JLabel loginFormBack = new JLabel("");
		loginFormBack.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/loginformback.png")));
		loginFormBack.setBounds(135, 176, 313, 180);
		desktopPane.add(loginFormBack);
		
		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4logo);
	}

	private boolean isUserEmpty(String user) {
		return user.equals("");
	}

	private boolean isPasswordEmpty(String password) {
		return password.equals("");
	}
}
