package interfaceGrafica.usuario.gerenciadorMaquinas.editFalha;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.editFalha.EditFalha;
import interfaceGrafica.usuario.gerenciadorMaquinas.editModoFalha.EditModoFalha;

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
public class EditFalhaOptions extends Main {

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

	public EditFalhaOptions(String id, int xLocation, int yLocation, int chaveMaquina, int chaveSubsistema,
			int chaveComponente, int chaveFalha) {
		super(xLocation, yLocation);
		this.idUsuario = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
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
		btnVoltar.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditFalha editFalha = new EditFalha(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema,
						chaveComponente);
				dispose();
				editFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editFalha.setVisible(true);
				editFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/editar-falha-banner.png")));
		banner.setBounds(368, 21, 106, 84);
		desktopPane.add(banner);

		JButton btnInserirModoFalha = new JButton("");
		btnInserirModoFalha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertModoFalha insertMFalha = new InsertModoFalha(idUsuario, xLocation, yLocation, chaveMaquina,
						chaveSubsistema, chaveComponente, chaveFalha);
				dispose();
				insertMFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insertMFalha.setVisible(true);
				insertMFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnInserirModoFalha
				.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/inserir-modo-aviao.png")));
		btnInserirModoFalha.setBounds(353, 183, 252, 74);
		desktopPane.add(btnInserirModoFalha);

		JButton btnEditarInfoFalha = new JButton("");
		btnEditarInfoFalha
				.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/edit-info-falha.png")));
		btnEditarInfoFalha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFalha setSubsistema = new SetFalha(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema,
						chaveComponente, chaveFalha);
				dispose();
				setSubsistema
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setSubsistema.setVisible(true);
				setSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditarInfoFalha.setBounds(0, 183, 252, 74);
		desktopPane.add(btnEditarInfoFalha);

		JButton editModosFalhaBtn = new JButton();
		editModosFalhaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditModoFalha editModoFalha = new EditModoFalha(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema, chaveComponente, chaveFalha);
				dispose();
				editModoFalha
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				editModoFalha.setVisible(true);
				editModoFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		editModosFalhaBtn
				.setIcon(new ImageIcon(EditFalhaOptions.class.getResource("/Resources/icon/edit-modos-falha.png")));
		editModosFalhaBtn.setBounds(0, 280, 252, 76);
		desktopPane.add(editModosFalhaBtn);

	}
}