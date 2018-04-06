package interfaceGrafica.Admin.AdmManagement;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaceGrafica.Entrada;

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
public class SetAdmin extends Entrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private String idAtual;
	
	private Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetAdmin(String id, String idSet, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.idAtual = idSet;
		

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

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/voltabut.png")));
		button.setBounds(492, 381, 93, 34);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetAdminEntry setAdminEntry = new SetAdminEntry(idAdmin,getXLocation(),getYLocation());
				dispose();
				setAdminEntry.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				setAdminEntry.setVisible(true);
				setAdminEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(button);

		JTextPane nome = new JTextPane();
		nome.setEditable(false);

		nome.setBounds(182, 209, 268, 24);
		nome.setText(sistema.getNomeAdmin(this.idAtual));
		desktopPane.add(nome);

		JTextPane userID = new JTextPane();
		userID.setEditable(false);

		userID.setBounds(182, 240, 268, 24);
		userID.setText(idAtual);
		desktopPane.add(userID);

		JButton btnAlterarSenha = new JButton("");
		btnAlterarSenha.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/setPasswordbutton.png")));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetAdminPassword admSetSenha = new SetAdminPassword(idAdmin, idAtual,getXLocation(),getYLocation());
				dispose();
				admSetSenha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				admSetSenha.setVisible(true);
				admSetSenha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAlterarSenha.setBounds(179, 276, 84, 27);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		desktopPane.add(btnAlterarSenha);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/editbutton.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userID.setEditable(true);
				nome.setEditable(true);
			}
		});
		btnEditar.setBounds(272, 276, 82, 24);
		desktopPane.add(btnEditar);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/atualizarbutton.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			private String idAlterar;

			public void actionPerformed(ActionEvent e) {

				boolean has = false;

				try {
					has = sistema.hasIdAdmin(userID.getText().trim());
					if (nome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						nome.setText(sistema.getNomeAdmin(idAtual));
						userID.setText(idAlterar);
					} else if (userID.getText().equals("") || userID.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "ID inválido");
						nome.setText(sistema.getNomeAdmin(idAlterar));
						userID.setText(idAlterar);
					} else if (!userID.getText().trim().equals(idAtual) && has) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado!");
						nome.setText(sistema.getNomeAdmin(idAlterar));
						userID.setText(idAlterar);
					}

					else {
						nome.setEditable(false);
						userID.setEditable(false);
						
						sistema.setIdAdmin(idAtual, userID.getText().trim());
						idAtual = userID.getText().trim();
						sistema.setNomeAdmin(nome.getText().trim(), idAtual);
						JOptionPane.showMessageDialog(null, "Dados atualizados com Sucesso!");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha na conexão com Banco de dados!");
				}

			}

		});
		btnAtualizar.setBounds(366, 276, 90, 25);
		desktopPane.add(btnAtualizar);
		
		JLabel Sad4GMLogo = new JLabel("");
		Sad4GMLogo.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/sad4logosmall.png")));
		Sad4GMLogo.setBounds(29, 40, 205, 74);
		desktopPane.add(Sad4GMLogo);
		
		JLabel setAdminBanner = new JLabel("");
		setAdminBanner.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/alteraradminbanner.png")));
		setAdminBanner.setBounds(328, 27, 210, 87);
		desktopPane.add(setAdminBanner);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SetAdmin.class.getResource("/Resources/icon/setAdmForm.png")));
		label.setBounds(97, 146, 408, 185);
		desktopPane.add(label);
	}
}
