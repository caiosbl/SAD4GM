package interfaceSistema.Admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;
import interfaceSistema.Admin.AdmManagement.AdminManagementOptions;
import interfaceSistema.Admin.UserManagement.UserManagementOptions;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Options extends JFrame {

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
	public Options(String id) {
		
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		
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

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(20, 60, 141, 45);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(10, 11, 210, 73);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JButton btnGerenciarUsurios = new JButton("Gerenciar Usuários");
		btnGerenciarUsurios.setBounds(68, 217, 175, 41);
		btnGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerenciarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admUserOptions = new UserManagementOptions(idAdmin);
				dispose();
				admUserOptions.setVisible(true);
				admUserOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		desktopPane.add(btnGerenciarUsurios);

		JButton btnGerenciarMquinas = new JButton("Gerenciar Máquinas");
		btnGerenciarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions admMachineOptions = new MachineManagementOptions(idAdmin);

				dispose();
				admMachineOptions.setVisible(true);
				admMachineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGerenciarMquinas.setBounds(68, 262, 175, 41);
		btnGerenciarMquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarMquinas);

		JButton btnMinhasInformaes_1 = new JButton("Minhas Informações");
		btnMinhasInformaes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyInfo admMyInfo = new MyInfo(idAdmin);

				dispose();
				admMyInfo.setVisible(true);
				admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnMinhasInformaes_1.setBounds(68, 310, 175, 41);
		btnMinhasInformaes_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnMinhasInformaes_1);

		JButton btnGerenciarAdmins = new JButton("Gerenciar Admins");
		btnGerenciarAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminManagementOptions admAdminManagement = new AdminManagementOptions(idAdmin);

				dispose();
				admAdminManagement.setVisible(true);
				admAdminManagement.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnGerenciarAdmins.setBounds(68, 169, 175, 41);
		btnGerenciarAdmins.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarAdmins);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrada entrada = new Entrada();
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(501, 33, 81, 27);
		desktopPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 605, 12);
		desktopPane.add(separator);

	}

}
