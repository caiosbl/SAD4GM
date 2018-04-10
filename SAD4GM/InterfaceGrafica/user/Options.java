package user;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entrada.Entrada;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Options extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Options(String id, int xLocation, int yLocation) {
		super(xLocation,yLocation);
		this.idUsuario = id;

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

		JButton btnInserirMaquina = new JButton("");
		btnInserirMaquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/insertMachineButton.png")));
		btnInserirMaquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInserirMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertMaquina insertMaquina = new InsertMaquina(idUsuario,getXLocation(),getYLocation());
				dispose();
				insertMaquina.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				insertMaquina.setVisible(true);
				insertMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnInserirMaquina.setBounds(0, 191, 249, 73);
		desktopPane.add(btnInserirMaquina);

		JButton btnListarMaquinas = new JButton("");
		btnListarMaquinas.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/listmachineicon.png")));
		btnListarMaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachinesList listarMaquinas = new MachinesList(idUsuario,getXLocation(),getYLocation());
				dispose();
				listarMaquinas.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				listarMaquinas.setVisible(true);
				listarMaquinas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnListarMaquinas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarMaquinas.setBounds(0, 277, 249, 73);
		desktopPane.add(btnListarMaquinas);

		JButton btnInserirFuncao = new JButton("");
		btnInserirFuncao.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/insertFunctionIcon.png")));
		btnInserirFuncao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInserirFuncao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInserirFuncao.setBounds(356, 191, 249, 73);
		desktopPane.add(btnInserirFuncao);

		JButton btnMinhasInformacoes = new JButton("");
		btnMinhasInformacoes.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/myinformationicon.png")));
		btnMinhasInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(idUsuario,getXLocation(),getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		btnMinhasInformacoes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinhasInformacoes.setBounds(336, 54, 122, 27);
		desktopPane.add(btnMinhasInformacoes);

		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/logouticon.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada(getXLocation(),getYLocation());
				dispose();
				entrada.setVisible(true);
				entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(470, 54, 81, 27);
		desktopPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);
		
		JButton btnVerUmaMquina = new JButton("");
		btnVerUmaMquina.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/viewmachineicon.png")));
		btnVerUmaMquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineInformationEntry verMaquina = new MachineInformationEntry(idUsuario,getXLocation(),getYLocation());
				dispose();
				verMaquina.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				verMaquina.setVisible(true);
				verMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVerUmaMquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerUmaMquina.setBounds(356, 277, 249, 73);
		desktopPane.add(btnVerUmaMquina);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Options.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
	}
}
