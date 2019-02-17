package interfaceGrafica.usuario.gerenciadorMaquinas.Insert;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInsert;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


import sistema.Sistema;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class InsertMaquina extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();
	private JTextField name;
	private JTextPane description;
	private JTextField code;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public InsertMaquina(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
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

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setSelectedIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.setBounds(498, 408, 78, 44);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
				dispose();
				insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insert.setVisible(true);
				insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnInserir = new JButton("");
		btnInserir.setBackground(new Color(0,0,0,0));
		btnInserir.setSelectedIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/patch/insert-on.png")));
		btnInserir.setIcon(new ImageIcon(InsertMaquina.class.getResource("/Resources/icon/patch/insert-off.png")));
		btnInserir.setBounds(45, 370, 132, 34);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nome = new String(name.getText().trim());
				String codigo = new String(code.getText().trim());
				String descricao = new String(description.getText().trim());

				try {

					if (isEmpty(nome))
						JOptionPane.showMessageDialog(null, "Insira um Nome!");

					else if (isEmpty(codigo))
						JOptionPane.showMessageDialog(null, "Insira um Código!");

					else if (isEmpty(descricao))
						JOptionPane.showMessageDialog(null, "Insira uma Descrição válida!");

					else if (codigo.length() < 4) {
						JOptionPane.showMessageDialog(null, "Insira um Código de no mínimo 4 digítos!");
						code.setText("");
					} else if (!isNumber(codigo)) {
						JOptionPane.showMessageDialog(null, "Por favor insira um código numérico válido!");
						code.setText("");
					}

					else if (sistema.hasMaquina(codigo)) {
						JOptionPane.showMessageDialog(null, "Código já cadastrado!");
						code.setText("");
					}

					else {
						sistema.adicionaMaquina(nome, codigo, descricao, idUsuario);
						JOptionPane.showMessageDialog(null, "Máquina cadastrada com sucesso!");
						
						ViewMachinesInsert insert = new ViewMachinesInsert(idUsuario, getXLocation(), getYLocation());
						dispose();
						insert.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
						insert.setVisible(true);
						insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!");
				}

			}
		});
		
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewComponente.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);
		
		
		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnInserir);

		name = new JTextField();
		name.setBounds(55, 150, 518, 35);
		desktopPane.add(name);
		name.setColumns(10);

		JScrollPane jsp = new JScrollPane();

		jsp.setBounds(55, 267, 521, 91);
		desktopPane.add(jsp);
		
				description = new JTextPane();
				jsp.setViewportView(description);
				description.setEditable(true);

		code = new JTextField();
		code.setBounds(56, 210, 518, 35);
		code.setColumns(10);
		desktopPane.add(code);
		
		JLabel lblInserir = new JLabel("INSERIR");
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInserir.setBounds(67, 22, 110, 29);
		desktopPane.add(lblInserir);
		
		JLabel lblMquina = new JLabel("MÁQUINA");
		lblMquina.setForeground(Color.WHITE);
		lblMquina.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMquina.setBounds(59, 48, 120, 29);
		desktopPane.add(lblMquina);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(276, 127, 53, 20);
		desktopPane.add(lblNome);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCdigo.setBounds(274, 190, 62, 20);
		desktopPane.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescrio.setBounds(265, 247, 84, 20);
		desktopPane.add(lblDescrio);
	}

	public boolean isEmpty(String string) {
		return string.equals("");
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
