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
		btnVoltar.setBounds(514, 414, 78, 44);
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
		nomePane.setBounds(185, 155, 332, 29);
		nomePane.setForeground(Color.BLACK);
		nomePane.setText(maquina.getNome());
		desktopPane.add(nomePane);

		JTextPane dataCadastroPane = new JTextPane();
		dataCadastroPane.setEditable(false);
		dataCadastroPane.setBounds(185, 190, 332, 29);
		dataCadastroPane.setText(formata.format(maquina.getDataCadastro()));
		dataCadastroPane.setForeground(Color.BLACK);
		desktopPane.add(dataCadastroPane);

		JTextPane codigoPane = new JTextPane();
		codigoPane.setEditable(false);
		codigoPane.setBounds(185, 225, 332, 29);
		codigoPane.setText(String.valueOf(maquina.getCodigo()));
		codigoPane.setForeground(Color.BLACK);
		desktopPane.add(codigoPane);

		JScrollPane jsPanel = new JScrollPane();
		jsPanel.setBounds(182, 260, 335, 80);
		desktopPane.add(jsPanel);
		
				JTextPane descricaoPane = new JTextPane();
				jsPanel.setViewportView(descricaoPane);
				descricaoPane.setEditable(false);
				descricaoPane.setText(String.valueOf(maquina.getDescricao()));
				descricaoPane.setForeground(Color.BLACK);

		JTextPane usuarioCadastrouPane = new JTextPane();
		usuarioCadastrouPane.setEditable(false);
		usuarioCadastrouPane.setBounds(185, 345, 332, 29);
		usuarioCadastrouPane.setText(maquina.getIdUsuario());
		usuarioCadastrouPane.setForeground(Color.BLACK);
		desktopPane.add(usuarioCadastrouPane);

		JLabel form = new JLabel("");
		form.setBounds(16, 136, 559, 253);
		form.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/newform.png")));
		desktopPane.add(form);
		
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
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/home-on.png")));
		button.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/home-off.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 0, 0, 0));
		button.setBounds(349, 9, 62, 44);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_1.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/my-data-on.png")));
		button_1.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/my-data-off.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(new Color(0, 0, 0, 0));
		button_1.setBounds(404, 9, 119, 45);
		desktopPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_2.setSelectedIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/logout-on.png")));
		button_2.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/logout-off.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(new Color(0, 0, 0, 0));
		button_2.setBounds(499, 9, 119, 45);
		desktopPane.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);

	}
}


