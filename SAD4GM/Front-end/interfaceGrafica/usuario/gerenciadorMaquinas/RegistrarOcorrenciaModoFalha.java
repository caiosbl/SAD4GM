package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;

import javax.swing.JComboBox;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class RegistrarOcorrenciaModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private String idAdmin;
	private JComboBox<Object> maquinasBox;
	private JComboBox<Object> subsistemasBox;
	private JComboBox<Object> componentesBox;
	private JComboBox<Object> falhasBox;
	private JComboBox<Object> modosDeFalhaBox;

	private Object[] arrayMaquinas;
	private Object[] arraySubsistemas;
	private Object[] arrayComponentes;
	private Object[] arrayFalhas;
	private Object[] arrayModosDeFalha;

	private Map<String, Integer> mapaMaquinas;
	private Map<String, Integer> mapaSubsistemas;
	private Map<String, Integer> mapaComponentes;
	private Map<String, Integer> mapaFalhas;
	private Map<String, Integer> mapaModosFalha;

	private int chaveModoFalha;

	private Sistema sistema = new Sistema();
	private JTextField ocorrenciaField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegistrarOcorrenciaModoFalha(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.chaveModoFalha = -1;
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setSelectedIcon(
				new ImageIcon(RegistrarOcorrenciaModoFalha.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar
				.setIcon(new ImageIcon(RegistrarOcorrenciaModoFalha.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options information = new Options(id, xLocation, yLocation);

				dispose();
				information.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				information.setVisible(true);
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(521, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		homeBtn.setSelectedIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);

		JButton myDataBtn = new JButton("");
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);

		JButton logoutBtn = new JButton("");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		logoutBtn.setSelectedIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewSubsistema.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);
		JLabel navbar = new JLabel("");
		navbar.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		navbar.setBounds(350, 6, 256, 51);
		desktopPane.add(navbar);

		JLabel lblRegistrarOcorrncia = new JLabel("REGISTRAR OCORRÊNCIA");
		lblRegistrarOcorrncia.setForeground(Color.WHITE);
		lblRegistrarOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRegistrarOcorrncia.setBounds(18, 9, 313, 29);
		desktopPane.add(lblRegistrarOcorrncia);

		JLabel lblModoDeFalha = new JLabel("MODO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(73, 35, 200, 29);
		desktopPane.add(lblModoDeFalha);

		mapaMaquinas = sistema.getMapaMaquinas();
		arrayMaquinas = mapaMaquinas.keySet().toArray();

		maquinasBox = new JComboBox<Object>(arrayMaquinas);
		maquinasBox.setBounds(73, 91, 450, 41);
		maquinasBox.setSelectedIndex(-1);

		maquinasBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maquinasBox.getSelectedIndex() != -1) {
					int chaveMaquina = mapaMaquinas.get(arrayMaquinas[maquinasBox.getSelectedIndex()]);
					mapaSubsistemas = sistema.getMapaSubsistemas(chaveMaquina);
					arraySubsistemas = mapaSubsistemas.keySet().toArray();
					subsistemasBox.setModel(new DefaultComboBoxModel<>(arraySubsistemas));
					subsistemasBox.setSelectedIndex(-1);

				}
			}
		});

		desktopPane.add(maquinasBox);

		JLabel lblMquina = new JLabel("Máquina:");
		lblMquina.setForeground(Color.WHITE);
		lblMquina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMquina.setBounds(245, 76, 75, 20);
		desktopPane.add(lblMquina);

		subsistemasBox = new JComboBox<Object>();
		subsistemasBox.setBounds(73, 145, 450, 41);

		subsistemasBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (subsistemasBox.getSelectedIndex() != -1) {
					int chaveSubsistema = mapaSubsistemas.get(arraySubsistemas[subsistemasBox.getSelectedIndex()]);
					mapaComponentes = sistema.getMapaComponentes(chaveSubsistema);
					arrayComponentes = mapaComponentes.keySet().toArray();
					componentesBox.setModel(new DefaultComboBoxModel<>(arrayComponentes));
					componentesBox.setSelectedIndex(-1);

				}
			}
		});
		desktopPane.add(subsistemasBox);

		JLabel lblSubsistema = new JLabel("Subsistema:");
		lblSubsistema.setForeground(Color.WHITE);
		lblSubsistema.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubsistema.setBounds(232, 128, 99, 20);
		desktopPane.add(lblSubsistema);

		componentesBox = new JComboBox<Object>();
		componentesBox.setBounds(73, 200, 450, 41);
		componentesBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (componentesBox.getSelectedIndex() != -1) {
					int chaveComponente = mapaComponentes.get(arrayComponentes[componentesBox.getSelectedIndex()]);
					mapaFalhas = sistema.getMapaFalhas(chaveComponente);
					arrayFalhas = mapaFalhas.keySet().toArray();
					falhasBox.setModel(new DefaultComboBoxModel<>(arrayFalhas));
					falhasBox.setSelectedIndex(-1);

				}
			}
		});
		desktopPane.add(componentesBox);

		JLabel lblComponente = new JLabel("Componente:");
		lblComponente.setForeground(Color.WHITE);
		lblComponente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComponente.setBounds(232, 183, 109, 20);
		desktopPane.add(lblComponente);

		JLabel lblFalha = new JLabel("Falha:");
		lblFalha.setForeground(Color.WHITE);
		lblFalha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFalha.setBounds(267, 240, 50, 20);
		desktopPane.add(lblFalha);

		falhasBox = new JComboBox<Object>();
		falhasBox.setBounds(73, 258, 450, 41);
		falhasBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (falhasBox.getSelectedIndex() != -1) {
					int chaveFalha = mapaFalhas.get(arrayFalhas[falhasBox.getSelectedIndex()]);
					mapaModosFalha = sistema.getMapaModosFalha(chaveFalha);
					arrayModosDeFalha = sistema.getMapaModosFalha(chaveFalha).keySet().toArray();
					modosDeFalhaBox.setModel(new DefaultComboBoxModel<>(arrayModosDeFalha));
					modosDeFalhaBox.setSelectedIndex(-1);

				}
			}
		});
		desktopPane.add(falhasBox);

		JLabel lblModoDeFalha_1 = new JLabel("Modo de Falha:");
		lblModoDeFalha_1.setForeground(Color.WHITE);
		lblModoDeFalha_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModoDeFalha_1.setBounds(232, 297, 124, 20);

		desktopPane.add(lblModoDeFalha_1);

		modosDeFalhaBox = new JComboBox<Object>();
		modosDeFalhaBox.setBounds(73, 315, 450, 41);
		modosDeFalhaBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modosDeFalhaBox.getSelectedIndex() != -1) {
					chaveModoFalha = mapaModosFalha.get(arrayModosDeFalha[modosDeFalhaBox.getSelectedIndex()]);
					atualizaNumeroOcorrencias(chaveModoFalha);

				}
			}
		});
		desktopPane.add(modosDeFalhaBox);

		JLabel lblI = new JLabel("Número de Ocorrências:");
		lblI.setForeground(Color.WHITE);
		lblI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblI.setBounds(114, 368, 167, 17);
		desktopPane.add(lblI);

		ocorrenciaField = new JTextField();
		ocorrenciaField.setEditable(false);
		ocorrenciaField.setBounds(126, 387, 144, 32);
		desktopPane.add(ocorrenciaField);
		ocorrenciaField.setColumns(10);

		JButton btnRegistarOcorrncia = new JButton("Registar Ocorrência");
		btnRegistarOcorrncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checaBoxs() && chaveModoFalha >= 0 ) {
					JOptionPane.showMessageDialog(null, sistema.registrarOcorrenciaModoFalha(chaveModoFalha));

					atualizaNumeroOcorrencias(chaveModoFalha);
				}
			}
		});
		btnRegistarOcorrncia.setBounds(325, 387, 138, 28);
		desktopPane.add(btnRegistarOcorrncia);

	}

	private void atualizaNumeroOcorrencias(int chaveModoFalha) {
		this.ocorrenciaField.setText(String.valueOf(sistema.getNumeroOcorrencias(chaveModoFalha)));
	}

	private boolean checaBoxs() {
		if (maquinasBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor selecione uma Máquina!");
			return false;

		} else if (subsistemasBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor selecione um Subsistema!");
			return false;
		} else if (componentesBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor selecione um Componente!");
			return false;
		} else if (falhasBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor selecione uma Falha!");
			return false;
		} else if (modosDeFalhaBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor selecione um Modo de Falha!");
			return false;

		} else
			return true;
	}
}
