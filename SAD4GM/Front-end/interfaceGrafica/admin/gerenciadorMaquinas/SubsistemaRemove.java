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

import javax.swing.DefaultComboBoxModel;
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
public class SubsistemaRemove extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	@SuppressWarnings("rawtypes")
	private JComboBox boxMaquinas;
	@SuppressWarnings("rawtypes")
	private JComboBox boxSubsistemas;
	private Map<String, Integer> mapaSu;
	private Map<String, Integer> mapaSubsistemas;
	private Object[] nomesMaquinas;
	private Object[] nomesSubsistemas;
	private Sistema sistema;
	private int chaveMaquina;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SubsistemaRemove(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.sistema = new Sistema();
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(SubsistemaRemove.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineOptions = new MachineManagementOptions(idAdmin, getXLocation(),
						getYLocation());
				dispose();
				machineOptions
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineOptions.setVisible(true);
				machineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(492, 388, 83, 23);
		desktopPane.add(btnVoltar);

		this.mapaSu = getMapaMaquinas();

		nomesMaquinas = mapaSu.keySet().toArray();
		boxMaquinas = new JComboBox(nomesMaquinas);
		boxMaquinas.setBounds(170, 232, 268, 27);
		desktopPane.add(boxMaquinas);
		if (mapaSu.size() > 0)
			chaveMaquina = mapaSu.get(nomesMaquinas[boxMaquinas.getSelectedIndex()]);

		this.mapaSubsistemas = getMapaSubsistemas(chaveMaquina);
		nomesSubsistemas = mapaSubsistemas.keySet().toArray();

		boxSubsistemas = new JComboBox(nomesSubsistemas);
		boxSubsistemas.setBounds(170, 274, 268, 27);
		desktopPane.add(boxSubsistemas);

		boxMaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaveMaquina = mapaSu.get(nomesMaquinas[boxMaquinas.getSelectedIndex()]);
				mapaSubsistemas = getMapaSubsistemas(chaveMaquina);
				nomesSubsistemas = mapaSubsistemas.keySet().toArray();
				boxSubsistemas.removeAllItems();
				boxSubsistemas.setModel(new DefaultComboBoxModel(nomesSubsistemas));

			}
		});

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(SubsistemaRemove.class.getResource("/Resources/icon/removebutton.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int chaveSubsistema = mapaSubsistemas.get(nomesSubsistemas[boxSubsistemas.getSelectedIndex()]);

				JOptionPane.showMessageDialog(null, sistema.removerSubsistema(chaveSubsistema));

			}

		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(342, 313, 95, 27);
		desktopPane.add(btnRemover);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SubsistemaRemove.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SubsistemaRemove.class.getResource("/Resources/icon/remove-subs-title.png")));
		banner.setBounds(328, 25, 244, 89);
		desktopPane.add(banner);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SubsistemaRemove.class.getResource("/Resources/icon/remove-subsistema-form.png")));
		label.setBounds(84, 174, 434, 195);
		desktopPane.add(label);

	}

	public Map<String, Integer> getMapaMaquinas() {
		return sistema.getMapaMaquinas();
	}

	public Map<String, Integer> getMapaSubsistemas(int chaveMaquina) {
		return sistema.getMapaSubsistemas(chaveMaquina);
	}
}
