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
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertMaquina;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertModoFalha;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertSubsistema;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertAcaoRecomendada;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertCausaPotencial;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertEfeito;
import interfaceGrafica.usuario.gerenciadorMaquinas.Insert.InsertFalha;
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
import javax.swing.JSeparator;
import javax.swing.JTree;
import java.awt.Color;

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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewMachinesInsert(String id, int xLocation, int yLocation) {
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 0, 2);
		desktopPane.add(separator);

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setSelectedIcon(
				new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/back-btn.png")));
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
		btnVoltar.setBounds(503, 408, 78, 44);
		desktopPane.add(btnVoltar);

		JLabel lblSelecioneOItem = new JLabel("SELECIONE O ITEM QUE DESEJA INSERIR:");
		lblSelecioneOItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneOItem.setForeground(Color.WHITE);
		lblSelecioneOItem.setBounds(114, 88, 342, 20);
		desktopPane.add(lblSelecioneOItem);

		JLabel lblInserir = new JLabel("INSERIR");
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInserir.setBounds(99, 22, 107, 29);
		desktopPane.add(lblInserir);

		JLabel lblD = new JLabel("DADOS DE MÁQUINA");
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblD.setBounds(33, 47, 252, 29);
		desktopPane.add(lblD);

		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options(id, getXLocation(), getYLocation());
				dispose();
				options.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				options.setVisible(true);
				options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		homeBtn.setSelectedIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);

		JButton myDataBtn = new JButton("");
		myDataBtn
				.setSelectedIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setSelectedIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/logout-on.png")));
		button.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/logout-off.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 0, 0, 0));
		button.setBounds(499, 9, 119, 45);
		desktopPane.add(button);

		JLabel navbar = new JLabel("");
		navbar.setIcon(new ImageIcon(ViewMachinesInsert.class.getResource("/Resources/icon/navbar.png")));
		navbar.setBounds(350, 6, 256, 51);
		desktopPane.add(navbar);

		JLabel lblMquina = new JLabel("[MÁQUINA | SUBSISTEMA | COMPONENTE | FALHA | MODO DE FALHA | CAUSA POTENCIAL]");
		lblMquina.setForeground(Color.WHITE);
		lblMquina.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMquina.setBounds(17, 107, 577, 16);
		desktopPane.add(lblMquina);

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

		else if (node.toString().equals("Causas Potenciais")) {
			ModoFalha modoFalha = (ModoFalha) nodeParent.getUserObject();
			InsertCausaPotencial insertCausaPotencial = new InsertCausaPotencial(idAdmin, getXLocation(),
					getYLocation(), modoFalha.getChave());
			dispose();
			insertCausaPotencial
					.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertCausaPotencial.setVisible(true);
			insertCausaPotencial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		else if (node.toString().equals("Ações Recomendadas")) {
			CausaPotencial causaPotencial = (CausaPotencial) nodeParent.getUserObject();
			InsertAcaoRecomendada insertCausaPotencial = new InsertAcaoRecomendada(idAdmin, getXLocation(),
					getYLocation(), causaPotencial.getChave());
			dispose();
			insertCausaPotencial
					.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertCausaPotencial.setVisible(true);
			insertCausaPotencial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		else if (node.toString().equals("Efeitos")) {
			ModoFalha modoFalha = (ModoFalha) nodeParent.getUserObject();
			InsertEfeito insertEfeito = new InsertEfeito(idAdmin, getXLocation(), getYLocation(), modoFalha.getChave());
			dispose();
			insertEfeito.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			insertEfeito.setVisible(true);
			insertEfeito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
		jSPane.setBounds(13, 139, 581, 270);
		desktopPane.add(jSPane);
		tree = new JTree(maquinaNode);
		jSPane.setViewportView(tree);
		tree.setCellRenderer(new RenderizarTree());

		tree.addTreeSelectionListener(tsl);

	}
}
