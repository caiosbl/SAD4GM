package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;


import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextField name;
	private JTextPane function;
	private Sistema sistema;
	private JLabel title;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public InsertFalha(String id, int xLocation, int yLocation, int chaveComponente) {
		super(xLocation, yLocation);
		sistema = new Sistema();
		this.idUsuario = id;
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(514, 408, 78, 44);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert viewInsert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				viewInsert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				viewInsert.setVisible(true);
				viewInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setSelectedIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/patch/insert-off.png")));
		btnInserir.setBounds(55, 354, 103, 21);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nome = new String(name.getText().trim());
				String descricao = new String(function.getText().trim());

				if (isEmpty(nome))
					JOptionPane.showMessageDialog(null, "Nome Inválido!");
				else if (isEmpty(descricao))
					JOptionPane.showMessageDialog(null, "Descrição Inválida!");
				else {
					JOptionPane.showMessageDialog(null, sistema.inserirFalha(nome, descricao, chaveComponente));

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(55, 172, 484, 34);
		desktopPane.add(name);
		name.setColumns(10);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(55, 236, 484, 106);
		desktopPane.add(jsp);

		function = new JTextPane();
		jsp.setViewportView(function);
		function.setEditable(true);
		

		title = new JLabel("INSERIR");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(67, 22, 110, 29);
		desktopPane.add(title);
		
		JLabel lblFalha = new JLabel("FALHA");
		lblFalha.setForeground(Color.WHITE);
		lblFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFalha.setBounds(80, 50, 78, 29);
		desktopPane.add(lblFalha);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(264, 150, 53, 20);
		desktopPane.add(label_1);
		
		JLabel lblNome = new JLabel("Função:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(260, 214, 63, 20);
		desktopPane.add(lblNome);
	}

}
