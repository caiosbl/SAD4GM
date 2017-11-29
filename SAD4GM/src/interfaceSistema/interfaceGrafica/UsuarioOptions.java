package interfaceSistema.interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UsuarioOptions extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(106, 179, 394, 2);
		contentPane.add(separator);

		JLabel lblSadgm = new JLabel("SAD4GM");
		lblSadgm.setForeground(new Color(0, 0, 139));
		lblSadgm.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblSadgm.setBounds(219, 11, 180, 67);
		contentPane.add(lblSadgm);

		textField = new JTextField();
		textField.setBounds(231, 192, 180, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(187, 196, 46, 14);
		contentPane.add(lblId);

		passwordField = new JPasswordField();
		passwordField.setBounds(231, 228, 180, 25);
		contentPane.add(passwordField);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(159, 232, 65, 14);
		contentPane.add(lblSenha);

		JLabel lblUsurio = new JLabel("USUÁRIO\r\n");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsurio.setBounds(236, 130, 157, 53);
		contentPane.add(lblUsurio);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null,checkUsuarioSenhaPreenchidos());
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 255));
		
		
		
	
		
		
		
		

		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(273, 264, 100, 38);
		contentPane.add(btnLogin);
	}
	
	private String checkUsuarioSenhaPreenchidos() {
		String mensagem = "";
		
		if(textField.getText().equals(""))
			mensagem += "Preencha o Campo Usuário";
		if(passwordField.getPassword().length == 0)
			mensagem += " e o  Campo Senha";
		
		return mensagem;
	}
}
