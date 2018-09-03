package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewModoFalha(String id, int chaveModoFalha, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
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
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setSelectedIcon(new ImageIcon(ViewModoFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(ViewModoFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesInfo information = new ViewMachinesInfo(idAdmin, getXLocation(), getYLocation());

				dispose();
				information.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				information.setVisible(true);
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(521, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewModoFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(114, 239, 404, 116);
		desktopPane.add(jsp);

		JTextPane descricaoPane = new JTextPane();
		descricaoPane.setText(sistema.getDescricaoModoFalha(chaveModoFalha));
		descricaoPane.setEditable(false);
		jsp.setViewportView(descricaoPane);
		

		JTextField tituloField = new JTextField();
		tituloField.setEditable(false);
		tituloField.setText(sistema.getNomeModoFalha(chaveModoFalha));
		tituloField.setBounds(114, 193, 404, 34);
		desktopPane.add(tituloField);
		tituloField.setColumns(10);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(ViewModoFalha.class.getResource("/Resources/icon/insert-modofalha-form.png")));
		form.setBounds(36, 159, 515, 244);
		desktopPane.add(form);
		
		JLabel label = new JLabel("VISUALIZAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 33));
		label.setBounds(327, 27, 209, 40);
		desktopPane.add(label);
		
		JLabel lblModoDeFalha = new JLabel("MODO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblModoDeFalha.setBounds(292, 57, 278, 40);
		desktopPane.add(lblModoDeFalha);

	}
}
