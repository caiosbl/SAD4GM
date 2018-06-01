package interfaceGrafica.usuario.gerenciadorMaquinas.editSubsistema;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.SetMachine;
import interfaceGrafica.usuario.gerenciadorMaquinas.editMachine.EditMachine;

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
public class EditSubsistemaOptions extends Main {

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

	public EditSubsistemaOptions(String id, int xLocation, int yLocation, int chaveMaquina,int chaveSubsistema) {
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
		btnVoltar.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditSubsistema editSubsistema = new EditSubsistema(id, xLocation, yLocation, chaveMaquina);
				dispose();
				editSubsistema.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editSubsistema.setVisible(true);
				editSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/ediSubsistema.png")));
		banner.setBounds(330, 24, 193, 95);
		desktopPane.add(banner);

		JButton btnInserirSubsistema = new JButton("");
		btnInserirSubsistema
				.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/insertComponent.png")));
		btnInserirSubsistema.setBounds(353, 183, 252, 74);
		desktopPane.add(btnInserirSubsistema);

		JButton btnEditarSubsistema = new JButton("");
		btnEditarSubsistema
				.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/editSubInfo.png")));
		btnEditarSubsistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetSubsistema setSubsistema = new SetSubsistema(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema);
				dispose();
				setSubsistema.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setSubsistema.setVisible(true);
				setSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarSubsistema.setBounds(0, 183, 252, 74);
		desktopPane.add(btnEditarSubsistema);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditSubsistemaOptions.class.getResource("/Resources/icon/editComponentes.png")));
		label.setBounds(0, 280, 252, 76);
		desktopPane.add(label);

	}
}
