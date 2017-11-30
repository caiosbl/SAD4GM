package interfaceSistema.interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UsuarioOptions extends JFrame {

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
					UsuarioOptions frame = new UsuarioOptions();
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
	public UsuarioOptions() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(226, 198, 180, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 0, 51));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(182, 202, 46, 14);
		contentPane.add(lblId);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(226, 234, 180, 25);
		contentPane.add(passwordField);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(new Color(0, 0, 51));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(154, 238, 65, 14);
		contentPane.add(lblSenha);

		JLabel lblUsurio = new JLabel("LOGIN ");
		lblUsurio.setBackground(new Color(0, 0, 51));
		lblUsurio.setForeground(new Color(0, 0, 51));
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsurio.setBounds(264, 146, 90, 31);
		contentPane.add(lblUsurio);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
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
						if(sistema.autenticaUsuario(id, senha))
							JOptionPane.showMessageDialog(null, "Login Aceito");
						else
							JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
						
					} 

				}

			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);

		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(264, 270, 100, 38);
		contentPane.add(btnLogin);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 102, 582, 15);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("DeSiDeS");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(222, 57, 141, 45);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("SAD4GM");
		label_1.setForeground(new Color(0, 0, 51));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_1.setBounds(200, 7, 210, 73);
		contentPane.add(label_1);
		
		JLabel lblUsurio_1 = new JLabel("Usuário");
		lblUsurio_1.setForeground(new Color(0, 0, 0));
		lblUsurio_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsurio_1.setBackground(new Color(0, 0, 51));
		lblUsurio_1.setBounds(474, 44, 118, 31);
		contentPane.add(lblUsurio_1);
	}

	private boolean isUserEmpty() {
		return textField.getText().equals("");
	}

	private boolean isPasswordEmpty() {
		return passwordField.getPassword().length == 0;
	}
}
