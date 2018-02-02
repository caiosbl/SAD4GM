package interfaceSistema.interfaceGrafica.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.interfaceGrafica.Entrada;
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
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserLogin extends JFrame {

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
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

		JLabel label = new JLabel("SAD4GM");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 37));
		label.setBounds(14, 13, 210, 73);
		desktopPane.add(label);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label_1.setBounds(24, 71, 141, 45);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("Usuário");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBackground(new Color(0, 0, 51));
		label_2.setBounds(461, 53, 118, 31);
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 15);
		desktopPane.add(separator);

		JLabel label_3 = new JLabel("LOGIN ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBackground(new Color(0, 0, 51));
		label_3.setBounds(264, 181, 90, 31);
		desktopPane.add(label_3);

		user = new JTextField();

		user.setColumns(10);
		user.setBackground(Color.WHITE);
		user.setBounds(226, 233, 180, 25);
		desktopPane.add(user);

		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setBounds(226, 269, 180, 25);
		desktopPane.add(password);

		JLabel label_4 = new JLabel("ID:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(182, 237, 46, 14);
		desktopPane.add(label_4);

		JLabel label_5 = new JLabel("SENHA:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(154, 273, 65, 14);
		desktopPane.add(label_5);

		JButton button = new JButton("Login");
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
					JOptionPane.showMessageDialog(null, "Usuário Iválido!");
					user.setText("");
					password.setText("");
				} else if (senha.length() < 6) {
					JOptionPane.showMessageDialog(null, "Senha Iválida!");
					user.setText("");
					password.setText("");
				}

				else {

					try {
						if (sistema.autenticaUsuario(id, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo " + sistema.getNomeUsuario(id) + "!");
							UserOptions uOptions = new UserOptions(id);
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
		button.setBounds(264, 305, 100, 38);
		desktopPane.add(button);

		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(479, 389, 100, 27);
		desktopPane.add(button_1);
	}

	private boolean isUserEmpty(String user) {
		return user.equals("");
	}

	private boolean isPasswordEmpty(String password) {
		return password.equals("");
	}
}
