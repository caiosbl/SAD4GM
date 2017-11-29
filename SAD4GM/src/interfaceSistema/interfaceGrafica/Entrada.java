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
		
		JButton btnNovoUsurio = new JButton("Admin");
		btnNovoUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame myFrame = new JFrame();
			}
		});
		btnNovoUsurio.setBounds(205, 247, 161, 53);
		contentPane.add(btnNovoUsurio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(143, 176, 272, 5);
		contentPane.add(separator);
		
		JLabel lblSadgm = new JLabel("SAD4GM");
		lblSadgm.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblSadgm.setBounds(205, 71, 161, 45);
		contentPane.add(lblSadgm);
		
		JButton btnEntrar = new JButton("Usuário");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(205, 183, 161, 53);
		contentPane.add(btnEntrar);
	}
}
