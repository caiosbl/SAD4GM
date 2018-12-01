package interfaceGrafica.usuario.entrada;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;
import interfaceGrafica.utils.PlotGraficoPareto;
import interfaceGrafica.utils.PlotGraficoXY;
import interfaceGrafica.utils.RankingRPN;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import sistema.Sistema;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class ViewRelatorios extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema;

	private Map<String, Integer> mapaMaquinas;
	private JComboBox<Object> maquinasBox;
	private Object[] arrayMaquinas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewRelatorios(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.sistema = new Sistema();
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

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(idUsuario, getXLocation(), getYLocation());
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

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);

		JLabel lblMeus = new JLabel("VISUALIZAR");
		lblMeus.setForeground(Color.WHITE);
		lblMeus.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMeus.setBounds(67, 22, 151, 29);
		desktopPane.add(lblMeus);

		JLabel lblDados = new JLabel("RELATÓRIOS");
		lblDados.setForeground(Color.WHITE);
		lblDados.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDados.setBounds(65, 49, 157, 29);
		desktopPane.add(lblDados);

		JButton btnNewButton = new JButton("Matriz de Risco");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlotGraficoXY plot = new PlotGraficoXY(mapaMaquinas.get(arrayMaquinas[maquinasBox.getSelectedIndex()]));
				plot.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				plot.setVisible(true);
				plot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(67, 233, 151, 62);
		desktopPane.add(btnNewButton);

		JButton btnRankingRpn = new JButton("Ranking RPN");
		btnRankingRpn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingRPN plot = new RankingRPN(mapaMaquinas.get(arrayMaquinas[maquinasBox.getSelectedIndex()]));
				plot.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				plot.setVisible(true);
				plot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnRankingRpn.setBounds(230, 233, 151, 62);
		desktopPane.add(btnRankingRpn);

		JButton btnGrficoPareto = new JButton("Gráfico Pareto");
		btnGrficoPareto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlotGraficoPareto plot = new PlotGraficoPareto(
						mapaMaquinas.get(arrayMaquinas[maquinasBox.getSelectedIndex()]));
				plot.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				plot.setVisible(true);
				plot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnGrficoPareto.setBounds(393, 233, 151, 62);
		desktopPane.add(btnGrficoPareto);

		mapaMaquinas = sistema.getMapaMaquinas();
		arrayMaquinas = mapaMaquinas.keySet().toArray();
		maquinasBox = new JComboBox<Object>(arrayMaquinas);
		maquinasBox.setBounds(73, 159, 450, 41);
		desktopPane.add(maquinasBox);

		JLabel lblSelecioneUmaMquina = new JLabel("SELECIONE UMA MÁQUINA:");
		lblSelecioneUmaMquina.setForeground(Color.WHITE);
		lblSelecioneUmaMquina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneUmaMquina.setBounds(185, 138, 226, 20);
		desktopPane.add(lblSelecioneUmaMquina);

	}
}
