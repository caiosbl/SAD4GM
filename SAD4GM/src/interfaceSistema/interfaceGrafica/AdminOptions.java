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
import javax.swing.JMenuBar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

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
		
		JButton btnMinhasnInformaes = new JButton("Minhas  Informações");
		btnMinhasnInformaes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMinhasnInformaes.setBounds(310, 58, 156, 60);
		btnMinhasnInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		desktopPane.add(btnMinhasnInformaes);
		
		
		
		JButton btnNewButton = new JButton("Inserir Usuário");
		btnNewButton.setBounds(36, 270, 170, 27);
		desktopPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnVisualizarMquinas = new JButton("Remover Usuário");
		btnVisualizarMquinas.setBounds(36, 297, 170, 27);
		desktopPane.add(btnVisualizarMquinas);
		btnVisualizarMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnInserirFuno = new JButton("Alterar Senha Usuário");
		btnInserirFuno.setBounds(36, 324, 170, 27);
		desktopPane.add(btnInserirFuno);
		btnInserirFuno.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnVerMquinas = new JButton("Alterar Usuário");
		btnVerMquinas.setBounds(36, 351, 170, 27);
		desktopPane.add(btnVerMquinas);
		btnVerMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnListarUsurios = new JButton("Listar Usuários");
		btnListarUsurios.setBounds(36, 378, 170, 27);
		desktopPane.add(btnListarUsurios);
		btnListarUsurios.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnListarMquinas = new JButton("Listar Máquinas");
		btnListarMquinas.setBounds(350, 270, 156, 27);
		desktopPane.add(btnListarMquinas);
		btnListarMquinas.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRemoverMquina = new JButton("Visualizar Máquina");
		btnRemoverMquina.setBounds(350, 297, 156, 27);
		desktopPane.add(btnRemoverMquina);
		btnRemoverMquina.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnRemoverMquina_1 = new JButton("Remover Máquina");
		btnRemoverMquina_1.setBounds(350, 324, 156, 27);
		desktopPane.add(btnRemoverMquina_1);
		btnRemoverMquina_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnAlterarMquina = new JButton("Alterar Máquina");
		btnAlterarMquina.setBounds(350, 351, 156, 27);
		desktopPane.add(btnAlterarMquina);
		btnAlterarMquina.setFont(new Font("Tahoma", Font.BOLD, 12));
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
