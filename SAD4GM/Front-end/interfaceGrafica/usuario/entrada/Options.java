package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



import interfaceGrafica.admin.gerenciadorMaquinas.MachineManagementOptions;
import interfaceGrafica.admin.gerenciadorUsuarios.UserManagementOptions;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.InsertMaquina;
import interfaceGrafica.usuario.gerenciadorMaquinas.MachineInformation2;
import interfaceGrafica.usuario.gerenciadorMaquinas.MachinesList;
import interfaceGrafica.usuario.gerenciadorMaquinas.editMachine.EditMachine;
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
		btnInserirMaquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/insertMachineButton.png")));
		btnInserirMaquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInserirMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertMaquina insertMaquina = new InsertMaquina(idUsuario, getXLocation(), getYLocation());
				dispose();
				insertMaquina
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insertMaquina.setVisible(true);
				insertMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnInserirMaquina.setBounds(0, 156, 249, 73);
		desktopPane.add(btnInserirMaquina);

		JButton btnListarMaquinas = new JButton("");
		btnListarMaquinas.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/listmachineicon.png")));
		btnListarMaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachinesList listarMaquinas = new MachinesList(idUsuario, getXLocation(), getYLocation());
				dispose();
				listarMaquinas
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				listarMaquinas.setVisible(true);
				listarMaquinas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnListarMaquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarMaquinas.setBounds(356, 156, 249, 73);
		desktopPane.add(btnListarMaquinas);

		JButton btnMinhasInformacoes = new JButton("");
		btnMinhasInformacoes.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/myinformationicon.png")));
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
		btnMinhasInformacoes.setBounds(336, 54, 122, 27);
		desktopPane.add(btnMinhasInformacoes);

		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logouticon.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main entrada = new Main(getXLocation(), getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(470, 54, 81, 27);
		desktopPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVerUmaMquina = new JButton("");
		btnVerUmaMquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/viewmachineicon.png")));
		btnVerUmaMquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineInformation2 verMaquina = new MachineInformation2(id, xLocation, yLocation);
				dispose();
				verMaquina.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				verMaquina.setVisible(true);
				verMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVerUmaMquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerUmaMquina.setBounds(356, 241, 249, 73);
		desktopPane.add(btnVerUmaMquina);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JButton btnEditarMaquina = new JButton("");
		btnEditarMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMachine editMachine = new EditMachine(idUsuario, getXLocation(), getYLocation());
				dispose();
				editMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editMachine.setVisible(true);
				editMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarMaquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/machinedit.png")));
		btnEditarMaquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditarMaquina.setBounds(0, 241, 249, 73);
		desktopPane.add(btnEditarMaquina);
		
		
		//
		 
		
		adminPane = new JPanel();
		adminPane.setBackground(SystemColor.activeCaption);
		adminPane.setBorder(null);
		adminPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(adminPane);

		JDesktopPane desktopPane2 = new JDesktopPane();
		desktopPane2.setBackground(SystemColor.inactiveCaption);
		adminPane.add(desktopPane2, BorderLayout.CENTER);

		JButton btnGerenciarUsurios = new JButton("");
		btnGerenciarUsurios.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/usermanager.png")));
		btnGerenciarUsurios.setBounds(119, 184, 169, 88);
		btnGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerenciarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementOptions admUserOptions = new UserManagementOptions(idUsuario, getXLocation(),getYLocation());
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
				MachineManagementOptions admMachineOptions = new MachineManagementOptions(idUsuario,getXLocation(),getYLocation());

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
				MyInfo admMyInfo = new MyInfo(idUsuario,getXLocation(),getYLocation());

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
				Main entrada = new Main(getXLocation(),getYLocation());
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
		tabbedPane.add(usuarioPane,usericon);
		tabbedPane.add(adminPane,admicon);
		tabbedPane.setEnabledAt(1, false);
		
		if (isAdmin)
			tabbedPane.setEnabledAt(1, true);
		
		
		setContentPane(tabbedPane);
		
		
		
		
		
	}
	
	public void setTabbedPane(int index) {
		tabbedPane.setSelectedIndex(index);
	}
}
