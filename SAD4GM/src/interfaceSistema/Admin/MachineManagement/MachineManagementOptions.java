package interfaceSistema.Admin.MachineManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;
import interfaceSistema.Admin.Options;

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

public class MachineManagementOptions extends Entrada {

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
		setBounds(xLocation,yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton btnListMachines = new JButton("");
		btnListMachines.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/listmachineicon.png")));
		btnListMachines.setBounds(0, 198, 249, 73);
		desktopPane.add(btnListMachines);
		btnListMachines.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnViewMachine = new JButton("");
		btnViewMachine.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/viewmachineicon.png")));
		btnViewMachine.setBounds(0, 283, 249, 73);
		desktopPane.add(btnViewMachine);
		btnViewMachine.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnRemoveMachine = new JButton("");
		btnRemoveMachine.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removemachineicon.png")));
		btnRemoveMachine.setBounds(356, 283, 249, 73);
		desktopPane.add(btnRemoveMachine);
		btnRemoveMachine.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnSetMachine = new JButton("");
		btnSetMachine.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/setmachineicon.png")));
		btnSetMachine.setBounds(356, 198, 249, 73);
		desktopPane.add(btnSetMachine);
		btnSetMachine.setFont(new Font("Tahoma", Font.BOLD, 12));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options admOptions = new Options(idAdmin, getXLocation(),getYLocation());

				dispose();
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
		banner.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/machinemanagerbanner.png")));
		banner.setBounds(298, 30, 253, 84);
		desktopPane.add(banner);
		btnSetMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetMachineEntry setMachine = new SetMachineEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				setMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setMachine.setVisible(true);
				setMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnRemoveMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineRemove machineRemove = new MachineRemove(idAdmin,getXLocation(),getYLocation());

				dispose();
				machineRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineRemove.setVisible(true);
				machineRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnViewMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineInformationEntry machinesInformationEntry = new MachineInformationEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				machinesInformationEntry.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machinesInformationEntry.setVisible(true);
				machinesInformationEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnListMachines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MachinesList machinesList = new MachinesList(idAdmin,getXLocation(),getYLocation());

				dispose();
				machinesList.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machinesList.setVisible(true);
				machinesList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
