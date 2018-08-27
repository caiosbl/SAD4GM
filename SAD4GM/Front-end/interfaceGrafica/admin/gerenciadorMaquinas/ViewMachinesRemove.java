package interfaceGrafica.admin.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import entidades.CausaPotencial;
import entidades.Componente;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;
import interfaceGrafica.main.Main;
import interfaceGrafica.utils.RenderizarTree;
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
import javax.swing.JTree;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ViewMachinesRemove extends Main {

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
	public ViewMachinesRemove(String id, int xLocation, int yLocation) {
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

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(ViewMachinesRemove.class.getResource("/Resources/icon/voltabut.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineManagementOptions mMoptions = new MachineManagementOptions(idAdmin, getXLocation(),
						getYLocation());
				dispose();
				mMoptions.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				mMoptions.setVisible(true);
				mMoptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(484, 418, 88, 29);
		desktopPane.add(btnVoltar);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewMachinesRemove.class.getResource("/Resources/icon/sad4logosmall.png")));
		logo.setBounds(29, 40, 205, 74);
		desktopPane.add(logo);

		JLabel banner = new JLabel("");
		banner.setIcon(new ImageIcon(ViewMachinesRemove.class.getResource("/Resources/icon/remove-maquina-title.png")));
		banner.setBounds(311, 21, 214, 104);
		desktopPane.add(banner);

		JLabel label = new JLabel("");
		label.setIcon(
				new ImageIcon(ViewMachinesRemove.class.getResource("/Resources/icon/top-select-item-remove.png")));
		label.setBounds(69, 138, 460, 25);
		desktopPane.add(label);

	}

	private void jTree1ValueChanged(TreeSelectionEvent tse) {

		if (tse.isAddedPath()) {

			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getNewLeadSelectionPath().getLastPathComponent();

			final Class<? extends Object> CLASS_TYPE = node.getUserObject().getClass();

			if (CLASS_TYPE == Maquina.class) {

				Maquina maquina = (Maquina) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover a Máquina " + maquina.getNome() + " ?", "Remover Máquina",
						JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerMaquina(maquina.getChave()));
					atualizaTree();
				}

			}

			else if (CLASS_TYPE == Subsistema.class) {
				Subsistema subsistema = (Subsistema) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover o Subsistema " + subsistema.getNome() + " ?",
						"Remover Subsistema", JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerSubsistema(subsistema.getChave()));
					atualizaTree();
				}

			}

			else if (CLASS_TYPE == Componente.class) {
				Componente componente = (Componente) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover o Componente " + componente.getNome() + " ?",
						"Remover Componente", JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerComponente(componente.getChave()));
					atualizaTree();
				}

			}

			else if (CLASS_TYPE == Falha.class) {
				Falha falha = (Falha) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover a Falha " + falha.getNome() + " ?", "Remover Falha",
						JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerFalha(falha.getChave()));
					atualizaTree();
				}

			}

			else if (CLASS_TYPE == ModoFalha.class) {
				ModoFalha modoFalha = (ModoFalha) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover o Modo de Falha " + modoFalha.getNome() + " ?",
						"Remover Modo de Falha", JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerModoFalha(modoFalha.getChave()));
					atualizaTree();
				}
			}

			else if (CLASS_TYPE == CausaPotencial.class) {
				CausaPotencial causaPotencial = (CausaPotencial) node.getUserObject();
				JFrame frame = new JFrame();
				int resposta = JOptionPane.showConfirmDialog(frame,
						"Tem Certeza que Deseja remover a Causa Potencial " + causaPotencial.getNome() + " ?",
						"Remover Causa Potencial", JOptionPane.YES_NO_OPTION);
				frame.dispose();
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, sistema.removerCausaPotencial(causaPotencial.getChave()));
					atualizaTree();
				}
			}
		}
	}

	private void atualizaTree() {
		DefaultMutableTreeNode maquinaNode = iniciaNodeMaquinas();
		TreeModel arvore = new DefaultTreeModel(maquinaNode);
		tree.setModel(arvore);

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
