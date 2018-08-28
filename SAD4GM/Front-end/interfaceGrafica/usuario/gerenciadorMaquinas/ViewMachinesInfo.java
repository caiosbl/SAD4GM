package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

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
		btnVoltar.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/voltabut.png")));
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
		btnVoltar.setBounds(484, 418, 88, 29);
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/view-machines-title.png")));
		banner.setBounds(311, 21, 214, 104);
		desktopPane.add(banner);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/top-select-item-view.png")));
		label.setBounds(70, 139, 460, 25);
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

	}

	private void iniciaTree() {

		DefaultMutableTreeNode maquinaNode = Tree.getTree();
		tree = new JTree(maquinaNode);
		tree.setCellRenderer(new RenderizarTree());

		TreeSelectionListener tsl = new TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				jTree1ValueChanged(evt);
			}
		};

		tree.addTreeSelectionListener(tsl);
		JScrollPane jSPane = new JScrollPane(tree);
		jSPane.setBounds(67, 161, 465, 244);
		desktopPane.add(jSPane);

	}

}
