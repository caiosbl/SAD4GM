package interfaceSistema.Admin.MachineManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextPane;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */


public class MachineInformation extends JFrame {

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
	public MachineInformation(String id, String codigoMaquina) {
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(100, 100, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(20, 60, 141, 45);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(10, 11, 210, 73);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 605, 12);
		desktopPane.add(separator);

		JLabel lblRemover = new JLabel("INFORMAÇÃO ");
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRemover.setBounds(249, 32, 221, 37);
		desktopPane.add(lblRemover);

		JLabel lblAdmin = new JLabel("DE UMA MÁQUINA");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAdmin.setBounds(227, 68, 281, 37);
		desktopPane.add(lblAdmin);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineInformationEntry uInformation = new MachineInformationEntry(idAdmin);

				dispose();
				uInformation.setVisible(true);
				uInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(506, 388, 69, 23);
		desktopPane.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(sistema.getInfoMaquina(codigoMaquina));
		textPane.setBackground(SystemColor.textInactiveText);
		textPane.setBounds(114, 162, 394, 191);
		desktopPane.add(textPane);
	
	}
}
