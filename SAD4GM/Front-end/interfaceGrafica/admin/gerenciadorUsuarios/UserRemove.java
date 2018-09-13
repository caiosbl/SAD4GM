package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Usuario;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import java.awt.Color;
import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserRemove extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private Sistema sistema = new Sistema();
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxUsuarios;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserRemove(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton button = new JButton("");
		button.setSelectedIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/return-selected.png")));
		button.setBackground(new Color(0, 0, 0, 0));
		button.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/back-btn.png")));
		button.setBounds(521, 394, 78, 44);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions userOptions = new UserManagementOptions(idAdmin, getXLocation(), getYLocation());

				dispose();
				userOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				userOptions.setVisible(true);
				userOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JButton btnRemover = new JButton("");
		btnRemover.setSelectedIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/remove-btn-on.png")));
		btnRemover.setBackground(new Color(0, 0, 0, 0));
		btnRemover.setBounds(392, 263, 131, 45);
		btnRemover.setIcon(new ImageIcon(UserRemove.class.getResource("/Resources/icon/remove-btn-off.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = (Usuario) comboBoxUsuarios.getSelectedItem();

				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover o Usuário " + usuario.getNome() + " ?", "Remover Usuário",
						JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					sistema.removerUsuario(usuario.getId());
					JOptionPane.showMessageDialog(null, "Usuário removido com Sucesso!");
					UserManagementOptions admUserOptions = new UserManagementOptions(idAdmin, getXLocation(),
							getYLocation());
					dispose();
					admUserOptions
							.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
					admUserOptions.setVisible(true);
					admUserOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}

			}

		});

		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnRemover);

		JLabel title = new JLabel("REMOVER");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(67, 22, 119, 29);
		desktopPane.add(title);

		JLabel lblUsurio = new JLabel("USUÁRIO");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsurio.setBounds(69, 49, 119, 29);
		desktopPane.add(lblUsurio);

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

		List<entidades.Usuario> usuarios = getListagemUsuarios();

		comboBoxUsuarios = new JComboBox(usuarios.toArray());
		comboBoxUsuarios.setBounds(83, 203, 425, 58);
		desktopPane.add(comboBoxUsuarios);

	}

	private List<entidades.Usuario> getListagemUsuarios() {
		return sistema.listarUsuarios();
	}
}
