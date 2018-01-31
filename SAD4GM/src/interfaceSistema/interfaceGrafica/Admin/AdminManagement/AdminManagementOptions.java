package interfaceSistema.interfaceGrafica.Admin.AdminManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceSistema.interfaceGrafica.Admin.Options;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

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

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(43, 62, 120, 34);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(21, 17, 161, 45);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JButton btnNewButton = new JButton("Inserir Admin");
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(25, 203, 228, 27);
		desktopPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVisualizarMquinas = new JButton("Remover Admin");
		btnVisualizarMquinas.setBounds(25, 229, 228, 27);
		desktopPane.add(btnVisualizarMquinas);
		btnVisualizarMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnInserirFuno = new JButton("Alterar Admin");
		btnInserirFuno.setBounds(25, 256, 228, 27);
		desktopPane.add(btnInserirFuno);
		btnInserirFuno.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnListarUsurios = new JButton("Listar Admins");
		btnListarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminsList admList = new AdminsList(idAdmin);
				dispose();
				admList.setVisible(true);
				admList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnListarUsurios.setBounds(25, 284, 228, 27);
		desktopPane.add(btnListarUsurios);
		btnListarUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblGerenciarUsurios = new JLabel("GERENCIADOR");
		lblGerenciarUsurios.setBounds(329, 17, 227, 37);
		lblGerenciarUsurios.setForeground(Color.WHITE);
		lblGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblGerenciarUsurios);

		JLabel lblDeUsurios = new JLabel("DE ADMINS");
		lblDeUsurios.setForeground(Color.WHITE);
		lblDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDeUsurios.setBounds(358, 49, 178, 37);
		desktopPane.add(lblDeUsurios);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 107, 593, 12);
		desktopPane.add(separator);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options admOptions = new Options(idAdmin);

				dispose();
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(511, 381, 65, 27);
		desktopPane.add(button);
		btnInserirFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAdminEntry setAdmEntry = new SetAdminEntry(idAdmin);
				dispose();
				setAdmEntry.setVisible(true);
				setAdmEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVisualizarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRemove admRemove = new AdminRemove(idAdmin);

				dispose();
				admRemove.setVisible(true);
				admRemove.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminInsert admInsertAdmin = new AdminInsert(idAdmin);

				dispose();
				admInsertAdmin.setVisible(true);
				admInsertAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}

}
