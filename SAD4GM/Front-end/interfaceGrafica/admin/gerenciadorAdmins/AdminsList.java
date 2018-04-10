package interfaceGrafica.admin.gerenciadorAdmins;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import javax.swing.JScrollPane;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class AdminsList extends Main {

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
	public AdminsList(String id, int xLocation , int yLocation) {
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
		separator.setBounds(6, 126, 582, 12);
		desktopPane.add(separator);

		JButton button = new JButton("");
		button.setBounds(491, 388, 84, 31);
		button.setIcon(new ImageIcon(AdminsList.class.getResource("/Resources/icon/voltabut.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminManagementOptions admMOptions = new AdminManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				admMOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMOptions.setVisible(true);
				admMOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		JScrollPane jsp = new JScrollPane(textPane);
		jsp.setBounds(84, 150, 345, 261);
		textPane.setText(sistema.getListagemAdm());
		desktopPane.add(jsp);
		
		JLabel sad4gmlogo = new JLabel("");
		sad4gmlogo.setBounds(29, 40, 205, 74);
		sad4gmlogo.setIcon(new ImageIcon(AdminsList.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(sad4gmlogo);
		
		JLabel label = new JLabel("");
		label.setBounds(77, 137, 366, 283);
		label.setIcon(new ImageIcon(AdminsList.class.getResource("/Resources/icon/backlist.png")));
		desktopPane.add(label);
		
		JLabel listagem = new JLabel("");
		listagem.setIcon(new ImageIcon(AdminsList.class.getResource("/Resources/icon/listagembanner.png")));
		listagem.setBounds(287, 20, 289, 89);
		desktopPane.add(listagem);

	}
}
