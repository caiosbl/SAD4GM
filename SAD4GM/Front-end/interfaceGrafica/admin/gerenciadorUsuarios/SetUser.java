package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;

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
import javax.swing.JTextPane;

import sistema.Sistema;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetUser extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idUser;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetUser(String id, String idUser, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.idUser = idUser;

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
		button.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/voltabut.png")));
		button.setBounds(492, 381, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserEntry setUserEntry = new SetUserEntry(idAdmin,getXLocation(),getYLocation());
				dispose();
				setUserEntry.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUserEntry.setVisible(true);
				setUserEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);

		nome.setBounds(203, 190, 268, 24);
		nome.setText(sistema.getNomeUsuario(this.idUser));
		desktopPane.add(nome);

		JTextPane userID = new JTextPane();
		userID.setEditable(false);

		userID.setBounds(203, 225, 268, 24);
		userID.setText(idUser);
		desktopPane.add(userID);

		JTextPane auditor = new JTextPane();
		auditor.setText(sistema.getNomeAuditor(this.idUser));
		auditor.setEditable(false);
		auditor.setBounds(203, 261, 268, 24);
		desktopPane.add(auditor);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/setPasswordbutton.png")));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserPassword setUserPassword = new SetUserPassword(idAdmin, idUser,getXLocation(),getYLocation());
				dispose();
				setUserPassword.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUserPassword.setVisible(true);
				setUserPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAlterarSenha.setBounds(196, 296, 84, 27);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userID.setEditable(true);
				nome.setEditable(true);
				auditor.setEditable(true);

			}
		});
		btnEditar.setBounds(292, 297, 82, 24);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasIdUsuario(userID.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (auditor.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Auditor inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (userID.getText().equals("") || userID.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "ID inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (!userID.getText().trim().equals(idUser) && has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					}

					else {
						nome.setEditable(false);
						userID.setEditable(false);
						sistema.setIdUsuario(idUser, userID.getText().trim());
						sistema.setNomeUsuario(nome.getText().trim(), idUser);
						sistema.setAuditorUsuario(idUser, auditor.getText().trim());
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(381, 297, 90, 23);
		desktopPane.add(btnAtualizar);
		
		JLabel sad4glogo = new JLabel("");
		sad4glogo.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4glogo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4glogo);
		
		JLabel alterarusuariobanner = new JLabel("");
		alterarusuariobanner.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/alterarusuariobanner.png")));
		alterarusuariobanner.setBounds(326, 24, 213, 96);
		desktopPane.add(alterarusuariobanner);
		
		JLabel setUserForm = new JLabel("");
		setUserForm.setIcon(new ImageIcon(SetUser.class.getResource("/Resources/icon/setUserform.png")));
		setUserForm.setBounds(121, 173, 376, 179);
		desktopPane.add(setUserForm);

	}
}
