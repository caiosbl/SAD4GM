package interfaceSistema.interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrada extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
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
	public Entrada() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovoUsurio = new JButton("Novo Usuário");
		btnNovoUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame myFrame = new JFrame();
			}
		});
		btnNovoUsurio.setBounds(303, 253, 112, 35);
		contentPane.add(btnNovoUsurio);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(221, 216, 194, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsurio = new JLabel("Senha:");
		lblUsurio.setBounds(143, 217, 68, 14);
		contentPane.add(lblUsurio);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel label = new JLabel("Usuário:");
		label.setBounds(143, 192, 68, 14);
		contentPane.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setBounds(221, 191, 194, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(246, 141, 64, 23);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(143, 176, 272, 5);
		contentPane.add(separator);
		
		JLabel lblSadgm = new JLabel("SAD4GM");
		lblSadgm.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblSadgm.setBounds(205, 28, 161, 45);
		contentPane.add(lblSadgm);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(143, 253, 112, 35);
		contentPane.add(btnEntrar);
	}
}
