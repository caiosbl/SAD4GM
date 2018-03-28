package interfaceSistema.Admin.UserManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */


public class UserInformation extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserInformation(String id, String idUsuario, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation,yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/voltabut.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformationEntry uInformation = new UserInformationEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				uInformation.setVisible(true);
				uInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(492, 388, 83, 23);
		desktopPane.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(sistema.getInfoUsuario(idUsuario));
		textPane.setBackground(SystemColor.textInactiveText);
		textPane.setBounds(116, 220, 394, 73);
		desktopPane.add(textPane);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/viewinformationuser.png")));
		label.setBounds(253, 20, 335, 90);
		desktopPane.add(label);
		
		JLabel informationback = new JLabel("");
		informationback.setIcon(new ImageIcon(UserInformation.class.getResource("/Resources/icon/informationback.png")));
		informationback.setBounds(99, 204, 426, 108);
		desktopPane.add(informationback);
	
	}
}
