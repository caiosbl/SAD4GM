package interfaceGrafica.admin.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;


/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class MachineRemove extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	@SuppressWarnings("rawtypes")
	private JComboBox boxMaquinas;
	private Map<String, Integer> mapaMaquinas;
	private Object[] nomesMaquinas;
	private Sistema sistema;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MachineRemove(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.sistema = new Sistema();
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
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());
				dispose();
				machineOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineOptions.setVisible(true);
				machineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(492, 388, 83, 23);
		desktopPane.add(btnVoltar);
		
		this.mapaMaquinas = getMapaMaquinas();

		nomesMaquinas = mapaMaquinas.keySet().toArray();
		boxMaquinas = new JComboBox(nomesMaquinas);

		boxMaquinas.setBounds(187, 246, 268, 27);
		desktopPane.add(boxMaquinas);

	

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/removebutton.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int chaveMaquina = mapaMaquinas.get(nomesMaquinas[boxMaquinas.getSelectedIndex()]);
			
						
						JOptionPane.showMessageDialog(null, sistema.removerMaquina(chaveMaquina));

						MachineManagementOptions admMOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());
						dispose();
						admMOptions.setIconImage(
								new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						admMOptions.setVisible(true);
						admMOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				
			
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(360, 285, 95, 27);
		desktopPane.add(btnRemover);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/remove-maquina-title.png")));
		banner.setBounds(328, 25, 206, 101);
		desktopPane.add(banner);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/backEditMaquina.png")));
		label.setBounds(84, 174, 434, 195);
		desktopPane.add(label);

	}

	
	
	public Map<String, Integer> getMapaMaquinas() {
		return sistema.getMapaMaquinas();
	}

}
