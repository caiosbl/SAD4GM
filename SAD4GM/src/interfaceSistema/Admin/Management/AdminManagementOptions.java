package interfaceSistema.Admin.Management;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.Admin.Options;

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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class AdminManagementOptions extends JFrame {

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
	public AdminManagementOptions(String id) {
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("icon/icon.jpg");
		this.setIconImage(iconeTitulo);
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 163, 252, 78);
		btnNewButton.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/insertadminicon.png")));
		desktopPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVisualizarMquinas = new JButton("");
		btnVisualizarMquinas.setBounds(0, 247, 252, 78);
		btnVisualizarMquinas.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/removeicon.png")));
		desktopPane.add(btnVisualizarMquinas);
		btnVisualizarMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnInserirFuno = new JButton("Alterar Admin");
		btnInserirFuno.setBounds(353, 163, 252, 78);
		btnInserirFuno.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/alteraradministrador.png")));
		desktopPane.add(btnInserirFuno);
		btnInserirFuno.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnListarUsurios = new JButton("");
		btnListarUsurios.setBounds(353, 247, 252, 78);
		btnListarUsurios.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/listadminicon.png")));
		btnListarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminsList admList = new AdminsList(idAdmin);
				dispose();
				admList.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admList.setVisible(true);
				admList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		desktopPane.add(btnListarUsurios);
		btnListarUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 137, 605, 12);
		desktopPane.add(separator);

		JButton button = new JButton("");
		button.setBounds(465, 383, 93, 34);
		button.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/voltabut.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options admOptions = new Options(idAdmin);

				dispose();
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);
		
		JLabel sad4logo = new JLabel("");
		sad4logo.setBounds(29, 40, 205, 74);
		sad4logo.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(sad4logo);
		
		JLabel gerenciadorname = new JLabel("");
		gerenciadorname.setIcon(new ImageIcon(AdminManagementOptions.class.getResource("/Resources/icon/gerenciadoradminsname.png")));
		gerenciadorname.setBounds(295, 40, 283, 72);
		desktopPane.add(gerenciadorname);
		btnInserirFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAdminEntry setAdmEntry = new SetAdminEntry(idAdmin);
				dispose();
				setAdmEntry.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setAdmEntry.setVisible(true);
				setAdmEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVisualizarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRemove admRemove = new AdminRemove(idAdmin);

				dispose();
				admRemove.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admRemove.setVisible(true);
				admRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminInsert admInsertAdmin = new AdminInsert(idAdmin);

				dispose();
				admInsertAdmin.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admInsertAdmin.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admInsertAdmin.setVisible(true);
				admInsertAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
