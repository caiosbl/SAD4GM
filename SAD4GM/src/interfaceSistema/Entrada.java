package interfaceSistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Admin.AdminLogin;
import interfaceSistema.User.Login;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;


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
					Entrada frame = new Entrada();
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
	public Entrada() {
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
		setBounds(100, 100, 621, 497);

		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblEscolhaSeuTipo = new JLabel("");
		lblEscolhaSeuTipo.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/entrarcomobutton.png")));
		lblEscolhaSeuTipo.setForeground(SystemColor.inactiveCaptionBorder);
		lblEscolhaSeuTipo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEscolhaSeuTipo.setBackground(new Color(255, 255, 255));
		lblEscolhaSeuTipo.setBounds(180, 199, 227, 34);
		desktopPane.add(lblEscolhaSeuTipo);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/usuariobutton.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login uOptions = new Login();
				dispose();
				uOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setForeground(new Color(0, 0, 51));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(295, 266, 124, 53);
		desktopPane.add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/adminbutton.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin admLogin = new AdminLogin();
				dispose();
				admLogin.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admLogin.setVisible(true);
				admLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setForeground(new Color(0, 0, 51));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(158, 266, 130, 53);
		desktopPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/sad4logo.png")));
		lblNewLabel.setBounds(153, 42, 265, 97);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/loginback.png")));
		lblNewLabel_1.setBounds(139, 245, 309, 97);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Entrada.class.getResource("/Resources/icon/desideslogo.png")));
		lblNewLabel_2.setBounds(496, 22, 76, 55);
		desktopPane.add(lblNewLabel_2);
	
		
	}
}
