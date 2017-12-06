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
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenu;

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
		desktopPane.setLayout(null);
		
		JLabel label_1 = new JLabel("DeSiDeS");
		label_1.setBounds(20, 60, 141, 45);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(10, 11, 210, 73);
		label_2.setForeground(new Color(0, 0, 51));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);
		
		JButton btnMinhasInformaes = new JButton("Alterar Senha");
		btnMinhasInformaes.setBounds(53, 164, 181, 23);
		desktopPane.add(btnMinhasInformaes);
		
		JButton button = new JButton("Minhas Informações");
		button.setBounds(53, 137, 181, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		desktopPane.add(button);
		
		JMenu mnUsurio = new JMenu("Usuário");
		mnUsurio.setBounds(53, 210, 105, 19);
		desktopPane.add(mnUsurio);
		
		JButton btnNewButton = new JButton("Inserir Usuário");
		mnUsurio.add(btnNewButton);
		
		JButton btnVisualizarMquinas = new JButton("Remover Usuário");
		mnUsurio.add(btnVisualizarMquinas);
		
		JButton btnInserirFuno = new JButton("Alterar Senha Usuário");
		mnUsurio.add(btnInserirFuno);
		
		JButton btnVerMquinas = new JButton("Alterar Usuário");
		mnUsurio.add(btnVerMquinas);
		
		JButton btnListarUsurios = new JButton("Listar Usuários");
		mnUsurio.add(btnListarUsurios);
		
		JMenu mnMquinas = new JMenu("Máquinas");
		mnMquinas.setBounds(53, 234, 105, 19);
		desktopPane.add(mnMquinas);
		
		JButton btnListarMquinas = new JButton("Listar Máquinas");
		mnMquinas.add(btnListarMquinas);
		
		JButton btnRemoverMquina = new JButton("Visualizar Máquina");
		mnMquinas.add(btnRemoverMquina);
		
		JButton btnRemoverMquina_1 = new JButton("Remover Máquina");
		mnMquinas.add(btnRemoverMquina_1);
		
		JButton btnAlterarMquina = new JButton("Alterar Máquina");
		mnMquinas.add(btnAlterarMquina);
		btnListarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInserirFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
