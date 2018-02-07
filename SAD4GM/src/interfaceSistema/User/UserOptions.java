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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class UserOptions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public UserOptions(String id) {
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(53, 229, 181, 23);
		desktopPane.add(btnNewButton);
		
		JButton btnVisualizarMquinas = new JButton("Visualizar Máquinas");
		btnVisualizarMquinas.setBounds(53, 288, 181, 23);
		desktopPane.add(btnVisualizarMquinas);
		
		JButton btnInserirFuno = new JButton("Inserir Função");
		btnInserirFuno.setBounds(53, 259, 181, 23);
		desktopPane.add(btnInserirFuno);
		
		JButton btnMinhasInformaes = new JButton("Alterar Senha");
		btnMinhasInformaes.setBounds(53, 195, 181, 23);
		desktopPane.add(btnMinhasInformaes);
		
		JButton button = new JButton("Minhas Informações");
		button.setBounds(53, 164, 181, 23);
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
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(497, 40, 81, 27);
		desktopPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 116, 605, 12);
		desktopPane.add(separator);
	}
}
