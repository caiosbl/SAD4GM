package interfaceGrafica.admin.gerenciadorMaquinas.editMachines;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.admin.gerenciadorMaquinas.ViewMachinesEdit;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import sistema.Sistema;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetCausaPotencial extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField nomeField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetCausaPotencial(String idUser, int xLocation, int yLocation, int chaveCausaPotencial) {
		super(xLocation, yLocation);
		this.idUsuario = idUser;

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
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setSelectedIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(506, 408, 78, 44);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(47, 225, 511, 116);
		desktopPane.add(jPane);
		
				JTextPane descricaoPane = new JTextPane();
				jPane.setViewportView(descricaoPane);
				descricaoPane.setText(sistema.getDescricaoCausaPotencial(chaveCausaPotencial));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesEdit editModoFalha = new ViewMachinesEdit(idUsuario, getXLocation(), getYLocation());
				dispose();
				editModoFalha.setVisible(true);
				editModoFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(idUser, getXLocation(), getYLocation());
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
				MyInfo myInfo = new MyInfo(idUser, getXLocation(), getYLocation());
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

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setSelectedIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/update-selected.png")));
		btnAtualizar.setBackground(new Color(0,0,0,0));
		btnAtualizar.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isEmpty(nomeField.getText().trim())) {
					nomeField.setText(sistema.getNomeCausaPotencial(chaveCausaPotencial));
					descricaoPane.setText(sistema.getDescricaoCausaPotencial(chaveCausaPotencial));
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				}


				else {

					String mensagem = "";
					mensagem += sistema.setNomeCausaPotencial(nomeField.getText().trim(), chaveCausaPotencial);
					mensagem += System.lineSeparator()
							+ sistema.setDescricaoCausaPotencial(descricaoPane.getText().trim(), chaveCausaPotencial);

					JOptionPane.showMessageDialog(null, mensagem);

				}

			}

		});

		btnAtualizar.setBounds(32, 345, 124, 39);
		desktopPane.add(btnAtualizar);

		nomeField = new JTextField();
		nomeField.setText(sistema.getNomeCausaPotencial(chaveCausaPotencial));
		nomeField.setBounds(47, 160, 511, 34);
		desktopPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEditar.setBounds(66, 23, 110, 29);
		desktopPane.add(lblEditar);
		
		JLabel lblCausaPotencial = new JLabel("CAUSA POTENCIAL");
		lblCausaPotencial.setForeground(Color.WHITE);
		lblCausaPotencial.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCausaPotencial.setBounds(18, 50, 229, 29);
		desktopPane.add(lblCausaPotencial);
		
		JLabel label_1 = new JLabel("Título:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(257, 142, 54, 20);
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("Descrição:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(246, 206, 84, 20);
		desktopPane.add(label_2);

	}
}
