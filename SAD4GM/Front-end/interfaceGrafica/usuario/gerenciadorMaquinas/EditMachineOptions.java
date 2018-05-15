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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextField;

import javax.swing.ImageIcon;

import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class EditMachineOptions extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private int chaveMaquina;
	private Map<String, Integer> mapaMaquinas;
	private Object[] nomesMaquinas;
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
	public EditMachineOptions(String id, int xLocation, int yLocation, int chaveMaquina) {
		super(xLocation, yLocation);
		this.chaveMaquina = chaveMaquina;
		sistema = new Sistema();
		this.idUsuario = id;
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
		btnVoltar.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options uOptions = new Options(idUsuario, getXLocation(), getYLocation());
				dispose();
				uOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/editNameBanner.png")));
		banner.setBounds(330, 24, 141, 92);
		desktopPane.add(banner);
		
		JButton btnEd = new JButton("");
		btnEd.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/editInfomachinebutton.png")));
		btnEd.setBounds(42, 183, 252, 74);
		desktopPane.add(btnEd);
		
		JButton btnInserirSubsistema = new JButton("");
		btnInserirSubsistema.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/insertSubsystem.png")));
		btnInserirSubsistema.setBounds(306, 183, 252, 74);
		desktopPane.add(btnInserirSubsistema);
		
		JButton btnEditarSubsistema = new JButton("");
		btnEditarSubsistema.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/subsEdit.png")));
		btnEditarSubsistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarSubsistema.setBounds(42, 271, 252, 74);
		desktopPane.add(btnEditarSubsistema);

		
	}
}
