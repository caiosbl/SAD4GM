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

import javax.swing.JTextPane;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewFalha extends Main {

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
	public ViewFalha(String id, int chaveFalha, int xLocation, int yLocation) {
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
		btnVoltar.setSelectedIcon(new ImageIcon(ViewFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(ViewFalha.class.getResource("/Resources/icon/back-btn.png")));
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
		btnVoltar.setBounds(502, 398, 78, 44);
		desktopPane.add(btnVoltar);

		JTextPane nomePane = new JTextPane();
		nomePane.setEditable(false);
		nomePane.setForeground(Color.BLACK);
		nomePane.setText(sistema.getNomeFalha(chaveFalha));
		nomePane.setBounds(215, 200, 244, 29);
		desktopPane.add(nomePane);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(215, 247, 244, 93);
		desktopPane.add(jPane);

		JTextPane descricaoPane = new JTextPane();
		descricaoPane.setEditable(false);
		jPane.setViewportView(descricaoPane);
		descricaoPane.setText(sistema.getDescricaoFalha(chaveFalha));
		descricaoPane.setEditable(false);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(ViewFalha.class.getResource("/Resources/icon/insert-falha-form.png")));
		form.setBounds(123, 161, 393, 225);
		desktopPane.add(form);
		
		JLabel label = new JLabel("VISUALIZAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 33));
		label.setBounds(319, 21, 209, 40);
		desktopPane.add(label);
		
		JLabel lblFalha = new JLabel("FALHA");
		lblFalha.setForeground(Color.WHITE);
		lblFalha.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblFalha.setBounds(367, 55, 109, 40);
		desktopPane.add(lblFalha);

	}
}
