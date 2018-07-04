package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entidades.Maquina;
import interfaceGrafica.main.Main;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextPane;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewMachine extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String data = "dd/MM/yyyy";
	SimpleDateFormat formata = new SimpleDateFormat(data);
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewMachine(String id, int chaveMaquina, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
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
		btnVoltar.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMachinesInfo information = new ViewMachinesInfo(idAdmin, getXLocation(), getYLocation());
				dispose();
				information.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				information.setVisible(true);
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(484, 418, 88, 29);
		desktopPane.add(btnVoltar);
		Maquina maquina = null;
		try {
			maquina = sistema.getInfoMaquina(chaveMaquina);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Máquina Inexistente");
			ViewMachinesInfo information = new ViewMachinesInfo(idAdmin, getXLocation(), getYLocation());
			dispose();
			information.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			information.setVisible(true);
			information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		JTextPane nomePane = new JTextPane();
		nomePane.setForeground(Color.BLACK);
		nomePane.setText(maquina.getNome());
		nomePane.setBounds(164, 185, 332, 29);
		desktopPane.add(nomePane);

		JTextPane dataCadastroPane = new JTextPane();
		dataCadastroPane.setText(formata.format(maquina.getDataCadastro()));
		dataCadastroPane.setForeground(Color.BLACK);
		dataCadastroPane.setBounds(164, 222, 332, 29);
		desktopPane.add(dataCadastroPane);

		JTextPane codigoPane = new JTextPane();
		codigoPane.setText(String.valueOf(maquina.getCodigo()));
		codigoPane.setForeground(Color.BLACK);
		codigoPane.setBounds(164, 259, 332, 29);
		desktopPane.add(codigoPane);

		JTextPane descricaoPane = new JTextPane();
		descricaoPane.setText(String.valueOf(maquina.getDescricao()));
		descricaoPane.setForeground(Color.BLACK);
	

		JScrollPane jsPanel = new JScrollPane(descricaoPane);
		jsPanel.setBounds(163, 294, 335, 80);
		desktopPane.add(jsPanel);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/view-machine-title.png")));
		banner.setBounds(324, 19, 204, 106);
		desktopPane.add(banner);
		
		JTextPane usuarioCadastrouPane = new JTextPane();
		usuarioCadastrouPane.setText(maquina.getIdUsuario());
		usuarioCadastrouPane.setForeground(Color.BLACK);
		usuarioCadastrouPane.setBounds(164, 377, 332, 29);
		desktopPane.add(usuarioCadastrouPane);
		
				JLabel form = new JLabel("");
				form.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/viewMachineInfoForm.png")));
				form.setBounds(94, 161, 434, 269);
				desktopPane.add(form);

	}
}
