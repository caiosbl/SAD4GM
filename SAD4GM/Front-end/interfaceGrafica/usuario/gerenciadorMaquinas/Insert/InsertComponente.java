package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertComponente extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextField name;
	private JTextPane function;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public InsertComponente(String id, int xLocation, int yLocation, int chaveSubsistema) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(514, 408, 78, 44);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert eSOptions = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				eSOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				eSOptions.setVisible(true);
				eSOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setSelectedIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setBackground(new Color(0,0,0,0));
		btnInserir.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/patch/insert-off.png")));
		btnInserir.setBounds(344, 314, 132, 34);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = new String(name.getText().trim());
				String funcao = new String(function.getText().trim());

				if (isEmpty(nome))
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				else if (isEmpty(funcao))
					JOptionPane.showMessageDialog(null, "Função Inválida");
				else {
					JOptionPane.showMessageDialog(null, sistema.inserirComponente(nome, chaveSubsistema, funcao));

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(192, 186, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(192, 226, 268, 91);
		desktopPane.add(jsp);

		function = new JTextPane();
		jsp.setViewportView(function);
		function.setEditable(true);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/insert-componente-form.png")));
		form.setBounds(120, 164, 371, 196);
		desktopPane.add(form);
		
		JLabel lblInserir = new JLabel("INSERIR");
		lblInserir.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setBounds(344, 28, 146, 40);
		desktopPane.add(lblInserir);
		
		JLabel lblComponente = new JLabel("COMPONENTE");
		lblComponente.setForeground(Color.WHITE);
		lblComponente.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblComponente.setBounds(305, 57, 233, 40);
		desktopPane.add(lblComponente);
	}

}
