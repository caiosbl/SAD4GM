package interfaceGrafica.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.usuario.entrada.Login;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.JButton;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7742771395792137094L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private static ServerSocket s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			s = new ServerSocket(9581);

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Main frame = new Main(100, 100);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A aplicação já está em execução!");
		}
	}

	/**
	 * Create the frame.
	 */
	public Main(int xLocation, int yLocation) {

		this.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM - DESIDES");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JButton button = new JButton("");
		button.setBackground(new Color(0, 0, 0,0));
		button.setSelectedIcon(new ImageIcon(Main.class.getResource("/Resources/icon/login-selected.png")));
		button.setIcon(new ImageIcon(Main.class.getResource("/Resources/icon/login-diselect.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login uOptions = new Login(getXLocation(), getYLocation());
				uOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				dispose();
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		button.setForeground(new Color(0, 0, 0,0));

		button.setBounds(221, 262, 153, 65);
		desktopPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/Resources/icon/sad4logo.png")));
		lblNewLabel.setBounds(154, 121, 265, 97);
		desktopPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/Resources/icon/desideslogobck.png")));
		lblNewLabel_2.setBounds(516, 0, 89, 69);
		desktopPane.add(lblNewLabel_2);

	}

	public int getXLocation() {
		return this.getLocationOnScreen().x;
	}

	public int getYLocation() {
		return this.getLocationOnScreen().y;
	}

	public boolean isEmpty(String string) {
		return string.equals("");
	}
}
