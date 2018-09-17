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

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
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
	public SetUserEntry(String id, int xLocation, int yLocation) {
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagementOptions umgOptions = new UserManagementOptions(idAdmin, getXLocation(), getYLocation());

				dispose();
				umgOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				umgOptions.setVisible(true);
				umgOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(521, 395, 78, 44);
		desktopPane.add(btnVoltar);

		JButton btnAlterar = new JButton("");
		btnAlterar.setSelectedIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/edit-btn-on.png")));
		btnAlterar.setBackground(new Color(0, 0, 0, 0));
		btnAlterar.setIcon(new ImageIcon(SetUserEntry.class.getResource("/Resources/icon/edit-btn-off.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = (Usuario) comboBoxUsuarios.getSelectedItem();

				SetUser setUser = new SetUser(idAdmin, usuario.getId(), getXLocation(), getYLocation());
				dispose();
				setUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUser.setVisible(true);
				setUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}

		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(390, 264, 131, 45);
		desktopPane.add(btnAlterar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEditar.setBounds(67, 22, 93, 29);
		desktopPane.add(lblEditar);

		JLabel lblUsurio = new JLabel("USUÁRIO");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsurio.setBounds(58, 47, 114, 29);
		desktopPane.add(lblUsurio);

		List<entidades.Usuario> usuarios = getListagemUsuarios();

		comboBoxUsuarios = new JComboBox(usuarios.toArray());
		comboBoxUsuarios.setBounds(83, 203, 425, 58);
		desktopPane.add(comboBoxUsuarios);

		JLabel lblSelecioneOUsurio = new JLabel("SELECIONE O USUÁRIO A SER EDITADO:");
		lblSelecioneOUsurio.setForeground(Color.WHITE);
		lblSelecioneOUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelecioneOUsurio.setBounds(141, 187, 304, 17);
		desktopPane.add(lblSelecioneOUsurio);

	}

	private List<entidades.Usuario> getListagemUsuarios() {

		ArrayList<entidades.Usuario> lista = new ArrayList<entidades.Usuario>();

		for (Usuario usuario : sistema.listarUsuarios()) {
			if (!usuario.getId().equals(idAdmin))
				lista.add(usuario);
		}

		return lista;
	}
}
