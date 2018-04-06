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
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetMachineEntry extends Entrada {

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
	public SetMachineEntry(String id, int xLocation, int yLocation) {
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
		btnVoltar.setIcon(new ImageIcon(SetMachineEntry.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions machineOptions = new MachineManagementOptions(idAdmin,getXLocation(),getYLocation());

				dispose();
				machineOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				machineOptions.setVisible(true);
				machineOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(493, 388, 82, 28);
		desktopPane.add(btnVoltar);

		codigo = new JTextField();
		codigo.setBounds(200, 248, 206, 28);
		desktopPane.add(codigo);
		codigo.setColumns(10);

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(SetMachineEntry.class.getResource("/Resources/icon/alterarbutton.png")));
		btnAlterar.addActionListener(new ActionListener() {
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
						SetMachine setMachine = new SetMachine(idAdmin, codigo.getText().trim(),getXLocation(),getYLocation());
						dispose();
						setMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						setMachine.setVisible(true);
						setMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(331, 277, 75, 23);
		desktopPane.add(btnAlterar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetMachineEntry.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetMachineEntry.class.getResource("/Resources/icon/setMachineBanner.png")));
		banner.setBounds(336, 29, 175, 86);
		desktopPane.add(banner);
		
		JLabel backForm = new JLabel("");
		backForm.setIcon(new ImageIcon(SetMachineEntry.class.getResource("/Resources/icon/setMachineEntryForm.png")));
		backForm.setBounds(114, 165, 376, 178);
		desktopPane.add(backForm);

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
