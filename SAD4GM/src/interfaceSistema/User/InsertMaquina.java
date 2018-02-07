package interfaceSistema.User;

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

import sistema.Sistema;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertMaquina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField name;
	private JTextField description;
	private JTextField code;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public InsertMaquina(String id) {
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

		JLabel lblGerenciarUsurios = new JLabel("INSERIR");
		lblGerenciarUsurios.setBounds(377, 24, 139, 37);
		lblGerenciarUsurios.setForeground(Color.WHITE);
		lblGerenciarUsurios.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblGerenciarUsurios);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 107, 593, 12);
		desktopPane.add(separator);

		JButton button = new JButton("Voltar");
		button.setBounds(495, 418, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options uOptions = new Options(idUsuario);
				dispose();
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("USUÁRIO");
		lblInformaes.setBounds(377, 60, 144, 37);
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane.add(lblInformaes);

		JButton btnAlterarSenha = new JButton("Inserir");
		btnAlterarSenha.setBounds(404, 318, 112, 27);
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nome = new String(name.getText().trim());
				String codigo = new String(code.getText().trim());
				String descricao = new String(description.getText().trim());

				boolean has = false;

				try {
					has = sistema.hasMaquina(codigo);
					if (isEmpty(nome))
						JOptionPane.showMessageDialog(null, "Insira um Nome!");
					else if (isEmpty(codigo))
						JOptionPane.showMessageDialog(null, "Insira um Código!");
					else if (isEmpty(descricao))
						JOptionPane.showMessageDialog(null, "Insira uma Descrição válida!");
					else if (codigo.length() < 4) {
						JOptionPane.showMessageDialog(null, "Insira um ID de no mínimo 4 caracteres!");
						code.setText("");
					}

					else if (has) {
						JOptionPane.showMessageDialog(null, "Código já cadastrado!");
						code.setText("");
					}

					else {
						sistema.adicionaMaquina(nome, codigo, descricao, idUsuario);
						JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");
						Options userOptions = new Options(idUsuario);
						dispose();
						userOptions.setVisible(true);
						userOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!");
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		name = new JTextField();
		name.setBounds(251, 157, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel nome = new JLabel("Nome:");
		nome.setBounds(198, 161, 44, 19);
		nome.setForeground(Color.WHITE);
		nome.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(nome);

		description = new JTextField();
		description.setBounds(251, 231, 268, 75);
		description.setColumns(10);
		desktopPane.add(description);

		JLabel auditor = new JLabel("Descrição:");
		auditor.setBounds(168, 258, 74, 19);
		auditor.setForeground(Color.WHITE);
		auditor.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(auditor);

		code = new JTextField();
		code.setBounds(251, 189, 268, 28);
		code.setColumns(10);
		desktopPane.add(code);

		JLabel idUsuario = new JLabel("Código:");
		idUsuario.setBounds(188, 192, 54, 19);
		idUsuario.setForeground(Color.WHITE);
		idUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(idUsuario);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
	}

	
}
