package admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.AdmManagement.AdminManagementOptions;
import admin.MachineManagement.MachineManagementOptions;
import admin.UserManagement.UserManagementOptions;
import entrada.Entrada;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Options extends Entrada {

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
	public Options(String id,int xLocation,int yLocation) {
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

		JButton btnGerenciarUsurios = new JButton("");
		btnGerenciarUsurios.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/usermanager.png")));
		btnGerenciarUsurios.setBounds(214, 207, 169, 88);
		btnGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerenciarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admUserOptions = new UserManagementOptions(idAdmin, getXLocation(),getYLocation());
				dispose();
				admUserOptions
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admUserOptions.setVisible(true);
				admUserOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		desktopPane.setLayout(null);
		desktopPane.add(btnGerenciarUsurios);

		JButton btnGerenciarMquinas = new JButton("");
		btnGerenciarMquinas.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/machinemanager.png")));
		btnGerenciarMquinas.setBounds(395, 207, 175, 88);
		btnGerenciarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions admMachineOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				admMachineOptions
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMachineOptions.setVisible(true);
				admMachineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGerenciarMquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarMquinas);

		JButton btnMinhasInformaes_1 = new JButton("");
		btnMinhasInformaes_1.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/myinformationicon.png")));
		btnMinhasInformaes_1.setBounds(336, 54, 122, 27);
		btnMinhasInformaes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyInfo admMyInfo = new MyInfo(idAdmin,getXLocation(),getYLocation());

				dispose();
				admMyInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMyInfo.setVisible(true);
				admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnMinhasInformaes_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnMinhasInformaes_1);

		JButton btnGerenciarAdmins = new JButton("");
		btnGerenciarAdmins.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/adminmanagerbutton.png")));
		btnGerenciarAdmins.setBounds(31, 207, 175, 88);
		btnGerenciarAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminManagementOptions admAdminManagement = new AdminManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				admAdminManagement
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admAdminManagement.setVisible(true);
				admAdminManagement.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnGerenciarAdmins.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarAdmins);

		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logouticon.png")));
		btnLogout.setBounds(470, 54, 81, 27);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrada entrada = new Entrada(getXLocation(),getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 137, 605, 12);
		desktopPane.add(separator);

		JLabel label = new JLabel("");
		label.setBounds(29, 40, 205, 74);
		label.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(label);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/adminescudo.png")));
		lblNewLabel.setBounds(237, 33, 368, 414);
		desktopPane.add(lblNewLabel);

	}
}
