package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import entidades.CausaPotencial;
import entidades.Componente;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.utils.RenderizarTree;
import interfaceGrafica.utils.Tree;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTree;
import java.awt.Color;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewMachinesInfo extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTree tree;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewMachinesInfo(String id, int xLocation, int yLocation) {
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

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(0,0,0,0));
		btnVoltar.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/back-btn.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(idAdmin, getXLocation(), getYLocation());

				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(527, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);
		
		JLabel lblSelecioneOItem = new JLabel("SELECIONE O ITEM QUE DESEJA VISUALIZAR:");
		lblSelecioneOItem.setForeground(Color.WHITE);
		lblSelecioneOItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneOItem.setBounds(112, 172, 374, 20);
		desktopPane.add(lblSelecioneOItem);
		
		JLabel lblVisualizar = new JLabel("VISUALIZAR");
		lblVisualizar.setForeground(Color.WHITE);
		lblVisualizar.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblVisualizar.setBounds(310, 28, 209, 40);
		desktopPane.add(lblVisualizar);
		
		JLabel lblDadosDeMquina = new JLabel("DADOS DE MÁQUINA");
		lblDadosDeMquina.setForeground(Color.WHITE);
		lblDadosDeMquina.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblDadosDeMquina.setBounds(246, 62, 349, 40);
		desktopPane.add(lblDadosDeMquina);
		
		JButton button = new JButton("");
		button.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/home-on.png")));
		button.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/home-off.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 0, 0, 0));
		button.setBounds(348, 109, 62, 44);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/my-data-on.png")));
		button_1.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/my-data-off.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(new Color(0, 0, 0, 0));
		button_1.setBounds(403, 109, 119, 45);
		desktopPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/logout-on.png")));
		button_2.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/logout-off.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBackground(new Color(0, 0, 0, 0));
		button_2.setBounds(498, 109, 119, 45);
		desktopPane.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(349, 106, 256, 51);
		desktopPane.add(label);

	}

	private void jTree1ValueChanged(TreeSelectionEvent tse) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getNewLeadSelectionPath().getLastPathComponent();

		final Class<? extends Object> CLASS_TYPE = node.getUserObject().getClass();

		if (CLASS_TYPE == Maquina.class) {
			Maquina maquina = (Maquina) node.getUserObject();
			ViewMachine vMachine = new ViewMachine(idAdmin, maquina.getChave(), getXLocation(), getYLocation());
			dispose();
			vMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vMachine.setVisible(true);
			vMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		else if (CLASS_TYPE == Subsistema.class) {
			Subsistema subsistema = (Subsistema) node.getUserObject();
			ViewSubsistema vSubsistema = new ViewSubsistema(idAdmin, subsistema.getChave(), getXLocation(),
					getYLocation());
			dispose();
			vSubsistema.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vSubsistema.setVisible(true);
			vSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == Componente.class) {
			Componente componente = (Componente) node.getUserObject();
			ViewComponente vComponente = new ViewComponente(idAdmin, componente.getChave(), getXLocation(),
					getYLocation());
			dispose();
			vComponente.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vComponente.setVisible(true);
			vComponente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == Falha.class) {
			Falha falha = (Falha) node.getUserObject();
			ViewFalha vFalha = new ViewFalha(idAdmin, falha.getChave(), getXLocation(), getYLocation());
			dispose();
			vFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vFalha.setVisible(true);
			vFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == ModoFalha.class) {
			ModoFalha modoFalha = (ModoFalha) node.getUserObject();
			ViewModoFalha vMFalha = new ViewModoFalha(idAdmin, modoFalha.getChave(), getXLocation(), getYLocation());
			dispose();
			vMFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vMFalha.setVisible(true);
			vMFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == CausaPotencial.class) {
			CausaPotencial causaPotencial = (CausaPotencial) node.getUserObject();
			ViewCausaPotencial vCPotencial = new ViewCausaPotencial(idAdmin, causaPotencial.getChave(), getXLocation(),
					getYLocation());
			dispose();
			vCPotencial.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vCPotencial.setVisible(true);
			vCPotencial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

	}

	private void iniciaTree() {

		DefaultMutableTreeNode maquinaNode = Tree.getTree();

		TreeSelectionListener tsl = new TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				jTree1ValueChanged(evt);
			}
		};
		JScrollPane jSPane = new JScrollPane();
		jSPane.setBounds(67, 190, 465, 244);
		desktopPane.add(jSPane);
		tree = new JTree(maquinaNode);
		jSPane.setViewportView(tree);
		tree.setCellRenderer(new RenderizarTree());
		
				tree.addTreeSelectionListener(tsl);

	}
}
