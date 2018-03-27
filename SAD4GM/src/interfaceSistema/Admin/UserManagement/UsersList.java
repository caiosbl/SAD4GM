package interfaceSistema.Admin.UserManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextPane;

import javax.swing.JScrollPane;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UsersList extends JFrame {

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
	public UsersList(String id) {
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 130, 582, 12);
		desktopPane.add(separator);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(UsersList.class.getResource("/Resources/icon/voltabut.png")));
		button.setBounds(489, 388, 86, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions uMOptions = new UserManagementOptions(idAdmin);

				dispose();
				uMOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uMOptions.setVisible(true);
				uMOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.activeCaption);
		textPane.setEditable(false);
		JScrollPane jsp = new JScrollPane(textPane);
		jsp.setBounds(84, 150, 345, 261);
		textPane.setText(sistema.listarUsuarios());
		desktopPane.add(jsp);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 40, 205, 74);
		logo.setIcon(new ImageIcon(UsersList.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(logo);
		
		JLabel listback = new JLabel("");
		listback.setBounds(77, 137, 366, 289);
		listback.setIcon(new ImageIcon(UsersList.class.getResource("/Resources/icon/backlist.png")));
		desktopPane.add(listback);
		
		JLabel usersListBanner = new JLabel("");
		usersListBanner.setIcon(new ImageIcon(UsersList.class.getResource("/Resources/icon/userslist.png")));
		usersListBanner.setBounds(245, 19, 326, 96);
		desktopPane.add(usersListBanner);

	}
}
