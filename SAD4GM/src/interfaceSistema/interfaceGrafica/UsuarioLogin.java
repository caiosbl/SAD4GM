package interfaceSistema.interfaceGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioLogin extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioLogin frame = new UsuarioLogin();
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
	public UsuarioLogin() {
		setBorder(null);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("SAD4GM");
		label.setBounds(214, 26, 210, 73);
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 37));
		contentPane.add(label);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(236, 76, 141, 45);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 136, 582, 15);
		contentPane.add(separator);

		JLabel label_2 = new JLabel("Usuário");
		label_2.setBounds(474, 78, 118, 31);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBackground(new Color(0, 0, 51));
		contentPane.add(label_2);

		textField = new JTextField();
		textField.setBounds(226, 232, 180, 25);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isUserEmpty() && isPasswordEmpty())
					JOptionPane.showMessageDialog(null, "Preencha os Campos ID e Senha!");
				else if (isUserEmpty())
					JOptionPane.showMessageDialog(null, "Preencha o Campo ID!");
				else if (isPasswordEmpty())
					JOptionPane.showMessageDialog(null, "Preencha o Campo Senha!");

				else {

					String id = textField.getText();
					String senha = String.valueOf(passwordField.getPassword());

					try {
						if (sistema.autenticaUsuario(id, senha)) {
							JOptionPane.showMessageDialog(null, "Login Aceito");
						} else
							JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

					}

				}

			}
		});
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		contentPane.add(textField);

		JLabel label_3 = new JLabel("LOGIN ");
		label_3.setBounds(264, 180, 90, 31);
		label_3.setForeground(new Color(0, 0, 51));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBackground(new Color(0, 0, 51));
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("ID:");
		label_4.setBounds(182, 236, 46, 14);
		label_4.setForeground(new Color(0, 0, 51));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("SENHA:");
		label_5.setBounds(154, 272, 65, 14);
		label_5.setForeground(new Color(0, 0, 51));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(label_5);

		passwordField = new JPasswordField();
		passwordField.setBounds(226, 268, 180, 25);
		passwordField.setBackground(Color.WHITE);
		contentPane.add(passwordField);

		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isUserEmpty() && isPasswordEmpty())
					JOptionPane.showMessageDialog(null, "Preencha os Campos ID e Senha!");
				else if (isUserEmpty())
					JOptionPane.showMessageDialog(null, "Preencha o Campo ID!");
				else if (isPasswordEmpty())
					JOptionPane.showMessageDialog(null, "Preencha o Campo Senha!");

				else {

					String id = textField.getText();
					String senha = String.valueOf(passwordField.getPassword());

					try {
						if (sistema.autenticaUsuario(id, senha)) {
							JOptionPane.showMessageDialog(null, "Login Aceito");
						} else
							JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

					}

				}

			}
		});
		button.setBounds(264, 304, 100, 38);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(Color.WHITE);
		contentPane.add(button);

	}

	private boolean isUserEmpty() {
		return textField.getText().equals("");
	}

	private boolean isPasswordEmpty() {
		return passwordField.getPassword().length == 0;
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

}
