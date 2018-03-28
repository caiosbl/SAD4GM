package interfaceSistema.Admin.AdmManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Entrada;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import sistema.Sistema;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetAdminPassword extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idAlterar;
	private Sistema sistema = new Sistema();
	private JPasswordField novaSenha;
	private JPasswordField confirmacaoSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetAdminPassword(String id, String idAlterado, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.idAlterar = idAlterado;
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

		JButton voltarButton = new JButton("");
		voltarButton.setIcon(new ImageIcon(SetAdminPassword.class.getResource("/Resources/icon/voltabut.png")));
		voltarButton.setBounds(492, 381, 84, 27);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetAdmin setAdmin = new SetAdmin(idAdmin, idAlterado,getXLocation(),getYLocation());
				dispose();
				setAdmin.setVisible(true);
				setAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(voltarButton);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(SetAdminPassword.class.getResource("/Resources/icon/setPasswordbutton.png")));
		btnAlterarSenha.setBounds(398, 286, 117, 23);
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String newPassword = new String(novaSenha.getPassword()).trim();
				String confirmationPassword = new String(confirmacaoSenha.getPassword()).trim();

				if (isEmpty(newPassword) && isEmpty(confirmationPassword))
					JOptionPane.showMessageDialog(null, "Preencha os campos com a Nova Senha!");
				else if (isEmpty(newPassword))
					JOptionPane.showMessageDialog(null, "Preencha o campo da Nova Senha!");
				else if (isEmpty(confirmationPassword))
					JOptionPane.showMessageDialog(null, "Preencha o campo de confirmação com a Nova Senha!");
				else if (newPassword.length() < 6) {
					JOptionPane.showMessageDialog(null, "Digite uma senha de no mínimo 6 digítos!");
					novaSenha.setText("");
					confirmacaoSenha.setText("");
				}

				else if (!newPassword.equals(confirmationPassword)) {
					JOptionPane.showMessageDialog(null,
							"As senhas diferem, por favor insira uma senha válida e a repita!");
					novaSenha.setText("");
					confirmacaoSenha.setText("");
				}

				else {
					sistema.setSenhaAdmin(idAlterar, newPassword);
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
					SetAdmin setAdmin = new SetAdmin(idAdmin, idAlterado,getXLocation(),getYLocation());
					dispose();
					setAdmin.setVisible(true);
					setAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(248, 211, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(248, 246, 268, 28);
		desktopPane.add(confirmacaoSenha);
		
		JLabel sad4gmLogo = new JLabel("");
		sad4gmLogo.setIcon(new ImageIcon(SetAdminPassword.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4gmLogo.setBounds(29, 40, 205, 74);
		desktopPane.add(sad4gmLogo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SetAdminPassword.class.getResource("/Resources/icon/setsenhabanner.png")));
		label.setBounds(313, 29, 210, 87);
		desktopPane.add(label);
		
		JLabel setSenhaForm = new JLabel("");
		setSenhaForm.setIcon(new ImageIcon(SetAdminPassword.class.getResource("/Resources/icon/setsenhaform.png")));
		setSenhaForm.setBounds(80, 166, 470, 171);
		desktopPane.add(setSenhaForm);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
