package admin.MachineManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entrada.Entrada;
import sistema.Sistema;

import javax.swing.JDesktopPane;
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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class MachinesList extends Entrada {

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
	public MachinesList(String id, int xLocation, int yLocation) {
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
		separator.setBounds(10, 133, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachinesList.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineManagmentOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				machineManagmentOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineManagmentOptions.setVisible(true);
				machineManagmentOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(490, 388, 85, 35);
		desktopPane.add(btnVoltar);

		JTextPane machineList = new JTextPane();
		machineList.setBackground(SystemColor.activeCaption);
		machineList.setEditable(false);
		JScrollPane jsp = new JScrollPane(machineList);
		machineList.setText(sistema.listarMaquinas());
		jsp.setBounds(84, 150, 345, 261);
		desktopPane.add(jsp);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachinesList.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(MachinesList.class.getResource("/Resources/icon/machineslistbanner.png")));
		banner.setBounds(299, 22, 250, 90);
		desktopPane.add(banner);
		
		JLabel backList = new JLabel("");
		backList.setIcon(new ImageIcon(MachinesList.class.getResource("/Resources/icon/backlist.png")));
		backList.setBounds(74, 140, 419, 276);
		desktopPane.add(backList);

	}
}
