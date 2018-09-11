package interfaceGrafica.admin.gerenciadorUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserManagementOptions extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserManagementOptions(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
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

		JButton insertUserButton = new JButton("");
		insertUserButton.setSelectedIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/insert-user-on.png")));
		insertUserButton.setBackground(new Color(0,0,0,0));
		insertUserButton
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/insert-user-off.png")));
		insertUserButton.setBounds(10, 154, 142, 180);
		desktopPane.add(insertUserButton);
		insertUserButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton removeUserbutton = new JButton("");
		removeUserbutton.setBackground(new Color(0,0,0,0));
		removeUserbutton.setSelectedIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/remove-user-on.png")));
		removeUserbutton
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/remove-user-off.png")));
		removeUserbutton.setBounds(154, 154, 141, 179);
		desktopPane.add(removeUserbutton);
		removeUserbutton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerMquinas = new JButton("");
		btnVerMquinas.setBackground(new Color(0,0,0,0));
		btnVerMquinas.setSelectedIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/edit-user-on.png")));
		btnVerMquinas.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/edit-user-off.png")));
		btnVerMquinas.setBounds(307, 154, 142, 180);
		desktopPane.add(btnVerMquinas);
		btnVerMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerInformaesUsurio = new JButton("");
		btnVerInformaesUsurio.setBackground(new Color(0,0,0,0));
		btnVerInformaesUsurio.setSelectedIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/view-user-on.png")));
		btnVerInformaesUsurio
				.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/view-user-off.png")));
		btnVerInformaesUsurio.setBounds(450, 154, 142, 180);
		btnVerInformaesUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformationEntry uInformation = new UserInformationEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				uInformation.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uInformation.setVisible(true);
				uInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVerInformaesUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVerInformaesUsurio);

		JButton button = new JButton("");
		button.setSelectedIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/return-selected.png")));
		button.setBackground(new Color(0,0,0,0));
		button.setIcon(new ImageIcon(UserManagementOptions.class.getResource("/Resources/icon/back-btn.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options admOptions = new Options(idAdmin,getXLocation(),getYLocation());
				dispose();
				admOptions.setTabbedPane(1);
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(499, 390, 78, 44);
		desktopPane.add(button);
		
		JLabel lblGerenciador = new JLabel("GERENCIADOR");
		lblGerenciador.setForeground(Color.WHITE);
		lblGerenciador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGerenciador.setBounds(67, 22, 181, 29);
		desktopPane.add(lblGerenciador);
		
		JLabel lblDeUsurios = new JLabel("DE USUÁRIOS");
		lblDeUsurios.setForeground(Color.WHITE);
		lblDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDeUsurios.setBounds(72, 47, 169, 29);
		desktopPane.add(lblDeUsurios);
		btnVerMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserEntry setUser = new SetUserEntry(idAdmin,getXLocation(),getYLocation());

				dispose();
				setUser.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setUser.setVisible(true);
				setUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		removeUserbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRemove userRemove = new UserRemove(idAdmin,getXLocation(),getYLocation());

				dispose();
				userRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				userRemove.setVisible(true);
				userRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		insertUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertUser admInsertUser = new InsertUser(idAdmin,getXLocation(),getYLocation());

				dispose();
				admInsertUser
						.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admInsertUser.setVisible(true);
				admInsertUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
