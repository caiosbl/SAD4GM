package interfaceSistema.Admin;

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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class AdminLogin extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1255872476730391091L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AdminLogin(int xLocation,int yLocation) {
		super(xLocation,yLocation);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

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
		button.setIcon(new ImageIcon(AdminLogin.class.getResource("/Resources/icon/loginbutton.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String id = user.getText().trim();
				String senha = new String(password.getPassword());
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

						if (sistema.autenticaAdmin(id, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo " + sistema.getNomeAdmin(id) + "!");
							Options admOptions = new Options(id,getXLocation(),getYLocation());

							dispose();
							admOptions.setIconImage(
									new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
							admOptions.setVisible(true);
							admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(AdminLogin.class.getResource("/Resources/icon/voltabut.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrada entrada = new Entrada(getXLocation(),getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(479, 389, 93, 34);
		desktopPane.add(button_1);

		JLabel adminAreaIcon = new JLabel("");
		adminAreaIcon.setIcon(new ImageIcon(AdminLogin.class.getResource("/Resources/icon/adminareaicon.png")));
		adminAreaIcon.setBounds(408, 8, 177, 126);
		desktopPane.add(adminAreaIcon);

		JLabel sad4gmIcon = new JLabel("");
		sad4gmIcon.setIcon(new ImageIcon(AdminLogin.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4gmIcon.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4gmIcon);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/Resources/icon/loginformback.png")));
		label.setBounds(135, 176, 313, 180);
		desktopPane.add(label);
	}

	private boolean isUserEmpty(String user) {
		return user.equals("");
	}

	private boolean isPasswordEmpty(String password) {
		return password.equals("");
	}
}
