package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertComponente extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private JTextField name;
	private JTextPane function;
	@SuppressWarnings("rawtypes")
	private JComboBox boxSubsistemas;
	private Map<String, Integer> mapaSubsistemas;
	private Object[] nomesSubsistemas;
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
	public InsertComponente(String id, int xLocation, int yLocation) {
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
		btnVoltar.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/voltabut.png")));
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
		btnInserir.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/insertbutton.png")));
		btnInserir.setBounds(333, 362, 103, 21);

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = new String(name.getText().trim());
				String funcao = new String(function.getText().trim());
		

				if (isEmpty(nome))
					JOptionPane.showMessageDialog(null, "Nome Inválido");
				else if (isEmpty(funcao))
					JOptionPane.showMessageDialog(null, "Função Inválida");
				else {
					int chaveSubsistema = mapaSubsistemas.get(nomesSubsistemas[boxSubsistemas.getSelectedIndex()]);
					String status = sistema.inserirComponente(nome, chaveSubsistema, funcao);
					JOptionPane.showMessageDialog(null, status);

				}

			}
		});

		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(172, 194, 268, 28);
		desktopPane.add(name);
		name.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/inserirComponenteTitle.png")));
		banner.setBounds(333, 40, 183, 68);
		desktopPane.add(banner);

		mapaSubsistemas = getMapaSubsistemas();

		nomesSubsistemas = mapaSubsistemas.keySet().toArray();
		boxSubsistemas = new JComboBox(nomesSubsistemas);

		boxSubsistemas.setBounds(172, 323, 268, 27);
		desktopPane.add(boxSubsistemas);
						
						JScrollPane jsp = new JScrollPane();
						jsp.setBounds(172, 226, 268, 91);
						desktopPane.add(jsp);
						
						function = new JTextPane();
						jsp.setViewportView(function);
						function.setEditable(true);
						
								JLabel backForm = new JLabel("");
								backForm.setIcon(new ImageIcon(InsertComponente.class.getResource("/Resources/icon/backformComponente.png")));
								backForm.setBounds(74, 175, 428, 226);
								desktopPane.add(backForm);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
	}

	public Map<String, Integer> getMapaSubsistemas() {
		return sistema.getMapaSubsistemas();
	}
}
