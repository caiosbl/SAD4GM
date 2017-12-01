package interfaceSistema.interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class Entrada {

	private JFrame frmSadgm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada window = new Entrada();
					window.frmSadgm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entrada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSadgm = new JFrame();
		frmSadgm.setTitle("SAD4GM");
		frmSadgm.setResizable(false);
		frmSadgm.setBounds(100, 100, 621, 497);
		frmSadgm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSadgm.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(0, 0, 605, 458);
		frmSadgm.getContentPane().add(desktopPane);

		JLabel label = new JLabel("Login:");
		label.setForeground(new Color(0, 0, 51));
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBackground(Color.WHITE);
		label.setBounds(234, 185, 99, 45);
		desktopPane.add(label);

		JButton button = new JButton("Usuário");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioLogin uOptions = new UsuarioLogin();
				desktopPane.removeAll();
				desktopPane.add(uOptions);
				uOptions.setPosicao();

				try {
					uOptions.setSelected(true);

				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uOptions.setVisible(true);
			

				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setForeground(new Color(0, 0, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(Color.WHITE);
		button.setBounds(104, 245, 161, 53);
		desktopPane.add(button);

		JButton button_1 = new JButton("Admin");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Admin");
			}
		});
		button_1.setForeground(new Color(0, 0, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(285, 245, 161, 53);
		desktopPane.add(button_1);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label_1.setBounds(214, 67, 141, 45);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setForeground(new Color(0, 0, 51));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_2.setBounds(190, 11, 210, 73);
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 582, 15);
		desktopPane.add(separator);
	}
}
