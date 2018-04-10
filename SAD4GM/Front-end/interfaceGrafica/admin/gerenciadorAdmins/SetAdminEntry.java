package interfaceGrafica.admin.gerenciadorAdmins;

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
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetAdminEntry extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTextField idField;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetAdminEntry(String id, int xLocation, int yLocation) {
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

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SetAdminEntry.class.getResource("/Resources/icon/voltabut.png")));
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
		button.setBounds(506, 388, 93, 34);
		desktopPane.add(button);

		idField = new JTextField();
		idField.setBounds(200, 248, 206, 28);
		desktopPane.add(idField);
		idField.setColumns(10);

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(SetAdminEntry.class.getResource("/Resources/icon/alterarbutton.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "ID Inválido!");
					idField.setText("");
				} else if (idField.getText().trim().equals(idAdmin)) {
					JOptionPane.showMessageDialog(null, "Por favor insira um ID diferente do seu!");
					idField.setText("");
				} else {
					boolean has = false;

					try {
						has = sistema.hasIdAdmin(idField.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Admin inexistente!");
						idField.setText("");
					}

					else {
						SetAdmin setAdmin = new SetAdmin(idAdmin, idField.getText().trim(),getXLocation(),getYLocation());
						dispose();
						setAdmin.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						setAdmin.setVisible(true);
						setAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(332, 279, 74, 21);
		desktopPane.add(btnRemover);
		
		JLabel sad4Logo = new JLabel("");
		sad4Logo.setIcon(new ImageIcon(SetAdminEntry.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4Logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4Logo);
		
		JLabel formBackground = new JLabel("");
		formBackground.setIcon(new ImageIcon(SetAdminEntry.class.getResource("/Resources/icon/alteraradminformback.png")));
		formBackground.setBounds(150, 171, 294, 184);
		desktopPane.add(formBackground);
		
		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetAdminEntry.class.getResource("/Resources/icon/alteraradminbanner.png")));
		banner.setBounds(306, 27, 210, 87);
		desktopPane.add(banner);

	}
}
