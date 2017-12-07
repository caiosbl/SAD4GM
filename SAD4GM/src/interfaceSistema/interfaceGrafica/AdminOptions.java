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
		
		JButton btnMinhasInformaes = new JButton("Alterar Senha");
		btnMinhasInformaes.setBounds(361, 11, 181, 23);
		desktopPane.add(btnMinhasInformaes);
		
		JButton btnGerenciarUsurios = new JButton("Gerenciar Usuários");
		btnGerenciarUsurios.setBounds(68, 217, 175, 41);
		btnGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerenciarUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		desktopPane.add(btnGerenciarUsurios);
		
		JButton btnGerenciarMquinas = new JButton("Gerenciar Máquinas");
		btnGerenciarMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGerenciarMquinas.setBounds(68, 262, 175, 41);
		btnGerenciarMquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarMquinas);
		
		JButton btnMinhasInformaes_1 = new JButton("Minhas Informações");
		btnMinhasInformaes_1.setBounds(68, 310, 175, 41);
		btnMinhasInformaes_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnMinhasInformaes_1);
		
		JButton btnGerenciarAdmins = new JButton("Gerenciar Admins");
		btnGerenciarAdmins.setBounds(68, 169, 175, 41);
		btnGerenciarAdmins.setFont(new Font("Tahoma", Font.BOLD, 14));
		desktopPane.add(btnGerenciarAdmins);
	}
}
