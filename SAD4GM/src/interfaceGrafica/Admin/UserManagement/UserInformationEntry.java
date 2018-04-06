package interfaceGrafica.Admin.UserManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.Entrada;
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
public class UserInformationEntry extends Entrada {

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
	public UserInformationEntry(String id, int xLocation, int yLocation) {
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
		button.setIcon(new ImageIcon(UserInformationEntry.class.getResource("/Resources/icon/voltabut.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions umgOptions = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				umgOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				umgOptions.setVisible(true);
				umgOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(487, 388, 84, 27);
		desktopPane.add(button);

		idField = new JTextField();
		idField.setBounds(200, 248, 206, 28);
		desktopPane.add(idField);
		idField.setColumns(10);

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(UserInformationEntry.class.getResource("/Resources/icon/visualizarbutto.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "ID Inválido!");
					idField.setText("");
				} else {
					boolean has = false;

					try {
						has = sistema.hasIdUsuario(idField.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Usuário inexistente!");
						idField.setText("");
					}

					else {
						UserInformation userInformation = new UserInformation(idAdmin,idField.getText().trim(),getXLocation(),getYLocation());
						dispose();
						userInformation.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						userInformation.setVisible(true);
						userInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(310, 288, 95, 27);
		desktopPane.add(btnRemover);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(UserInformationEntry.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(UserInformationEntry.class.getResource("/Resources/icon/userInformationForm.png")));
		form.setBounds(165, 177, 273, 154);
		desktopPane.add(form);
		
		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(UserInformationEntry.class.getResource("/Resources/icon/viewinformationuser.png")));
		banner.setBounds(246, 26, 335, 90);
		desktopPane.add(banner);

	}
}
