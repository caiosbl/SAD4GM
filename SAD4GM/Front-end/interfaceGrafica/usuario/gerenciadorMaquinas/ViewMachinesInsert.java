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
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertMaquina;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertModoFalha;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertSubsistema;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertFalha;
import interfaceGrafica.utils.RenderizarTree;
import sistema.Sistema;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

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

public class ViewMachinesInsert extends Main {

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
	public ViewMachinesInsert(String id, int xLocation, int yLocation) {
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

		JLabel label = new JLabel("");
		label.setIcon(
				new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/top-select-item-insert.png")));
		label.setBounds(69, 138, 460, 25);
		desktopPane.add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 0, 2);
		desktopPane.add(separator);

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/voltabut.png")));
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
		logo.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/insert-machine.png")));
		banner.setBounds(318, 17, 214, 114);
		desktopPane.add(banner);

	}

	private void jTree1ValueChanged(TreeSelectionEvent tse) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getNewLeadSelectionPath().getLastPathComponent();
		DefaultMutableTreeNode nodeParent = (DefaultMutableTreeNode) node.getParent();

		if (node.toString().equals("Máquinas")) {
			InsertMaquina insertMaquina = new InsertMaquina(idAdmin, getXLocation(), getYLocation());
			dispose();
			insertMaquina.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertMaquina.setVisible(true);
			insertMaquina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		} else if (node.toString().equals("Subsistemas")) {
			Maquina maquina = (Maquina) nodeParent.getUserObject();
			InsertSubsistema insertSub = new InsertSubsistema(idAdmin, getXLocation(), getYLocation(),
					maquina.getChave());
			dispose();
			insertSub.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertSub.setVisible(true);
			insertSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (node.toString().equals("Componentes")) {
			Subsistema subsistema = (Subsistema) nodeParent.getUserObject();
			InsertComponente insertComp = new InsertComponente(idAdmin, getXLocation(), getYLocation(),
					subsistema.getChave());
			dispose();
			insertComp.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertComp.setVisible(true);
			insertComp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (node.toString().equals("Falhas")) {
			Componente componente = (Componente) nodeParent.getUserObject();
			InsertFalha insertFalha = new InsertFalha(idAdmin, getXLocation(), getYLocation(), componente.getChave());
			dispose();
			insertFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertFalha.setVisible(true);
			insertFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (node.toString().equals("Modos de Falha")) {
			Falha falha = (Falha) nodeParent.getUserObject();
			InsertModoFalha insertModoFalha = new InsertModoFalha(idAdmin, getXLocation(), getYLocation(),
					falha.getChave());
			dispose();
			insertModoFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertModoFalha.setVisible(true);
			insertModoFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

	}

	private void iniciaTree() {

		DefaultMutableTreeNode maquinaNode = iniciaNodeMaquinas();
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
				iniciaRamoCausaPotencial(mFailNode, modoFalha);
			}
		}

	}

	private void iniciaRamoCausaPotencial(DefaultMutableTreeNode failNode, ModoFalha modoFalha) {
		DefaultMutableTreeNode causaPotencialNode = new DefaultMutableTreeNode("Causas Potenciais");
		if (!getModosFalhaMap(modoFalha.getChave()).isEmpty()) {
			failNode.add(causaPotencialNode);

			for (CausaPotencial causaPotencial : getCausasPotenciaisMap(modoFalha.getChave()).values()) {
				DefaultMutableTreeNode cPotencialNode = new DefaultMutableTreeNode(causaPotencial);
				causaPotencialNode.add(cPotencialNode);
			}
		}

	}

	private Map<Integer, CausaPotencial> getCausasPotenciaisMap(int chaveModoFalha) {
		return sistema.getCausasPotenciaisMap(chaveModoFalha);

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
