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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.Panel;

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
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovoUsurio = new JButton("Admin");
		btnNovoUsurio.setForeground(new Color(0, 0, 51));
		btnNovoUsurio.setBackground(Color.WHITE);
		btnNovoUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Admin");
			}
		});
		
		JLabel lblBemVindo = new JLabel("Login:");
		lblBemVindo.setForeground(new Color(0, 0, 51));
		lblBemVindo.setBackground(Color.WHITE);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBemVindo.setBounds(247, 157, 99, 45);
		contentPane.add(lblBemVindo);
		btnNovoUsurio.setBounds(298, 217, 161, 53);
		contentPane.add(btnNovoUsurio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 95, 582, 15);
		contentPane.add(separator);
		
		JLabel lblSadgm = new JLabel("SAD4GM");
		lblSadgm.setForeground(new Color(0, 0, 51));
		lblSadgm.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblSadgm.setBounds(213, 0, 210, 73);
		contentPane.add(lblSadgm);
		
		JButton btnEntrar = new JButton("Usuário");
		btnEntrar.setForeground(new Color(0, 0, 51));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UsuarioOptions uOptions = new UsuarioOptions();
				 dispose();
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(117, 217, 161, 53);
		contentPane.add(btnEntrar);
		
		JLabel lblDesi = new JLabel("DeSiDeS");
		lblDesi.setForeground(Color.BLACK);
		lblDesi.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblDesi.setBounds(235, 50, 141, 45);
		contentPane.add(lblDesi);
	}
}
