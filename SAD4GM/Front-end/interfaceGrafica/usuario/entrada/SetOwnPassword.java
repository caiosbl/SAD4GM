package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import sistema.Sistema;
import javax.swing.JPasswordField;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetOwnPassword extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JPasswordField novaSenha;
	private JPasswordField confirmacaoSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetOwnPassword(String id,int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idUsuario = id;
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
		separator.setBounds(10, 125, 593, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(481, 381, 78, 44);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyInfo admMyInfo = new MyInfo(idUsuario,getXLocation(),getYLocation());
				dispose();
				admMyInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admMyInfo.setVisible(true);
				admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setSelectedIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/set-senha-on.png")));
		btnAlterarSenha.setBackground(new Color(0,0,0,0));
		btnAlterarSenha.setIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/set-senha.png")));
		btnAlterarSenha.setBounds(384, 292, 144, 39);
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
					sistema.setSenhaUsuario(idUsuario, newPassword);
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
					MyInfo admMyInfo = new MyInfo(idUsuario,getXLocation(),getYLocation());
					dispose();
					admMyInfo.setVisible(true);
					admMyInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(248, 217, 268, 28);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(248, 252, 268, 28);
		desktopPane.add(confirmacaoSenha);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/novaSenhraformu.png")));
		label.setBounds(76, 162, 470, 195);
		desktopPane.add(label);

		JLabel lblmnimoCaracteres = new JLabel("*Mínimo 6 Caracteres");
		lblmnimoCaracteres.setForeground(Color.WHITE);
		lblmnimoCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblmnimoCaracteres.setBounds(248, 268, 111, 16);
		desktopPane.add(lblmnimoCaracteres);
		
		JLabel lblAlterar = new JLabel("ALTERAR SENHA");
		lblAlterar.setForeground(Color.WHITE);
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblAlterar.setBounds(268, 50, 277, 40);
		desktopPane.add(lblAlterar);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
