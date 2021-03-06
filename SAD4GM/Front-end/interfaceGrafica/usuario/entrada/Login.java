package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Login extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1255872476730391091L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private Sistema sistema = new Sistema();

	
	/**
	 * Create the frame.
	 */
	public Login(int xLocation,int yLocation) {
		super(xLocation, yLocation);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation,yLocation, 621, 497);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		user = new JTextField();

		user.setColumns(10);
		user.setBackground(Color.WHITE);
		user.setBounds(226, 233, 180, 25);
		desktopPane.add(user);

		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setBounds(226, 269, 180, 25);
		desktopPane.add(password);

		JButton loginBtn = new JButton("");
		loginBtn.setBackground(new Color(0,0,0,0));
		loginBtn.setSelectedIcon(new ImageIcon(Login.class.getResource("/Resources/icon/entrar-enabledd.png")));
		loginBtn.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/entrar-disabledd.png")));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = user.getText().trim();
				String senha = new String(password.getPassword()).trim();
				if (isUserEmpty(id) && isPasswordEmpty(senha))
					JOptionPane.showMessageDialog(null, "Preencha os Campos ID e Senha!");
				else if (isUserEmpty(id))
					JOptionPane.showMessageDialog(null, "Preencha o Campo ID!");
				else if (isPasswordEmpty(senha))
					JOptionPane.showMessageDialog(null, "Preencha o Campo Senha!");
				else if (id.length() < 4) {
					JOptionPane.showMessageDialog(null, "Usuário Inválido!");
					user.setText("");
					password.setText("");
				} else if (senha.length() < 6) {
					JOptionPane.showMessageDialog(null, "Senha Inválida!");
					user.setText("");
					password.setText("");
				}

				else {

					try {
						if (sistema.autenticaUsuario(id, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo " + sistema.getNomeUsuario(id) + "!");
							Options uOptions = new Options(id,getXLocation(),getYLocation());
							dispose();
							uOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
							uOptions.setVisible(true);
							uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						} else {
							JOptionPane.showMessageDialog(null, "ID ou Senha Inválidos!");
							user.setText("");
							password.setText("");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");

					}

				}

			}
		});
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBounds(335, 306, 70, 25);
		desktopPane.add(loginBtn);

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(Login.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0,0));
		btnVoltar.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main entrada = new Main(getXLocation(),getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(508, 395, 78, 44);
		desktopPane.add(btnVoltar);
		
		JLabel loginFormBack = new JLabel("");
		loginFormBack.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/loginformback.png")));
		loginFormBack.setBounds(135, 176, 313, 180);
		desktopPane.add(loginFormBack);
		
		JLabel sad4logo = new JLabel("");
		sad4logo.setIcon(new ImageIcon(Login.class.getResource("/Resources/icon/sad4logosmall.png")));
		sad4logo.setBounds(179, 75, 205, 74);
		desktopPane.add(sad4logo);
	}

	private boolean isUserEmpty(String user) {
		return user.equals("");
	}

	private boolean isPasswordEmpty(String password) {
		return password.equals("");
	}
}
