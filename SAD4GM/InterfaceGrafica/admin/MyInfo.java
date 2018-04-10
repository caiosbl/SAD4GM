package admin;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entrada.Entrada;

import javax.swing.JDesktopPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import sistema.Sistema;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class MyInfo extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MyInfo(String id,int xLocation,int yLocation) {
		super(xLocation,yLocation);
		this.idAdmin = id;
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
		desktopPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.setBounds(486, 381, 90, 27);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options admOptions = new Options(idAdmin,getXLocation(),getYLocation());
				dispose();
				admOptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admOptions.setVisible(true);
				admOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnVoltar);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);

		nome.setBounds(196, 208, 268, 24);
		nome.setText(sistema.getNomeAdmin(this.idAdmin));
		desktopPane.add(nome);

		JTextPane userID = new JTextPane();
		userID.setEditable(false);

		userID.setBounds(196, 243, 268, 24);
		userID.setText(idAdmin);
		desktopPane.add(userID);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/setPasswordbutton.png")));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetOwnPassword admSetSenha = new SetOwnPassword(idAdmin,getXLocation(),getYLocation());
				dispose();
			
				admSetSenha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admSetSenha.setVisible(true);
				admSetSenha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAlterarSenha.setBounds(185, 279, 84, 27);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userID.setEditable(true);
				nome.setEditable(true);
			}
		});
		btnEditar.setBounds(278, 279, 82, 24);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasIdAdmin(userID.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						nome.setText(sistema.getNomeAdmin(idAdmin));
						userID.setText(idAdmin);
					} else if (userID.getText().equals("") || userID.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "ID inválido");
						nome.setText(sistema.getNomeAdmin(idAdmin));
						userID.setText(idAdmin);
					} else if (!userID.getText().trim().equals(idAdmin) && has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						nome.setText(sistema.getNomeAdmin(idAdmin));
						userID.setText(idAdmin);
					}

					else {
						nome.setEditable(false);
						userID.setEditable(false);
						sistema.setIdAdmin(idAdmin, userID.getText().trim());
						idAdmin = userID.getText().trim();
						sistema.setNomeAdmin(nome.getText().trim(), idAdmin);
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(368, 279, 90, 25);
		desktopPane.add(btnAtualizar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel form = new JLabel("");
		form.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/setAdmInfoForm.png")));
		form.setBounds(88, 155, 434, 195);
		desktopPane.add(form);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MyInfo.class.getResource("/Resources/icon/myinfoBannner.png")));
		label.setBounds(278, 25, 258, 79);
		desktopPane.add(label);
	}
}
