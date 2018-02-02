package interfaceSistema.interfaceGrafica.Admin.UserManagement;

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
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idUser;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetUser(String id, String idUser) {
		this.idAdmin = id;
		this.idUser = idUser;

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
		lblGerenciarUsurios.setBounds(315, 24, 139, 37);
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
				SetUserEntry setUserEntry = new SetUserEntry(idAdmin);
				dispose();
				setUserEntry.setVisible(true);
				setUserEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("USUÁRIO");
		lblInformaes.setBounds(315, 60, 144, 37);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblInformaes);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(131, 199, 55, 16);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNome.setForeground(Color.WHITE);
		desktopPane.add(lblNome);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);

		nome.setBounds(182, 196, 268, 24);
		nome.setText(sistema.getNomeUsuario(this.idUser));
		desktopPane.add(nome);

		JTextPane userID = new JTextPane();
		userID.setEditable(false);

		userID.setBounds(182, 231, 268, 24);
		userID.setText(idUser);
		desktopPane.add(userID);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(154, 234, 55, 16);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId);

		JLabel lblAuditor = new JLabel("Auditor:");
		lblAuditor.setForeground(Color.WHITE);
		lblAuditor.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAuditor.setBounds(117, 270, 55, 16);
		desktopPane.add(lblAuditor);

		JTextPane auditor = new JTextPane();
		auditor.setText(sistema.getNomeAuditor(this.idUser));
		auditor.setEditable(false);
		auditor.setBounds(182, 267, 268, 24);
		desktopPane.add(auditor);

		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetUserPassword setUserPassword = new SetUserPassword(idAdmin, idUser);
				dispose();
				setUserPassword.setVisible(true);
				setUserPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAlterarSenha.setBounds(43, 381, 139, 27);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userID.setEditable(true);
				nome.setEditable(true);
				auditor.setEditable(true);

			}
		});
		btnEditar.setBounds(182, 302, 90, 28);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasIdUsuario(userID.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (auditor.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Auditor inválido");
						nome.setText(sistema.getNomeUsuario(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (userID.getText().equals("") || userID.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "ID inválido");
						nome.setText(sistema.getNomeAdmin(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					} else if (!userID.getText().trim().equals(idUser) && has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						nome.setText(sistema.getNomeAdmin(idUser));
						userID.setText(idUser);
						auditor.setText(sistema.getNomeAuditor(idUser));
					}

					else {
						nome.setEditable(false);
						userID.setEditable(false);
						sistema.setIdUsuario(idUser, userID.getText().trim());
						sistema.setNomeUsuario(nome.getText().trim(), idUser);
						sistema.setAuditorUsuario(idUser, auditor.getText().trim());
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(360, 302, 90, 28);
		desktopPane.add(btnAtualizar);

	}
}
