package interfaceGrafica.admin.gerenciadorMaquinas.editMachines;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.admin.gerenciadorMaquinas.ViewMachinesEdit;
import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import sistema.Sistema;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(490, 420, 90, 27);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(208, 215, 268, 140);
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
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isEmpty(nomeField.getText().trim())) {
					nomeField.setText(sistema.getNomeCausaPotencial(chaveCausaPotencial));
					descricaoPane.setText(sistema.getDescricaoCausaPotencial(chaveCausaPotencial));
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				}

				else if (isEmpty(descricaoPane.getText().trim())) {
					descricaoPane.setText(sistema.getDescricaoCausaPotencial(chaveCausaPotencial));
					JOptionPane.showMessageDialog(null, "Descrição Inválida");
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

		btnAtualizar.setBounds(386, 369, 90, 28);
		desktopPane.add(btnAtualizar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(
				new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/causa-potencial-banner.png")));
		banner.setBounds(274, 28, 305, 83);
		desktopPane.add(banner);

		nomeField = new JTextField();
		nomeField.setText(sistema.getNomeCausaPotencial(chaveCausaPotencial));
		nomeField.setBounds(208, 174, 268, 34);
		desktopPane.add(nomeField);
		nomeField.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SetCausaPotencial.class.getResource("/Resources/icon/causa-potencial-form.png")));
		label.setBounds(116, 160, 392, 248);
		desktopPane.add(label);

	}
}
