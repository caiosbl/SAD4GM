package interfaceSistema.interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1255872476730391091L;
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
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
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
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdmin.setBackground(new Color(0, 0, 51));
		lblAdmin.setBounds(461, 53, 118, 31);
		desktopPane.add(lblAdmin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 15);
		desktopPane.add(separator);
		
		JLabel label_3 = new JLabel("LOGIN ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBackground(new Color(0, 0, 51));
		label_3.setBounds(264, 181, 90, 31);
		desktopPane.add(label_3);
		
		textField = new JTextField();
		
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(226, 233, 180, 25);
		desktopPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(226, 269, 180, 25);
		desktopPane.add(passwordField);
		
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
						if (sistema.autenticaAdmin(id, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo " + sistema.getNomeAdmin(id) + "!");
							AdminOptions admOptions = new AdminOptions();
							dispose();
							admOptions.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "ID ou Senha Inválidos!");
							textField.setText("");
							passwordField.setText("");
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
	}
	private boolean isUserEmpty() {
		return textField.getText().equals("");
	}

	private boolean isPasswordEmpty() {
		return passwordField.getPassword().length == 0;
	}

}