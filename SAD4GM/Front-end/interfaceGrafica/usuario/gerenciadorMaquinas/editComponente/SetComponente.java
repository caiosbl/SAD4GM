package interfaceGrafica.usuario.gerenciadorMaquinas.editComponente;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.main.Main;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import sistema.Sistema;
import javax.swing.ImageIcon;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class SetComponente extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private String codigoMaquina;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetComponente(String idUser, int xLocation, int yLocation, int chaveMaquina, int chaveSubsistema, int chaveComponente) {
		super(xLocation, yLocation);
		this.idUsuario = idUser;
		try {
			this.codigoMaquina = sistema.getCodigoMaquina(chaveMaquina);
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão com o Banco de Dados!");
		}

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
		btnVoltar.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(490, 420, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditComponentOptions compOptions = new EditComponentOptions(idUsuario, xLocation, yLocation, chaveMaquina, chaveSubsistema, chaveComponente);
				dispose();
				compOptions.setVisible(true);
				compOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);
		nome.setBounds(190, 200, 264, 24);
		nome.setText(sistema.getNomeSubsistema(chaveSubsistema));
		desktopPane.add(nome);
		
		JTextPane funcaoPane = new JTextPane();
		JScrollPane jPane = new JScrollPane(funcaoPane);
		jPane.setBounds(188, 240, 268, 80);
		funcaoPane.setEditable(false);
		desktopPane.add(jPane);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome.setEditable(true);
				funcaoPane.setEditable(true);
			}
		});
		btnEditar.setBounds(188, 325, 90, 28);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, sistema.setNomeSubsistema(nome.getText().trim(), chaveSubsistema));

			}

		});
		
		btnAtualizar.setBounds(362, 325, 90, 28);
		desktopPane.add(btnAtualizar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/edit-component-info.png")));
		banner.setBounds(274, 28, 286, 90);
		desktopPane.add(banner);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SetComponente.class.getResource("/Resources/icon/edit-component-info-form.png")));
		label.setBounds(108, 172, 393, 225);
		desktopPane.add(label);

	}
}
