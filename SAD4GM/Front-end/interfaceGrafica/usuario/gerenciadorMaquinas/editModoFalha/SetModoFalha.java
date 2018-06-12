package interfaceGrafica.usuario.gerenciadorMaquinas.editModoFalha;

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
public class SetModoFalha extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idUsuario;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetModoFalha(String idUser, int xLocation, int yLocation, int chaveMaquina, int chaveSubsistema,
			int chaveComponente, int chaveFalha, int chaveModoFalha) {
		super(xLocation, yLocation);
		this.idUsuario = idUser;

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
		btnVoltar.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(490, 420, 90, 27);
		JScrollPane jPane = new JScrollPane();
		jPane.setBounds(188, 198, 268, 140);
		desktopPane.add(jPane);
		
				JTextPane descricaoPane = new JTextPane();
				jPane.setViewportView(descricaoPane);
				descricaoPane.setText(sistema.getDescricaoModoFalha(chaveModoFalha));
				descricaoPane.setEditable(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditModoFalha editModoFalha = new EditModoFalha(idUsuario, xLocation, yLocation, chaveMaquina,
						chaveSubsistema, chaveComponente, chaveFalha);
				dispose();
				editModoFalha.setVisible(true);
				editModoFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				descricaoPane.setEditable(true);
			}
		});
		btnEditar.setBounds(188, 340, 90, 28);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 if (isEmpty(descricaoPane.getText().trim())) {
					descricaoPane.setText(sistema.getDescricaoModoFalha(chaveModoFalha));
					JOptionPane.showMessageDialog(null, "Descrição Inválida");
				}

				else {
					JOptionPane.showMessageDialog(null,
							sistema.setDescricaoModoFalha(descricaoPane.getText().trim(), chaveModoFalha));
					
				}

			}

		});

		btnAtualizar.setBounds(367, 340, 90, 28);
		desktopPane.add(btnAtualizar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/editModoFalha.png")));
		banner.setBounds(274, 28, 286, 90);
		desktopPane.add(banner);
			
				
						JLabel label = new JLabel("");
						label.setIcon(new ImageIcon(SetModoFalha.class.getResource("/Resources/icon/descricao-form-modo-falha.png")));
						label.setBounds(100, 178, 393, 199);
						desktopPane.add(label);

	}

}
