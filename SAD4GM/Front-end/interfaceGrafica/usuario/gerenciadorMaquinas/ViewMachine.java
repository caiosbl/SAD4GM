package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import entidades.Maquina;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setBounds(521, 408, 78, 44);
		btnVoltar.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/back-btn.png")));
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
		nomePane.setEditable(false);
		nomePane.setBounds(47, 124, 476, 29);
		nomePane.setForeground(Color.BLACK);
		nomePane.setText(maquina.getNome());
		desktopPane.add(nomePane);

		JTextPane dataCadastroPane = new JTextPane();
		dataCadastroPane.setEditable(false);
		dataCadastroPane.setBounds(47, 180, 476, 29);
		dataCadastroPane.setText(formata.format(maquina.getDataCadastro()));
		dataCadastroPane.setForeground(Color.BLACK);
		desktopPane.add(dataCadastroPane);

		JTextPane codigoPane = new JTextPane();
		codigoPane.setEditable(false);
		codigoPane.setBounds(47, 234, 476, 29);
		codigoPane.setText(String.valueOf(maquina.getCodigo()));
		codigoPane.setForeground(Color.BLACK);
		desktopPane.add(codigoPane);

		JScrollPane jsPanel = new JScrollPane();
		jsPanel.setBounds(45, 285, 480, 80);
		desktopPane.add(jsPanel);
		
				JTextPane descricaoPane = new JTextPane();
				jsPanel.setViewportView(descricaoPane);
				descricaoPane.setEditable(false);
				descricaoPane.setText(String.valueOf(maquina.getDescricao()));
				descricaoPane.setForeground(Color.BLACK);

		JTextPane usuarioCadastrouPane = new JTextPane();
		usuarioCadastrouPane.setEditable(false);
		usuarioCadastrouPane.setBounds(47, 386, 476, 29);
		usuarioCadastrouPane.setText(maquina.getIdUsuario());
		usuarioCadastrouPane.setForeground(Color.BLACK);
		desktopPane.add(usuarioCadastrouPane);
		
		JLabel label_1 = new JLabel("VISUALIZAR");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(67, 22, 151, 29);
		desktopPane.add(label_1);
		
		JLabel lblMquina = new JLabel("MÁQUINA");
		lblMquina.setForeground(Color.WHITE);
		lblMquina.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMquina.setBounds(80, 45, 120, 29);
		desktopPane.add(lblMquina);
		
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
		homeBtn.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/home-off.png")));
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
		myDataBtn.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/my-data-off.png")));
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
		logoutBtn.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(251, 104, 53, 20);
		desktopPane.add(lblNome);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro:");
		lblDataDeCadastro.setForeground(Color.WHITE);
		lblDataDeCadastro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataDeCadastro.setBounds(206, 162, 148, 20);
		desktopPane.add(lblDataDeCadastro);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCdigo.setBounds(251, 215, 62, 20);
		desktopPane.add(lblCdigo);
				
				JLabel lblDescrio = new JLabel("Descrição:");
				lblDescrio.setForeground(Color.WHITE);
				lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblDescrio.setBounds(243, 267, 84, 20);
				desktopPane.add(lblDescrio);
				
				JLabel lblCadastradaPor = new JLabel("Cadastrada por:");
				lblCadastradaPor.setForeground(Color.WHITE);
				lblCadastradaPor.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCadastradaPor.setBounds(225, 365, 131, 20);
				desktopPane.add(lblCadastradaPor);

	}
}


