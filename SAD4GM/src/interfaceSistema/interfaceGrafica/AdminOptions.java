package interfaceSistema.interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class AdminOptions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminOptions() {
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
		
		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label_1.setBounds(20, 60, 141, 45);
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setForeground(new Color(0, 0, 51));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		label_2.setBounds(10, 11, 210, 73);
		desktopPane.add(label_2);
		
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
	}
}
