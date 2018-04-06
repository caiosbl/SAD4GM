package interfaceGrafica.Admin.MachineManagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.Entrada;
import sistema.Sistema;

import javax.swing.JDesktopPane;
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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class MachineRemove extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTextField idField;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MachineRemove(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SAD4GM");
		setResizable(false);
		setBounds(xLocation,yLocation, 621, 497);
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
		btnVoltar.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				machineOptions.setVisible(true);
				machineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(492, 388, 83, 23);
		desktopPane.add(btnVoltar);

		idField = new JTextField();
		idField.setBounds(200, 248, 206, 28);
		desktopPane.add(idField);
		idField.setColumns(10);

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/removebutton.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().trim().length() < 4) {
					JOptionPane.showMessageDialog(null, "Código Inválido!");
					idField.setText("");
				}

				else if (!isNumber(idField.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Por favor insira um código numérico válido!");
					idField.setText("");

				} else {
					boolean has = false;
					try {
						has = sistema.hasMaquina(idField.getText().trim());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados!");
					}

					if (!has) {
						JOptionPane.showMessageDialog(null, "Máquina inexistente!");
						idField.setText("");
					} else {
						sistema.removerMaquina(idField.getText().trim());
						JOptionPane.showMessageDialog(null, "Máquina removida com Sucesso!");

						MachineManagementOptions admMOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());
						dispose();
						admMOptions.setIconImage(
								new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						admMOptions.setVisible(true);
						admMOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(311, 280, 95, 27);
		desktopPane.add(btnRemover);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/machineRemoveBanner.png")));
		banner.setBounds(328, 25, 206, 101);
		desktopPane.add(banner);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MachineRemove.class.getResource("/Resources/icon/removeForm.png")));
		label.setBounds(83, 158, 434, 195);
		desktopPane.add(label);

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
