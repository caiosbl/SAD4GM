package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
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

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewMachine extends Main {

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
	public ViewMachine(String id, int chaveMaquina, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
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
		btnVoltar.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineInformation2 information = new MachineInformation2(idAdmin, getXLocation(), getYLocation());

				dispose();
				information.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				information.setVisible(true);
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(484, 418, 88, 29);
		desktopPane.add(btnVoltar);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("SansSerif", Font.BOLD, 16));
		textPane.setForeground(Color.BLACK);
		textPane.setText(sistema.getInfoMaquina(chaveMaquina));
		// textPane.setBackground(new Color(0, 0, 0,0));
		textPane.setBounds(114, 162, 394, 191);

		JScrollPane jsp = new JScrollPane(textPane);

		jsp.setBounds(114, 162, 394, 229);
		desktopPane.add(jsp);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/view-machine-title.png")));
		banner.setBounds(324, 19, 204, 106);
		desktopPane.add(banner);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/viewMachineInfoForm.png")));
		form.setBounds(94, 150, 434, 253);
		desktopPane.add(form);

	}
}
