package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert viewInsert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				viewInsert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				viewInsert.setVisible(true);
				viewInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/insertbutton.png")));
		btnInserir.setBounds(354, 321, 103, 21);

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
		name.setBounds(192, 186, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/inserir-falha-banner.png")));
		banner.setBounds(367, 27, 135, 86);
		desktopPane.add(banner);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(192, 226, 268, 91);
		desktopPane.add(jsp);

		function = new JTextPane();
		jsp.setViewportView(function);
		function.setEditable(true);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertFalha.class.getResource("/Resources/icon/insert-falha-form.png")));
		form.setBounds(110, 164, 392, 196);
		desktopPane.add(form);
	}

}
