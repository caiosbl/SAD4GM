package interfaceSistema.interfaceGrafica.Admin;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
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

public class AdminSetSenha extends JFrame {

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
	public AdminSetSenha(String id) {
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
		label_1.setBounds(43, 62, 120, 34);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(21, 17, 161, 45);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JLabel lblGerenciarUsurios = new JLabel("ALTERAR");
		lblGerenciarUsurios.setBounds(358, 24, 139, 37);
		lblGerenciarUsurios.setForeground(Color.WHITE);
		lblGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblGerenciarUsurios);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 107, 593, 12);
		desktopPane.add(separator);

		JButton button = new JButton("Voltar");
		button.setBounds(492, 381, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminOptions admOptions = new AdminOptions(idAdmin);
				dispose();
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("MINHA SENHA");
		lblInformaes.setBounds(327, 60, 268, 37);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblInformaes);

		JLabel lblNome = new JLabel("Nova Senha:");
		lblNome.setBounds(143, 198, 93, 16);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNome.setForeground(Color.WHITE);
		desktopPane.add(lblNome);

		JTextPane txtpnDfdf = new JTextPane();
		txtpnDfdf.setBounds(241, 195, 268, 24);
		txtpnDfdf.setEditable(false);
		txtpnDfdf.setText(sistema.getNomeAdmin(this.idAdmin));
		desktopPane.add(txtpnDfdf);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(241, 230, 268, 24);
		textPane.setEditable(false);
		textPane.setText(idAdmin);
		desktopPane.add(textPane);

		JLabel lblId = new JLabel("Repita a nova Senha:");
		lblId.setBounds(80, 233, 161, 16);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId);

		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtpnDfdf.getText().equals("") && textPane.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Preencha os campos com a Nova Senha!");
				else if(txtpnDfdf.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Preencha o campo  Nova Senha!");
				else if(textPane.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Preencha o campo vazio com a Nova Senha!");
			}
		});
		btnAlterarSenha.setBounds(311, 267, 139, 27);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);
	}

	

}
