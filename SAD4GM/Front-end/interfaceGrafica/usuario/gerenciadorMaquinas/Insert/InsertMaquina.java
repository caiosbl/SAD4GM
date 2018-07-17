package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import sistema.Sistema;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertMaquina extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField name;
	private JTextPane description;
	private JTextField code;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public InsertMaquina(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idUsuario = id;
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
		btnVoltar.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insert.setVisible(true);
				insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/insertbutton.png")));
		btnInserir.setBounds(385, 354, 103, 21);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nome = new String(name.getText().trim());
				String codigo = new String(code.getText().trim());
				String descricao = new String(description.getText().trim());

				try {

					if (isEmpty(nome))
						JOptionPane.showMessageDialog(null, "Insira um Nome!");

					else if (isEmpty(codigo))
						JOptionPane.showMessageDialog(null, "Insira um Código!");

					else if (isEmpty(descricao))
						JOptionPane.showMessageDialog(null, "Insira uma Descrição válida!");

					else if (codigo.length() < 4) {
						JOptionPane.showMessageDialog(null, "Insira um Código de no mínimo 4 digítos!");
						code.setText("");
					} else if (!isNumber(codigo)) {
						JOptionPane.showMessageDialog(null, "Por favor insira um código numérico válido!");
						code.setText("");
					}

					else if (sistema.hasMaquina(codigo)) {
						JOptionPane.showMessageDialog(null, "Código já cadastrado!");
						code.setText("");
					}

					else {
						sistema.adicionaMaquina(nome, codigo, descricao, idUsuario);
						JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");
						Options userOptions = new Options(idUsuario, getXLocation(), getYLocation());

						dispose();
						userOptions.setVisible(true);
						userOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!");
				}

			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(223, 178, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		description = new JTextPane();
		description.setEditable(true);
		description.setBounds(251, 231, 268, 75);

		JScrollPane jsp = new JScrollPane(description);

		jsp.setBounds(223, 252, 268, 91);
		desktopPane.add(jsp);

		code = new JTextField();
		code.setBounds(223, 210, 268, 28);
		code.setColumns(10);
		desktopPane.add(code);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/inserirMaquinatitle.png")));
		banner.setBounds(335, 26, 177, 99);
		desktopPane.add(banner);

		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/insertMaquinaForm.png")));
		form.setBounds(119, 161, 393, 240);
		desktopPane.add(form);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
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
