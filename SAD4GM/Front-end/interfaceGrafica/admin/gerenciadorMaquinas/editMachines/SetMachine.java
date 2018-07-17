package interfaceGrafica.admin.gerenciadorMaquinas.editMachines;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.admin.gerenciadorMaquinas.ViewMachinesEdit;
import interfaceGrafica.main.Main;


import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import sistema.Sistema;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetMachine extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private String codigoMaquina;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetMachine(String idUser, int xLocation, int yLocation, int chaveMaquina) {
		super(xLocation, yLocation);
		this.idUsuario = idUser;
		try {
			this.codigoMaquina = sistema.getCodigoMaquina(chaveMaquina);
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation, yLocation, 621, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(490, 420, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesEdit viewMachinesEdit = new ViewMachinesEdit(idUsuario, getXLocation(), getYLocation());
				dispose();
				viewMachinesEdit.setVisible(true);
				viewMachinesEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);

		nome.setBounds(184, 196, 264, 24);
		nome.setText(sistema.getNomeMaquina(codigoMaquina));
		desktopPane.add(nome);

		JTextPane codigo = new JTextPane();
		codigo.setEditable(false);

		codigo.setBounds(184, 231, 264, 24);
		codigo.setText(codigoMaquina);
		desktopPane.add(codigo);

		JTextPane descricao = new JTextPane();
		descricao.setText(sistema.getDescricaoMaquina(codigoMaquina));
		descricao.setEditable(false);
		descricao.setBounds(182, 267, 268, 92);

		JScrollPane jsp = new JScrollPane(descricao);

		jsp.setBounds(182, 267, 268, 92);
		desktopPane.add(jsp);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.setEditable(true);
				nome.setEditable(true);
				descricao.setEditable(true);

			}
		});
		btnEditar.setBounds(182, 364, 90, 28);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/atualizarbutton.png")));
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
						sistema.setCodigoMaquina(codigoMaquina, codigo.getText().trim());
						sistema.setNomeMaquina(codigo.getText().trim(), nome.getText().trim());
						sistema.setDescricaoMaquina(codigoMaquina, descricao.getText().trim());
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

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/setMachineBanner.png")));
		banner.setBounds(343, 28, 175, 86);
		desktopPane.add(banner);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(SetMachine.class.getResource("/Resources/icon/formaSetMachine.png")));
		form.setBounds(97, 182, 421, 226);
		desktopPane.add(form);

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
