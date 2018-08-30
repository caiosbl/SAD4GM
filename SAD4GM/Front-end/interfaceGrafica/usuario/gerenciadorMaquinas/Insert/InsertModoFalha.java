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

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextPane descricaoPane;
	private Sistema sistema;
	private JTextField tituloField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	public InsertModoFalha(String id, int xLocation, int yLocation, int chaveFalha) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setBounds(514, 408, 78, 44);
		btnVoltar.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/back-btn.png")));
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
		btnInserir.setSelectedIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setBounds(415, 369, 103, 21);
		btnInserir.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/patch/insert-off.png")));

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String descricao = new String(descricaoPane.getText().trim());
				String titulo = new String(tituloField.getText().trim());

				if (isEmpty(titulo))
					JOptionPane.showMessageDialog(null, "Título Inválido!");
				else if (isEmpty(descricao))
					JOptionPane.showMessageDialog(null, "Descrição Inválida!");

				else {
					JOptionPane.showMessageDialog(null, sistema.inserirModoFalha(titulo, descricao, chaveFalha));

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		JLabel logo = new JLabel("");
		logo.setBounds(29, 40, 205, 74);
		logo.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		desktopPane.add(logo);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(114, 239, 404, 116);
		desktopPane.add(jsp);

		descricaoPane = new JTextPane();
		jsp.setViewportView(descricaoPane);
		descricaoPane.setEditable(true);

		tituloField = new JTextField();
		tituloField.setBounds(114, 193, 404, 34);
		desktopPane.add(tituloField);
		tituloField.setColumns(10);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/insert-modofalha-form.png")));
		form.setBounds(36, 159, 515, 244);
		desktopPane.add(form);
		
		JLabel lblInserir = new JLabel("INSERIR");
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblInserir.setBounds(350, 29, 146, 40);
		desktopPane.add(lblInserir);
		
		JLabel lblModoDeFalha = new JLabel("MODO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblModoDeFalha.setBounds(298, 63, 278, 40);
		desktopPane.add(lblModoDeFalha);
	}
}
