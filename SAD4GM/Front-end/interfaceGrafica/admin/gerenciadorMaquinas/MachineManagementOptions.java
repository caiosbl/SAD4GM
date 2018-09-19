package interfaceGrafica.admin.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import interfaceGrafica.main.Main;

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

public class MachineManagementOptions extends Main {

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
	public MachineManagementOptions(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton btnRemoveMachine = new JButton("");
		btnRemoveMachine.setSelectedIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remover-maquina-on.png")));
		btnRemoveMachine.setBackground(new Color(0, 0, 0, 0));
		btnRemoveMachine.setIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remover-maquina-off.png")));
		btnRemoveMachine.setBounds(54, 164, 142, 183);
		desktopPane.add(btnRemoveMachine);
		btnRemoveMachine.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		homeBtn.setSelectedIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);

		JButton myDataBtn = new JButton("");
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);

		JButton logoutBtn = new JButton("");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		logoutBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options admOptions = new Options(idAdmin, getXLocation(), getYLocation());
				dispose();
				admOptions.setTabbedPane(1);
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(521, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JButton btnEditarMaquinas = new JButton("");
		btnEditarMaquinas.setBackground(new Color(0, 0, 0, 0));
		btnEditarMaquinas.setSelectedIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/editar-maquina-on.png")));
		btnEditarMaquinas.setIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/editar-maquina-off.png")));
		btnEditarMaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesEdit viewMachinesEdit = new ViewMachinesEdit(idAdmin, getXLocation(), getYLocation());
				dispose();
				viewMachinesEdit
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				viewMachinesEdit.setVisible(true);
				viewMachinesEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarMaquinas.setBounds(210, 164, 142, 183);
		desktopPane.add(btnEditarMaquinas);

		JLabel titulo = new JLabel("GERENCIADOR");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		titulo.setBounds(67, 22, 181, 29);
		desktopPane.add(titulo);

		JLabel lblDeMquinas = new JLabel("DE MÁQUINAS");
		lblDeMquinas.setForeground(Color.WHITE);
		lblDeMquinas.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDeMquinas.setBounds(67, 50, 181, 29);
		desktopPane.add(lblDeMquinas);
		btnRemoveMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesRemove vMRemove = new ViewMachinesRemove(idAdmin, getXLocation(), getYLocation());
				dispose();
				vMRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				vMRemove.setVisible(true);
				vMRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
