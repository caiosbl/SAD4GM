package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaceGrafica.admin.gerenciadorMaquinas.MachineManagementOptions;
import interfaceGrafica.admin.gerenciadorUsuarios.UserManagementOptions;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInfo;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Options extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel usuarioPane;
	private JPanel adminPane;
	private String idUsuario;
	private boolean isAdmin;
	private Sistema sistema;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Options(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idUsuario = id;
		this.sistema = new Sistema();
		this.isAdmin = sistema.isAdmin(id);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);

		usuarioPane = new JPanel();
		usuarioPane.setForeground(SystemColor.activeCaption);
		usuarioPane.setBackground(SystemColor.activeCaption);
		usuarioPane.setBorder(null);
		usuarioPane.setLayout(new BorderLayout(0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		usuarioPane.add(desktopPane, BorderLayout.CENTER);

		JButton btnInserirMaquina = new JButton("");
		btnInserirMaquina.setSelectedIcon(new ImageIcon(Options.class.getResource("/Resources/icon/patch/insert-machine-on.png")));
		btnInserirMaquina.setBackground(new Color(0, 0,0, 0));
		btnInserirMaquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/patch/insert-machine-off.png")));
	
		btnInserirMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert insertMaquina =  new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				insertMaquina
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insertMaquina.setVisible(true);
				insertMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton button = new JButton("");
		button.setSelectedIcon(new ImageIcon(Options.class.getResource("/Resources/icon/home-on.png")));
		button.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/home-off.png")));
		button.setBackground(new Color(0,0,0,0));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(360, 43, 62, 44);
		desktopPane.add(button);
		btnInserirMaquina.setBounds(111, 163, 150, 189);
		desktopPane.add(btnInserirMaquina);

		JButton btnMinhasInformacoes = new JButton("");
		btnMinhasInformacoes.setSelectedIcon(new ImageIcon(Options.class.getResource("/Resources/icon/my-data-on.png")));
		btnMinhasInformacoes.setBackground(new Color(0,0,0,0));
		btnMinhasInformacoes.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/my-data-off.png")));
		btnMinhasInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(idUsuario, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnMinhasInformacoes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinhasInformacoes.setBounds(408, 43, 119, 45);
		desktopPane.add(btnMinhasInformacoes);

		JButton btnLogout = new JButton("");
		btnLogout.setBackground(new Color(0,0,0,0));
		btnLogout.setSelectedIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logout-on.png")));
		btnLogout.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logout-off.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main entrada = new Main(getXLocation(), getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(510, 43, 100, 45);
		desktopPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVerUmaMquina = new JButton("");
		btnVerUmaMquina.setBackground(new Color(0, 0, 0,0));
		btnVerUmaMquina.setSelectedIcon(new ImageIcon(Options.class.getResource("/Resources/icon/patch/view-machine-offff.png")));
		btnVerUmaMquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/patch/view-machine-on.png")));
		btnVerUmaMquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesInfo verMaquina = new ViewMachinesInfo(id, xLocation, yLocation);
				dispose();
				verMaquina.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				verMaquina.setVisible(true);
				verMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVerUmaMquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerUmaMquina.setBounds(360, 156, 150, 189);
		desktopPane.add(btnVerUmaMquina);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel navbar = new JLabel("");
		navbar.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/navbar.png")));
		navbar.setBounds(359, 40, 256, 51);
		desktopPane.add(navbar);

		//

		adminPane = new JPanel();
		adminPane.setBackground(SystemColor.activeCaption);
		adminPane.setBorder(null);
		adminPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(adminPane);

		JDesktopPane desktopPane2 = new JDesktopPane();
		desktopPane2.setBackground(SystemColor.inactiveCaption);
		adminPane.add(desktopPane2, BorderLayout.CENTER);

		JButton btnGerenciarUsurios = new JButton("");
		btnGerenciarUsurios.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/usermanager.png")));
		btnGerenciarUsurios.setBounds(119, 184, 169, 88);
		btnGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerenciarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admUserOptions = new UserManagementOptions(idUsuario, getXLocation(),
						getYLocation());
				dispose();
				admUserOptions
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admUserOptions.setVisible(true);
				admUserOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		desktopPane2.setLayout(null);
		desktopPane2.add(btnGerenciarUsurios);

		JButton btnGerenciarMquinas = new JButton("");
		btnGerenciarMquinas.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/machinemanager.png")));
		btnGerenciarMquinas.setBounds(300, 184, 175, 88);
		btnGerenciarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions admMachineOptions = new MachineManagementOptions(idUsuario, getXLocation(),
						getYLocation());

				dispose();
				admMachineOptions
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMachineOptions.setVisible(true);
				admMachineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGerenciarMquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane2.add(btnGerenciarMquinas);

		JButton btnMinhasInformaes_1 = new JButton("");
		btnMinhasInformaes_1.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/myinformationicon.png")));
		btnMinhasInformaes_1.setBounds(336, 54, 122, 27);
		btnMinhasInformaes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyInfo admMyInfo = new MyInfo(idUsuario, getXLocation(), getYLocation());

				dispose();
				admMyInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMyInfo.setVisible(true);
				admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnMinhasInformaes_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane2.add(btnMinhasInformaes_1);

		JButton btnLogout2 = new JButton("");
		btnLogout2.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logouticon.png")));
		btnLogout2.setBounds(470, 54, 81, 27);
		btnLogout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main entrada = new Main(getXLocation(), getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout2.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane2.add(btnLogout2);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(0, 137, 605, 12);
		desktopPane2.add(separator2);

		JLabel label = new JLabel("");
		label.setBounds(29, 40, 205, 74);
		label.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane2.add(label);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/adminescudo.png")));
		lblNewLabel.setBounds(237, 33, 368, 414);
		desktopPane2.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setBounds(xLocation, yLocation, 621, 497);
		ImageIcon usericon = new ImageIcon(Options.class.getResource("/Resources/icon/usericon.png"));
		ImageIcon admicon = new ImageIcon(Options.class.getResource("/Resources/icon/admicon.png"));
		tabbedPane.add(usuarioPane, usericon);
		tabbedPane.add(adminPane, admicon);
		tabbedPane.setEnabledAt(1, false);

		if (isAdmin)
			tabbedPane.setEnabledAt(1, true);

		setContentPane(tabbedPane);

	}

	public void setTabbedPane(int index) {
		tabbedPane.setSelectedIndex(index);
	}
}
