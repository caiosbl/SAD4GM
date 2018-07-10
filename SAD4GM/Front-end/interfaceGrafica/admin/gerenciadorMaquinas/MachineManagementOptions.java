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
		setBounds(xLocation,yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton btnRemoveMachine = new JButton("");
		btnRemoveMachine.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removemenabled.png")));
		btnRemoveMachine.setBackground(new Color(0,0,0,0));
		btnRemoveMachine.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removemdisabled.png")));
		btnRemoveMachine.setBounds(0, 195, 137, 145);
		desktopPane.add(btnRemoveMachine);
		btnRemoveMachine.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRemoveComponent = new JButton("");
		btnRemoveComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesRemove vMRemove = new ViewMachinesRemove(idAdmin,getXLocation(),getYLocation());
				dispose();
				vMRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				vMRemove.setVisible(true);
				vMRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnRemoveComponent.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-component-enabled.png")));
		btnRemoveComponent.setBackground(new Color(0,0,0,0));
		btnRemoveComponent.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-component-disabled.png")));
		btnRemoveComponent.setBounds(234, 195, 137, 145);
		desktopPane.add(btnRemoveComponent);
		btnRemoveComponent.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRemoveFail = new JButton("");
		btnRemoveFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveFail.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-falha-enabled.png")));
		btnRemoveFail.setBackground(new Color(0,0,0,0));
		btnRemoveFail.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-falha-disabled.png")));
		btnRemoveFail.setBounds(349, 195, 137, 144);
		desktopPane.add(btnRemoveFail);
		btnRemoveFail.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRemoveModoFalha = new JButton("");
		btnRemoveModoFalha.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-modo-falha-enabled.png")));
		btnRemoveModoFalha.setBackground(new Color(0,0,0,0));
		btnRemoveModoFalha.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/remove-modo-falha-disabled.png")));
		btnRemoveModoFalha.setBounds(462, 195, 137, 144);
		desktopPane.add(btnRemoveModoFalha);
	

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options admOptions = new Options(idAdmin, getXLocation(),getYLocation());

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
		banner.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/gerenciadormaquinatitle.png")));
		banner.setBounds(298, 30, 253, 84);
		desktopPane.add(banner);
		
		JButton removeSubsistemaBtn = new JButton("");
		removeSubsistemaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubsistemaRemove subsistemaRemove = new SubsistemaRemove(idAdmin,getXLocation(),getYLocation());
				dispose();
				subsistemaRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				subsistemaRemove.setVisible(true);
				subsistemaRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		removeSubsistemaBtn.setSelectedIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removesubenabled.png")));
		removeSubsistemaBtn.setIcon(new ImageIcon(MachineManagementOptions.class.getResource("/Resources/icon/removesubdisabled.png")));
		removeSubsistemaBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		removeSubsistemaBtn.setBackground(new Color(0, 0, 0, 0));
		removeSubsistemaBtn.setBounds(118, 195, 137, 145);
		desktopPane.add(removeSubsistemaBtn);
		btnRemoveMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineRemove machineRemove = new MachineRemove(idAdmin,getXLocation(),getYLocation());

				dispose();
				machineRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineRemove.setVisible(true);
				machineRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
