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
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JLabel titulo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetFalha(String idUser, int xLocation, int yLocation, int chaveFalha) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(SetFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(SetFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(490, 420, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesEdit viewMachinesEdit = new ViewMachinesEdit(idUsuario, getXLocation(), getYLocation());
				dispose();
				viewMachinesEdit.setVisible(true);
				viewMachinesEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);
		
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

		JTextPane nome = new JTextPane();
		nome.setBounds(58, 167, 502, 35);
		nome.setText(sistema.getNomeFalha(chaveFalha));
		desktopPane.add(nome);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(55, 236, 507, 107);
		desktopPane.add(jPane);
		
				JTextPane descricaoPane = new JTextPane();
				jPane.setViewportView(descricaoPane);
				descricaoPane.setText(sistema.getDescricaoFalha(chaveFalha));

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setBackground(new Color(0,0,0,0));
		btnAtualizar.setSelectedIcon(new ImageIcon(SetFalha.class.getResource("/Resources/icon/update-selected.png")));
		btnAtualizar.setIcon(new ImageIcon(SetFalha.class.getResource("/Resources/icon/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isEmpty(nome.getText().trim())) {
					nome.setText(sistema.getNomeFalha(chaveFalha));
					JOptionPane.showMessageDialog(null, "Nome Inválido!");
				} else if (isEmpty(descricaoPane.getText().trim())) {
					descricaoPane.setText(sistema.getDescricaoFalha(chaveFalha));
					JOptionPane.showMessageDialog(null, "Descrição Inválida");
				}

				else {

					JOptionPane.showMessageDialog(null, sistema.setNomeFalha(nome.getText().trim(), chaveFalha));
					JOptionPane.showMessageDialog(null,
							sistema.setDescricaoFalha(descricaoPane.getText().trim(), chaveFalha));

				}

			}

		});

		btnAtualizar.setBounds(45, 353, 124, 39);
		desktopPane.add(btnAtualizar);
		
		
		titulo = new JLabel("EDITAR");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		titulo.setBounds(67, 22, 110, 29);
		desktopPane.add(titulo);
		
		JLabel lblFalha = new JLabel("FALHA");
		lblFalha.setForeground(Color.WHITE);
		lblFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFalha.setBounds(74, 48, 78, 29);
		desktopPane.add(lblFalha);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(270, 144, 53, 20);
		desktopPane.add(label_1);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescrio.setBounds(258, 218, 84, 20);
		desktopPane.add(lblDescrio);

	}

}
