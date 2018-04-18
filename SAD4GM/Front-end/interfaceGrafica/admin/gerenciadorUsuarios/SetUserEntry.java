package interfaceGrafica.admin.gerenciadorUsuarios;

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
public class SetUserEntry extends Main {

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
	public SetUserEntry(String id, int xLocation, int yLocation) {
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions umgOptions = new UserManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				umgOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				umgOptions.setVisible(true);
				umgOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(482, 388, 89, 27);
		desktopPane.add(btnVoltar);

		idField = new JTextField();
		idField.setBounds(200, 250, 206, 28);
		desktopPane.add(idField);
		idField.setColumns(10);

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/alterarbutton.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "ID Inválido!");
					idField.setText("");
				} else {
					boolean has = false;

					try {
						has = sistema.hasIdUsuario(idField.getText().trim()) && sistema.isUsuarioAtivo(idField.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Usuário inexistente!");
						idField.setText("");
					}

					else {
						SetUser setUser = new SetUser(idAdmin, idField.getText().trim(),getXLocation(),getYLocation());
						dispose();
						setUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						setUser.setVisible(true);
						setUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(341, 283, 65, 21);
		desktopPane.add(btnAlterar);
		
		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4logo);
		
		JLabel alterarUsuario = new JLabel("");
		alterarUsuario.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/alterarusuariobanner.png")));
		alterarUsuario.setBounds(336, 22, 213, 96);
		desktopPane.add(alterarUsuario);
		
		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/setUserEntryForm.png")));
		form.setBounds(158, 184, 289, 154);
		desktopPane.add(form);

	}
}
