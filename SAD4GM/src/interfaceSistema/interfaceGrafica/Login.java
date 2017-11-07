package interfaceSistema.interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtSadm;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem menuItem;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSadm = new JTextField();
		txtSadm.setBounds(10, 11, 587, 99);
		txtSadm.setForeground(new Color(255, 255, 255));
		txtSadm.setBackground(new Color(0, 0, 102));
		txtSadm.setFont(new Font("Tahoma", Font.PLAIN, 62));
		txtSadm.setText("        SAD4GM");
		contentPane.add(txtSadm);
		txtSadm.setColumns(10);
		
		mntmNewMenuItem = new JMenuItem("Login");
		mntmNewMenuItem.setFont(new Font("Verdana", Font.BOLD, 16));
		mntmNewMenuItem.setArmed(true);
		mntmNewMenuItem.setBackground(new Color(0, 0, 102));
		mntmNewMenuItem.setBounds(59, 358, 231, 28);
		contentPane.add(mntmNewMenuItem);
		
		menuItem = new JMenuItem("Cadastrar Usu\u00E1rio");
		menuItem.setFont(new Font("Verdana", Font.BOLD, 16));
		menuItem.setBackground(new Color(0, 0, 102));
		menuItem.setArmed(true);
		menuItem.setBounds(295, 358, 231, 28);
		contentPane.add(menuItem);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 134, 465, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(67, 105, 66, 25);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 77, 213, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Usu\u00E1rio");
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		label.setBounds(67, 74, 66, 25);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 108, 213, 20);
		panel.add(textField_1);
	}
}
