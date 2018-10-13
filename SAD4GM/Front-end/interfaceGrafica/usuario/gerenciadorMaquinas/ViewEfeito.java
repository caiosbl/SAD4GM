package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewEfeito extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;

	private Sistema sistema = new Sistema();
	private JTextField indiceSeveridadeField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewEfeito(String id, int chaveEfeito, int xLocation, int yLocation) {
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar
				.setSelectedIcon(new ImageIcon(ViewEfeito.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(ViewEfeito.class.getResource("/Resources/icon/back-btn.png")));
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
		btnVoltar.setBounds(521, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(35, 170, 540, 116);
		desktopPane.add(jsp);

		JTextPane descricaoPane = new JTextPane();
		jsp.setViewportView(descricaoPane);
		descricaoPane.setText(sistema.getDescricaoEfeito(chaveEfeito));
		descricaoPane.setEditable(false);

		JTextField tituloField = new JTextField();
		tituloField.setEditable(false);
		tituloField.setText(sistema.getNomeEfeito(chaveEfeito));
		tituloField.setBounds(33, 110, 547, 34);
		desktopPane.add(tituloField);
		tituloField.setColumns(10);

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

		JLabel label = new JLabel("VISUALIZAR");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(67, 22, 151, 29);
		desktopPane.add(label);

		JLabel lblModoDeFalha = new JLabel("EFEITO DE FALHA");
		lblModoDeFalha.setForeground(Color.WHITE);
		lblModoDeFalha.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModoDeFalha.setBounds(49, 47, 214, 29);
		desktopPane.add(lblModoDeFalha);

		JLabel lblNome = new JLabel("Título:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(255, 90, 58, 20);
		desktopPane.add(lblNome);

		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescrio.setBounds(248, 150, 84, 20);
		desktopPane.add(lblDescrio);

		JLabel lblIndceSeveridade = new JLabel("Indíce Severidade:");
		lblIndceSeveridade.setForeground(Color.WHITE);
		lblIndceSeveridade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndceSeveridade.setBounds(224, 289, 152, 20);
		desktopPane.add(lblIndceSeveridade);


		indiceSeveridadeField = new JTextField();
		indiceSeveridadeField.setText(String.valueOf(sistema.getIndiceSeveridade(chaveEfeito)));
		indiceSeveridadeField.setEditable(false);

		indiceSeveridadeField.setColumns(10);
		indiceSeveridadeField.setBounds(35, 308, 547, 34);
		desktopPane.add(indiceSeveridadeField);

	}
}
