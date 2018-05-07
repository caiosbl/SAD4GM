package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Options;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

import javax.swing.JTextField;

import javax.swing.ImageIcon;

import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertSubsistema extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextField name;
	@SuppressWarnings("rawtypes")
	private JComboBox boxMaquinas;
	private Map<String, Integer> mapaMaquinas;
	private Object[] nomesMaquinas;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InsertSubsistema(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		sistema = new Sistema();
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
		btnVoltar.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(489, 418, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options uOptions = new Options(idUsuario, getXLocation(), getYLocation());
				dispose();
				uOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				uOptions.setVisible(true);
				uOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/insertbutton.png")));
		btnInserir.setBounds(357, 322, 103, 21);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = new String(name.getText().trim());

				if (isEmpty(nome))
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				else {
					int chaveMaquina = mapaMaquinas.get(nomesMaquinas[boxMaquinas.getSelectedIndex()]);
					String status = sistema.inserirSubsistema(nome, chaveMaquina);
					JOptionPane.showMessageDialog(null, status);

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(196, 242, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/INSERTSUBbanner.png")));
		banner.setBounds(332, 32, 172, 82);
		desktopPane.add(banner);

		mapaMaquinas = getMapaMaquinas();

		nomesMaquinas = mapaMaquinas.keySet().toArray();
		boxMaquinas = new JComboBox(nomesMaquinas);

		boxMaquinas.setBounds(196, 277, 268, 27);
		desktopPane.add(boxMaquinas);

		JLabel backForm = new JLabel("");
		backForm.setIcon(new ImageIcon(InsertSubsistema.class.getResource("/Resources/icon/backFormSubsistema.png")));
		backForm.setBounds(101, 185, 409, 185);
		desktopPane.add(backForm);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
	}

	public Map<String, Integer> getMapaMaquinas() {
		return sistema.getMapaMaquinas();
	}

}
