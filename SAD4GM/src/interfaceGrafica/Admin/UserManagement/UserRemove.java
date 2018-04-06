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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserRemove extends Entrada {

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
	public UserRemove(String id, int xLocation, int yLocation) {
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
		button.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/voltabut.png")));
		button.setBounds(476, 388, 95, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions userOptions = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				userOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				userOptions.setVisible(true);
				userOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		idField = new JTextField();
		idField.setBounds(192, 260, 236, 28);
		desktopPane.add(idField);
		idField.setColumns(10);

		JButton btnRemover = new JButton("");
		btnRemover.setBounds(328, 291, 95, 27);
		btnRemover.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/removebutton.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "ID Inválido!");
					idField.setText("");
				} else {
					boolean has = false;
					try {
						has = sistema.hasIdUsuario(idField.getText().trim())
								&& sistema.isUsuarioAtivo(idField.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Usuário inexistente!");
						idField.setText("");
					} else {
						sistema.removerUsuario(idField.getText().trim());
						JOptionPane.showMessageDialog(null, "Usuário removido com Sucesso!");

						UserManagementOptions admUserOptions = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());
						dispose();
						admUserOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						admUserOptions.setVisible(true);
						admUserOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnRemover);
		
		JLabel form = new JLabel("");
		form.setBounds(161, 186, 289, 154);
		form.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/userRemoveForm.png")));
		desktopPane.add(form);
		
		JLabel sad4gmlogo = new JLabel("");
		sad4gmlogo.setBounds(10, 40, 205, 74);
		sad4gmlogo.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(sad4gmlogo);
		
		JLabel removerUserBanner = new JLabel("");
		removerUserBanner.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/removerUser.png")));
		removerUserBanner.setBounds(313, 26, 236, 92);
		desktopPane.add(removerUserBanner);

	}
}
