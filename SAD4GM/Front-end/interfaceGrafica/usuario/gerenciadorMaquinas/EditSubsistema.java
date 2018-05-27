package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Options;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.ImageIcon;

import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class EditSubsistema extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	@SuppressWarnings("rawtypes")
	private JComboBox boxSubsistemas;
	private Map<String, Integer> mapaSubsistemas;
	private Object[] nomesSubsistemas;
	private int chaveMaquina;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditSubsistema(String id, int xLocation, int yLocation,int chaveMaquina) {
		super(xLocation, yLocation);
		sistema = new Sistema();
		this.idUsuario = id;
		this.chaveMaquina = chaveMaquina;
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
		btnVoltar.setIcon(new ImageIcon(EditSubsistema.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditMachineOptions eMOptions = new EditMachineOptions(id, xLocation, yLocation, chaveMaquina);
				dispose();
				eMOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				eMOptions.setVisible(true);
				eMOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(EditSubsistema.class.getResource("/Resources/icon/editbutton.png")));
		btnInserir.setBounds(367, 335, 90, 27);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int chaveSubsistema = mapaSubsistemas.get(nomesSubsistemas[boxSubsistemas.getSelectedIndex()]);
				
				EditMachineOptions eOptions = new EditMachineOptions(idUsuario, getXLocation(), getYLocation(),
						chaveMaquina);
				dispose();
				eOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				eOptions.setVisible(true);
				eOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}

		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(EditSubsistema.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(EditSubsistema.class.getResource("/Resources/icon/ediSubsistema.png")));
		banner.setBounds(330, 24, 193, 95);
		desktopPane.add(banner);

		this.mapaSubsistemas = getMapaSubsistemas(this.chaveMaquina);

		nomesSubsistemas = mapaSubsistemas.keySet().toArray();
		boxSubsistemas = new JComboBox(nomesSubsistemas);

		boxSubsistemas.setBounds(189, 270, 268, 27);
		desktopPane.add(boxSubsistemas);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(EditSubsistema.class.getResource("/Resources/icon/subsSelector.png")));
		background.setBounds(92, 202, 434, 195);
		desktopPane.add(background);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
	}

	public Map<String, Integer> getMapaSubsistemas(int chaveMaquina) {
		return sistema.getMapaSubsistemas(chaveMaquina);
	}
}
