package interfaceSistema.User;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Options extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Options(String id) {
		this.idUsuario = id;

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

		JButton btnNewButton = new JButton("Inserir Máquina");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(53, 165, 181, 29);
		desktopPane.add(btnNewButton);

		JButton btnVisualizarMquinas = new JButton("Visualizar Máquinas");
		btnVisualizarMquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVisualizarMquinas.setBounds(53, 226, 181, 29);
		desktopPane.add(btnVisualizarMquinas);

		JButton btnInserirFuno = new JButton("Inserir Função");
		btnInserirFuno.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInserirFuno.setBounds(53, 195, 181, 29);
		desktopPane.add(btnInserirFuno);

		JButton button = new JButton("Minhas Informações");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(idUsuario);
				dispose();
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(53, 256, 181, 29);
		desktopPane.add(button);

		JLabel label = new JLabel("DeSiDeS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(16, 67, 141, 45);
		desktopPane.add(label);

		JLabel label_1 = new JLabel("SAD4GM");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_1.setBounds(6, 18, 210, 73);
		desktopPane.add(label_1);

		JButton button_1 = new JButton("Logout");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login userLogin = new Login();
				dispose();
				userLogin.setVisible(true);
				userLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(497, 40, 81, 27);
		desktopPane.add(button_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 116, 605, 12);
		desktopPane.add(separator);
	}
}
