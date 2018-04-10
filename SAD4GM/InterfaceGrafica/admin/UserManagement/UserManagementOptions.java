package admin.UserManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Options;
import entrada.Entrada;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserManagementOptions extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserManagementOptions(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
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

		JButton insertUserButton = new JButton("");
		insertUserButton
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/insertUser.png")));
		insertUserButton.setBounds(0, 154, 249, 73);
		desktopPane.add(insertUserButton);
		insertUserButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton removeUserbutton = new JButton("");
		removeUserbutton
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/removeuser.png")));
		removeUserbutton.setBounds(0, 238, 249, 73);
		desktopPane.add(removeUserbutton);
		removeUserbutton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerMquinas = new JButton("");
		btnVerMquinas.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/setuser.png")));
		btnVerMquinas.setBounds(356, 154, 249, 73);
		desktopPane.add(btnVerMquinas);
		btnVerMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnListarUsurios = new JButton("");
		btnListarUsurios
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/listuser.png")));
		btnListarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UsersList uList = new UsersList(idAdmin,getXLocation(),getYLocation());

				dispose();
				uList.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uList.setVisible(true);
				uList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnListarUsurios.setBounds(356, 238, 249, 73);
		desktopPane.add(btnListarUsurios);
		btnListarUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerInformaesUsurio = new JButton("");
		btnVerInformaesUsurio
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/userinfo.png")));
		btnVerInformaesUsurio.setBounds(0, 321, 249, 73);
		btnVerInformaesUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformationEntry uInformation = new UserInformationEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				uInformation.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uInformation.setVisible(true);
				uInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVerInformaesUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVerInformaesUsurio);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/voltabut.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options admOptions = new Options(idAdmin,getXLocation(),getYLocation());

				dispose();
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(487, 394, 94, 37);
		desktopPane.add(button);

		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4logo);

		JLabel gerenciadorUsersBanner = new JLabel("");
		gerenciadorUsersBanner.setIcon(
				new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/gerenciadorusername.png")));
		gerenciadorUsersBanner.setBounds(258, 25, 318, 100);
		desktopPane.add(gerenciadorUsersBanner);
		btnVerMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserEntry setUser = new SetUserEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				setUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUser.setVisible(true);
				setUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		removeUserbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRemove userRemove = new UserRemove(idAdmin,getXLocation(),getYLocation());

				dispose();
				userRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				userRemove.setVisible(true);
				userRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		insertUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertUser admInsertUser = new InsertUser(idAdmin,getXLocation(),getYLocation());

				dispose();
				admInsertUser
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admInsertUser.setVisible(true);
				admInsertUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}

}
