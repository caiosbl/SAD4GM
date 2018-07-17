package interfaceGrafica.admin.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.usuario.entrada.Options;
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

import javax.swing.JSeparator;

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
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removemenabled.png")));
		btnRemoveMachine.setBackground(new Color(0, 0, 0, 0));
		btnRemoveMachine.setIcon(
				new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removemdisabled.png")));
		btnRemoveMachine.setBounds(24, 182, 137, 145);
		desktopPane.add(btnRemoveMachine);
		btnRemoveMachine.setFont(new Font("Tahoma", Font.BOLD, 12));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/voltabut.png")));
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
		btnVoltar.setBounds(481, 409, 95, 27);
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(
				MachineManagementOptions.class.getResource("/Resources/icon/gerenciadormaquinatitle.png")));
		banner.setBounds(298, 30, 253, 84);
		desktopPane.add(banner);

		JButton btnEditarMaquinas = new JButton("");
		btnEditarMaquinas.setBackground(new Color(0, 0, 0, 0));
		btnEditarMaquinas.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/edit-machines-enabled.png")));
		btnEditarMaquinas.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/edit-machine-disable.png")));
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
		btnEditarMaquinas.setBounds(157, 182, 137, 144);
		desktopPane.add(btnEditarMaquinas);
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
