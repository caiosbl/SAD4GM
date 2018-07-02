package interfaceGrafica.usuario.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTree;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class MachineInformation2 extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTree tree;
	private JDesktopPane desktopPane;

	private Sistema sistema;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MachineInformation2(String id, int xLocation, int yLocation) {
		super(xLocation, yLocation);
		this.idAdmin = id;
		this.sistema = new Sistema();
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 582, 12);
		desktopPane.add(separator);

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(MachineInformation2.class.getResource("/Resources/icon/voltabut.png")));
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
		logo.setIcon(new ImageIcon(MachineInformation2.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(MachineInformation2.class.getResource("/Resources/icon/view-machines-title.png")));
		banner.setBounds(311, 21, 214, 104);
		desktopPane.add(banner);

	}

	public void jTree1ValueChanged(TreeSelectionEvent tse) {

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
			JOptionPane.showMessageDialog(null, subsistema.getNome());
		}

		else if (CLASS_TYPE == Componente.class) {
			Componente componente = (Componente) node.getUserObject();
			JOptionPane.showMessageDialog(null, componente.getNome());
		}

		else if (CLASS_TYPE == Falha.class) {
			Falha falha = (Falha) node.getUserObject();
			JOptionPane.showMessageDialog(null, falha.getNome());
		}

		else if (CLASS_TYPE == ModoFalha.class) {
			ModoFalha modoFalha = (ModoFalha) node.getUserObject();
			JOptionPane.showMessageDialog(null, modoFalha.getNome());
		}

	}

	private void iniciaTree() {

		DefaultMutableTreeNode maquinaNode = iniciaNodeMaquinas();
		tree = new JTree(maquinaNode);

		TreeSelectionListener tsl = new TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				jTree1ValueChanged(evt);
			}
		};

		tree.addTreeSelectionListener(tsl);

		// tree.setBackground(new Color(0, 0, 0, 0));
		tree.setBounds(67, 161, 465, 244);
		desktopPane.add(tree);

	}

	private DefaultMutableTreeNode iniciaNodeMaquinas() {
		DefaultMutableTreeNode maquinaNode = new DefaultMutableTreeNode("Máquinas");

		for (Maquina maquina : getMapaMaquinas().values()) {
			DefaultMutableTreeNode mNode = new DefaultMutableTreeNode(maquina);
			maquinaNode.add(mNode);
			iniciaRamoSubsistemas(mNode, maquina);
		}

		return maquinaNode;

	}

	private void iniciaRamoSubsistemas(DefaultMutableTreeNode maquinaNode, Maquina maquina) {
		DefaultMutableTreeNode subsistemasNode = new DefaultMutableTreeNode("Subsistemas");

		if (!getMapaSubsistemas(maquina.getChave()).isEmpty()) {
			maquinaNode.add(subsistemasNode);

			for (Subsistema subsistema : getMapaSubsistemas(maquina.getChave()).values()) {
				DefaultMutableTreeNode subsNode = new DefaultMutableTreeNode(subsistema);
				subsistemasNode.add(subsNode);
				iniciaRamoComponentes(subsNode, subsistema);
			}
		}

	}

	private void iniciaRamoComponentes(DefaultMutableTreeNode subsistemaNode, Subsistema subsistema) {
		DefaultMutableTreeNode componenteNode = new DefaultMutableTreeNode("Componentes");

		if (!getMapaComponentes(subsistema.getChave()).isEmpty()) {

			subsistemaNode.add(componenteNode);

			for (Componente componente : getMapaComponentes(subsistema.getChave()).values()) {
				DefaultMutableTreeNode compNode = new DefaultMutableTreeNode(componente);
				componenteNode.add(compNode);
				iniciaRamoFalha(compNode, componente);
			}
		}

	}

	private void iniciaRamoFalha(DefaultMutableTreeNode componenteNode, Componente componente) {
		DefaultMutableTreeNode falhaNode = new DefaultMutableTreeNode("Falhas");
		if (!getFalhasMap(componente.getChave()).isEmpty()) {
			componenteNode.add(falhaNode);

			for (Falha falha : getFalhasMap(componente.getChave()).values()) {
				DefaultMutableTreeNode failNode = new DefaultMutableTreeNode(falha);
				falhaNode.add(failNode);
				iniciaRamoModoFalha(failNode, falha);
			}
		}

	}

	private void iniciaRamoModoFalha(DefaultMutableTreeNode failNode, Falha falha) {
		DefaultMutableTreeNode modoFalhaNode = new DefaultMutableTreeNode("Modos de Falha");
		if (!getModosFalhaMap(falha.getChave()).isEmpty()) {
			failNode.add(modoFalhaNode);

			for (ModoFalha modoFalha : getModosFalhaMap(falha.getChave()).values()) {
				DefaultMutableTreeNode mFailNode = new DefaultMutableTreeNode(modoFalha);
				modoFalhaNode.add(mFailNode);
			}
		}

	}

	private Map<Integer, Maquina> getMapaMaquinas() {
		return sistema.getMaquinaMapa();
	}

	private Map<Integer, Subsistema> getMapaSubsistemas(int chaveMaquina) {
		return sistema.getSubsistemasMap(chaveMaquina);
	}

	private Map<Integer, Componente> getMapaComponentes(int chaveSubsistema) {
		return sistema.getComponentesMap(chaveSubsistema);
	}

	private Map<Integer, Falha> getFalhasMap(int chaveComponente) {
		return sistema.getFalhasMap(chaveComponente);
	}

	private Map<Integer, ModoFalha> getModosFalhaMap(int chaveFalha) {
		return sistema.getModosFalhaMap(chaveFalha);
	}
}
