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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class MachineSetOrdemCriterios extends Main {

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
	public MachineSetOrdemCriterios(String id, int xLocation, int yLocation) {
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
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineSetOrdemCriterios.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions umgOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				umgOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				umgOptions.setVisible(true);
				umgOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(483, 388, 88, 27);
		desktopPane.add(btnVoltar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachineSetOrdemCriterios.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(MachineSetOrdemCriterios.class.getResource("/Resources/icon/setCriteriosOrder.png")));
		banner.setBounds(271, 40, 284, 71);
		desktopPane.add(banner);
		
		Integer[] posicoesOrdem = new Integer[]{1,2,3,4,5};
		
		JComboBox seletor1 = new JComboBox(posicoesOrdem);
		seletor1.setBounds(109, 209, 58, 20);
		desktopPane.add(seletor1);
		
		JComboBox seletor2 = new JComboBox(posicoesOrdem);
		seletor2.setBounds(109, 241, 58, 20);
		desktopPane.add(seletor2);
		
		JComboBox seletor3 = new JComboBox(posicoesOrdem);
		seletor3.setBounds(109, 272, 58, 20);
		
		desktopPane.add(seletor3);
		
		JComboBox seletor4 = new JComboBox(posicoesOrdem);
		seletor4.setBounds(109, 304, 58, 20);
		desktopPane.add(seletor4);
		
		JComboBox seletor5 = new JComboBox(posicoesOrdem);
		seletor5.setBounds(109, 334, 58, 20);
		desktopPane.add(seletor5);
		
		JLabel criterio1 = new JLabel("Critério 1");
		criterio1.setBounds(304, 211, 50, 16);
		desktopPane.add(criterio1);
		
		JLabel criterio2 = new JLabel("Critério 2");
		criterio2.setBounds(304, 245, 50, 16);
		desktopPane.add(criterio2);
		
		JLabel criterio3 = new JLabel("Critério 3");
		criterio3.setBounds(304, 276, 50, 16);
		desktopPane.add(criterio3);
		
		JLabel criterio4 = new JLabel("Critério 4");
		criterio4.setBounds(304, 308, 50, 16);
		desktopPane.add(criterio4);
		
		JLabel criterio5 = new JLabel("Critério 5");
		criterio5.setBounds(304, 338, 50, 16);
		desktopPane.add(criterio5);
		
		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon(MachineSetOrdemCriterios.class.getResource("/Resources/icon/backordemcriterio.png")));
		back.setBounds(89, 161, 424, 209);
		desktopPane.add(back);

	}
	
	public boolean isNumber(String password) {
		boolean status = false;

		try {
			Integer.parseInt(password);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
}
