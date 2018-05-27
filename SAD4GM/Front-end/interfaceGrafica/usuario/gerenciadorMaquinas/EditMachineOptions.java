package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.ImageIcon;

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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public EditMachineOptions(String id, int xLocation, int yLocation, int chaveMaquina) {
		super(xLocation, yLocation);
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
				EditMachine editMachine = new EditMachine(idUsuario, getXLocation(), getYLocation());
				dispose();
				editMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editMachine.setVisible(true);
				editMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JButton btnMachineInfoEdit = new JButton("");
		btnMachineInfoEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SetMachine setMachine = new SetMachine(idUsuario, chaveMaquina, getXLocation(), getYLocation());
				dispose();
				setMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setMachine.setVisible(true);
				setMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnMachineInfoEdit
				.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/editMachineInfo.png")));
		btnMachineInfoEdit.setBounds(0, 183, 252, 74);
		desktopPane.add(btnMachineInfoEdit);

		JButton btnInserirSubsistema = new JButton("");
		btnInserirSubsistema
				.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/insertSubsystem.png")));
		btnInserirSubsistema.setBounds(353, 183, 252, 74);
		desktopPane.add(btnInserirSubsistema);

		JButton btnEditarSubsistema = new JButton("");
		btnEditarSubsistema
				.setIcon(new ImageIcon(EditMachineOptions.class.getResource("/Resources/icon/subsEdit.png")));
		btnEditarSubsistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditSubsistema editSubsistema = new EditSubsistema(id, xLocation, yLocation, chaveMaquina);
				dispose();
				editSubsistema.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editSubsistema.setVisible(true);
				editSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarSubsistema.setBounds(0, 273, 252, 74);
		desktopPane.add(btnEditarSubsistema);

	}
}
