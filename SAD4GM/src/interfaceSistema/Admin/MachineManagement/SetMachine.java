package interfaceSistema.Admin.MachineManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class SetMachine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String codigoMaquina;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetMachine(String id, String codeMaquina) {
		this.idAdmin = id;
		this.codigoMaquina = codeMaquina;

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
		button.setBounds(496, 420, 84, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetMachineEntry setMachineEntry = new SetMachineEntry(idAdmin);
				dispose();
				setMachineEntry.setVisible(true);
				setMachineEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JLabel lblInformaes = new JLabel("MÁQUINA");
		lblInformaes.setBounds(315, 60, 152, 37);
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
		nome.setText(sistema.getNomeMaquina(codeMaquina));
		desktopPane.add(nome);

		JTextPane codigo = new JTextPane();
		codigo.setEditable(false);

		codigo.setBounds(182, 231, 268, 24);
		codigo.setText(codeMaquina);
		desktopPane.add(codigo);

		JLabel lblId = new JLabel("Código:");
		lblId.setBounds(117, 235, 55, 16);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		desktopPane.add(lblId);

		JLabel lblAuditor = new JLabel("Descrição:");
		lblAuditor.setForeground(Color.WHITE);
		lblAuditor.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAuditor.setBounds(97, 282, 74, 19);
		desktopPane.add(lblAuditor);

		JTextPane descricao = new JTextPane();
		descricao.setText(sistema.getDescricaoMaquina(codeMaquina));
		descricao.setEditable(false);
		descricao.setBounds(182, 267, 268, 92);
		
		
		JScrollPane jsp = new JScrollPane(descricao);
		
		jsp.setBounds(182, 267, 268, 92);
		desktopPane.add(jsp);
		

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.setEditable(true);
				nome.setEditable(true);
				descricao.setEditable(true);

			}
		});
		btnEditar.setBounds(182, 364, 90, 28);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasMaquina(codigo.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido!");
						nome.setText(sistema.getNomeMaquina(codigoMaquina));
						codigo.setText(codigoMaquina);
						descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
					} 
					
					else if (descricao.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Descrição inválida!");
						nome.setText(sistema.getNomeMaquina(codigoMaquina));
						codigo.setText(codigoMaquina);
						descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
					}
					
					else if (codigo.getText().equals("") || codigo.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "Código inválido!");
						nome.setText(sistema.getNomeMaquina(codigoMaquina));
						codigo.setText(codigoMaquina);
						descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
					}
					
					else if (!isNumber(codigo.getText().trim())) {
						JOptionPane.showMessageDialog(null, "Por favor insira um código númerico!");
						nome.setText(sistema.getNomeMaquina(codigoMaquina));
						codigo.setText(codigoMaquina);
						descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
					}
					
					else if (!codigo.getText().trim().equals(codigoMaquina) && has) {
						JOptionPane.showMessageDialog(null, "Código já cadastrado!");
						nome.setText(sistema.getNomeMaquina(codigoMaquina));
						codigo.setText(codigoMaquina);
						descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
					}

					else {
						nome.setEditable(false);
						codigo.setEditable(false);
						sistema.setCodigoMaquina(codeMaquina, codigo.getText().trim());
						sistema.setNomeMaquina( codigo.getText().trim(),nome.getText().trim());
						sistema.setDescricaoMaquina(codeMaquina, descricao.getText().trim());
						codigoMaquina = codigo.getText().trim();
						
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(362, 364, 90, 28);
		desktopPane.add(btnAtualizar);

	}
	
	public boolean isNumber(String password) {
		boolean status = false;

		try {
			Integer.parseInt(password);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
}
