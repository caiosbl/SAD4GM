package interfaceSistema.interfaceGrafica.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class AdminOptionsUserManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptionsUserManagement frame = new AdminOptionsUserManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminOptionsUserManagement() {
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

		JButton btnNewButton = new JButton("Inserir Usuário");
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(25, 203, 228, 27);
		desktopPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVisualizarMquinas = new JButton("Remover Usuário");
		btnVisualizarMquinas.setBounds(25, 229, 228, 27);
		desktopPane.add(btnVisualizarMquinas);
		btnVisualizarMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnInserirFuno = new JButton("Alterar Senha Usuário");
		btnInserirFuno.setBounds(25, 256, 228, 27);
		desktopPane.add(btnInserirFuno);
		btnInserirFuno.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerMquinas = new JButton("Alterar Usuário");
		btnVerMquinas.setBounds(25, 283, 228, 27);
		desktopPane.add(btnVerMquinas);
		btnVerMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnListarUsurios = new JButton("Listar Usuários");
		btnListarUsurios.setBounds(25, 311, 228, 27);
		desktopPane.add(btnListarUsurios);
		btnListarUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnVerInformaesUsurio = new JButton("Ver Informações de Usuário");
		btnVerInformaesUsurio.setBounds(25, 339, 228, 27);
		btnVerInformaesUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerInformaesUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVerInformaesUsurio);

		JLabel lblGerenciarUsurios = new JLabel("GERENCIADOR");
		lblGerenciarUsurios.setBounds(329, 17, 227, 37);
		lblGerenciarUsurios.setForeground(Color.WHITE);
		lblGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblGerenciarUsurios);

		JLabel lblDeUsurios = new JLabel("DE USUÁRIOS");
		lblDeUsurios.setForeground(Color.WHITE);
		lblDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDeUsurios.setBounds(339, 53, 227, 37);
		desktopPane.add(lblDeUsurios);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 107, 593, 12);
		desktopPane.add(separator);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminOptions admOptions = new AdminOptions();
				admOptions.setId(idAdmin);
				dispose();
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(511, 381, 65, 27);
		desktopPane.add(button);
		btnVerMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInserirFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	
	public void setAdmin(String id) {
		this.idAdmin = id;
	}
}
