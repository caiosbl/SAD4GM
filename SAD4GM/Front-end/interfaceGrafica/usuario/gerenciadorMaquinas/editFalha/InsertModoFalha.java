package interfaceGrafica.usuario.gerenciadorMaquinas.editFalha;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
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
public class InsertModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
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

	public InsertModoFalha(String id, int xLocation, int yLocation, int chaveMaquina, int chaveSubsistema, int chaveComponente, int chaveFalha) {
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
		btnVoltar.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditComponentOptions eCompOptions = new EditComponentOptions(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema, chaveComponente);
				dispose();
				eCompOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				eCompOptions.setVisible(true);
				eCompOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/insertbutton.png")));
		btnInserir.setBounds(357, 305, 103, 21);

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

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/insert-modo-falha-banner.png")));
		banner.setBounds(287, 19, 295, 102);
		desktopPane.add(banner);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(192, 209, 268, 91);
		desktopPane.add(jsp);
		
				function = new JTextPane();
				jsp.setViewportView(function);
				function.setEditable(true);
		
		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertModoFalha.class.getResource("/Resources/icon/descricao-form.png")));
		form.setBounds(110, 164, 392, 196);
		desktopPane.add(form);
	}

}
