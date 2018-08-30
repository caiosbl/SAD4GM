package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextField;

import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertSubsistema extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextField name;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public InsertSubsistema(String id, int xLocation, int yLocation, int chaveMaquina) {
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(484, 396, 78, 44);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insert.setVisible(true);
				insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setBackground(new Color(0,0,0,0));
		btnInserir.setSelectedIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/patch/insert-off.png")));
		btnInserir.setBounds(324, 269, 132, 34);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = new String(name.getText().trim());

				if (isEmpty(nome))
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				else {
					String status = sistema.inserirSubsistema(nome, chaveMaquina);
					JOptionPane.showMessageDialog(null, status);

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(175, 243, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/subsystemform.png")));
		form.setBounds(105, 197, 393, 143);
		desktopPane.add(form);
		
		JLabel lblInserir = new JLabel("INSERIR");
		lblInserir.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setBounds(322, 29, 146, 40);
		desktopPane.add(lblInserir);
		
		JLabel lblMquina = new JLabel("SUBSISTEMA");
		lblMquina.setForeground(Color.WHITE);
		lblMquina.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblMquina.setBounds(287, 59, 218, 40);
		desktopPane.add(lblMquina);
	}

	public Map<String, Integer> getMapaMaquinas() {
		return sistema.getMapaMaquinas();
	}
}
