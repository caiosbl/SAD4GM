package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;

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

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setIcon(new ImageIcon(SetOwnPassword.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(521, 408, 78, 44);
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
		btnAlterarSenha.setBounds(428, 317, 144, 39);
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
		
		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		homeBtn.setSelectedIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);
		
		JButton myDataBtn = new JButton("");
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);
		
		JButton logoutBtn = new JButton("");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		logoutBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);
		
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		novaSenha = new JPasswordField();
		novaSenha.setBounds(46, 203, 511, 35);
		desktopPane.add(novaSenha);

		confirmacaoSenha = new JPasswordField();
		confirmacaoSenha.setBounds(46, 270, 513, 35);
		desktopPane.add(confirmacaoSenha);

		JLabel lblmnimoCaracteres = new JLabel("*Mínimo 6 Caracteres");
		lblmnimoCaracteres.setForeground(Color.WHITE);
		lblmnimoCaracteres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmnimoCaracteres.setBounds(46, 331, 140, 16);
		desktopPane.add(lblmnimoCaracteres);
		
		JLabel lblAlterar = new JLabel("ALTERAR");
		lblAlterar.setForeground(Color.WHITE);
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAlterar.setBounds(67, 22, 110, 29);
		desktopPane.add(lblAlterar);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSenha.setBounds(82, 48, 83, 29);
		desktopPane.add(lblSenha);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setForeground(Color.WHITE);
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNovaSenha.setBounds(232, 178, 102, 20);
		desktopPane.add(lblNovaSenha);
		
		JLabel lblRepitaANova = new JLabel("Repita a Nova Senha:");
		lblRepitaANova.setForeground(Color.WHITE);
		lblRepitaANova.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRepitaANova.setBounds(201, 250, 176, 20);
		desktopPane.add(lblRepitaANova);
	}

	public boolean isEmpty(String password) {
		return password.equals("");
	}
}
