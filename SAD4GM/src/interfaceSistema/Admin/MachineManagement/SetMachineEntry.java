package interfaceSistema.Admin.MachineManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Sistema;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetMachineEntry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTextField codigo;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetMachineEntry(String id) {
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
		label_1.setBounds(20, 60, 141, 45);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("SAD4GM");
		label_2.setBounds(10, 11, 210, 73);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		desktopPane.add(label_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 605, 12);
		desktopPane.add(separator);

		JLabel lblRemover = new JLabel("ALTERAR");
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRemover.setBounds(286, 23, 150, 37);
		desktopPane.add(lblRemover);

		JLabel lblAdmin = new JLabel("MÁQUINA");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAdmin.setBounds(286, 63, 152, 37);
		desktopPane.add(lblAdmin);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineOptions = new MachineManagementOptions(idAdmin);

				dispose();
				machineOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineOptions.setVisible(true);
				machineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(506, 388, 69, 23);
		desktopPane.add(button);

		codigo = new JTextField();
		codigo.setBounds(200, 248, 206, 28);
		desktopPane.add(codigo);
		codigo.setColumns(10);

		JLabel lblIdDoAdmin = new JLabel("Código da Máquina a ser alterada:");
		lblIdDoAdmin.setForeground(Color.WHITE);
		lblIdDoAdmin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIdDoAdmin.setBounds(179, 218, 239, 19);
		desktopPane.add(lblIdDoAdmin);

		JButton btnRemover = new JButton("Alterar");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (codigo.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "Código Inválido!");
					codigo.setText("");
				}
				else if(!isNumber(codigo.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Por favor insira um código numérico válido!");
					codigo.setText("");
				}
				else {
					boolean has = false;

					try {
						has = sistema.hasMaquina(codigo.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Máquina inexistente!");
						codigo.setText("");
					}

					else {
						SetMachine setMachine = new SetMachine(idAdmin, codigo.getText().trim());
						dispose();
						setMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						setMachine.setVisible(true);
						setMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(311, 280, 95, 27);
		desktopPane.add(btnRemover);

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
