package interfaceSistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Admin.AdminLogin;
import interfaceSistema.User.UserLogin;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Canvas;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Entrada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7742771395792137094L;
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
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblEscolhaSeuTipo = new JLabel("LOGIN:");
		lblEscolhaSeuTipo.setForeground(SystemColor.inactiveCaptionBorder);
		lblEscolhaSeuTipo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEscolhaSeuTipo.setBackground(new Color(255, 255, 255));
		lblEscolhaSeuTipo.setBounds(257, 223, 67, 22);
		desktopPane.add(lblEscolhaSeuTipo);

		JButton button = new JButton("Usuário");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogin uOptions = new UserLogin();
				dispose();
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setForeground(new Color(0, 0, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(210, 322, 161, 53);
		desktopPane.add(button);

		JButton button_1 = new JButton("Admin");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin admLogin = new AdminLogin();
				dispose();
				admLogin.setVisible(true);
				admLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setForeground(new Color(0, 0, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(210, 257, 161, 53);
		desktopPane.add(button_1);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setForeground(SystemColor.inactiveCaptionBorder);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label_1.setBounds(281, 65, 141, 45);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setForeground(SystemColor.inactiveCaptionBorder);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		label_2.setBounds(235, 25, 218, 61);
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 582, 15);
		desktopPane.add(separator);
		
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\caiol\\\\Desktop\\\\SAD4GM\\\\SAD4GM\\\\SAD4GM\\\\icon\\\\desides.png");
		int largura = img.getIconWidth();
        int altura = img.getIconHeight();
        JLabel labelimg = new JLabel(img);
        labelimg.setLocation(51, 37);
        labelimg.setSize(119, 61);
        desktopPane.add(labelimg,RIGHT_ALIGNMENT);
	
		
	}
}
