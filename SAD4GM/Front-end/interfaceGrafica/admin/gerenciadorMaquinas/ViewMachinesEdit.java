package interfaceGrafica.admin.gerenciadorMaquinas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import entidades.AcaoRecomendada;
import entidades.CausaPotencial;
import entidades.Componente;
import entidades.Efeito;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetAcaoRecomendada;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetCausaPotencial;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetComponente;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetEfeito;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetFalha;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetMachine;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetModoFalha;
import interfaceGrafica.admin.gerenciadorMaquinas.editMachines.SetSubsistema;
import interfaceGrafica.main.Main;
import interfaceGrafica.usuario.entrada.Login;
import interfaceGrafica.usuario.entrada.MyInfo;
import interfaceGrafica.usuario.entrada.Options;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachinesInfo;
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

public class ViewMachinesEdit extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1728238218376528571L;
	private JPanel contentPane;
	private String idAdmin;
	private JTree tree;
	private JDesktopPane desktopPane;
	private JLabel lblEditar;
	private JLabel lblDadosDeMquina;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewMachinesEdit(String id, int xLocation, int yLocation) {
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
		homeBtn.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/home-on.png")));
		homeBtn.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/home-off.png")));
		homeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeBtn.setBackground(new Color(0, 0, 0, 0));
		homeBtn.setBounds(349, 9, 62, 44);
		desktopPane.add(homeBtn);
		
		JButton myDataBtn = new JButton("");
		myDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfo myInfo = new MyInfo(id, getXLocation(), getYLocation());
				dispose();
				myInfo.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				myInfo.setVisible(true);
				myInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		myDataBtn.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/my-data-on.png")));
		myDataBtn.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/my-data-off.png")));
		myDataBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		myDataBtn.setBackground(new Color(0, 0, 0, 0));
		myDataBtn.setBounds(404, 9, 119, 45);
		desktopPane.add(myDataBtn);
		
		JButton logoutBtn = new JButton("");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(getXLocation(), getYLocation());
				dispose();
				login.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
				login.setVisible(true);
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		logoutBtn.setSelectedIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/logout-on.png")));
		logoutBtn.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/logout-off.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutBtn.setBackground(new Color(0, 0, 0, 0));
		logoutBtn.setBounds(499, 9, 119, 45);
		desktopPane.add(logoutBtn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewMachinesInfo.class.getResource("/Resources/icon/navbar.png")));
		label.setBounds(350, 6, 256, 51);
		desktopPane.add(label);

		iniciaTree();

		JButton btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(0, 0, 0, 0));
		btnVoltar.setSelectedIcon(
				new ImageIcon(ViewMachinesEdit.class.getResource("/Resources/icon/return-selected.png")));
		btnVoltar.setIcon(new ImageIcon(ViewMachinesEdit.class.getResource("/Resources/icon/back-btn.png")));
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
		btnVoltar.setBounds(521, 408, 78, 44);
		desktopPane.add(btnVoltar);

		lblEditar = new JLabel("EDITAR");
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEditar.setBounds(88, 22, 93, 29);
		desktopPane.add(lblEditar);

		lblDadosDeMquina = new JLabel("DADOS DE MÁQUINA");
		lblDadosDeMquina.setForeground(Color.WHITE);
		lblDadosDeMquina.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDadosDeMquina.setBounds(11, 46, 252, 29);
		desktopPane.add(lblDadosDeMquina);
		
		JLabel lblSelecioneOItem = new JLabel("SELECIONE O ITEM QUE DESEJA EDITAR:");
		lblSelecioneOItem.setForeground(Color.WHITE);
		lblSelecioneOItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneOItem.setBounds(126, 115, 353, 20);
		desktopPane.add(lblSelecioneOItem);

	}

	private void jTree1ValueChanged(TreeSelectionEvent tse) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getNewLeadSelectionPath().getLastPathComponent();

		final Class<? extends Object> CLASS_TYPE = node.getUserObject().getClass();

		if (CLASS_TYPE == Maquina.class) {
			Maquina maquina = (Maquina) node.getUserObject();
			SetMachine setMachine = new SetMachine(idAdmin, getXLocation(), getYLocation(), maquina.getChave());
			dispose();
			setMachine.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			setMachine.setVisible(true);
			setMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		else if (CLASS_TYPE == Subsistema.class) {
			Subsistema subsistema = (Subsistema) node.getUserObject();
			SetSubsistema setSubsistema = new SetSubsistema(idAdmin, getXLocation(), getYLocation(),
					subsistema.getChave());
			dispose();
			setSubsistema.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			setSubsistema.setVisible(true);
			setSubsistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == Componente.class) {
			Componente componente = (Componente) node.getUserObject();
			SetComponente setComponente = new SetComponente(idAdmin, getXLocation(), getYLocation(),
					componente.getChave());
			dispose();
			setComponente.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			setComponente.setVisible(true);
			setComponente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == Falha.class) {
			Falha falha = (Falha) node.getUserObject();
			SetFalha vFalha = new SetFalha(idAdmin, getXLocation(), getYLocation(), falha.getChave());
			dispose();
			vFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vFalha.setVisible(true);
			vFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == ModoFalha.class) {
			ModoFalha modoFalha = (ModoFalha) node.getUserObject();
			SetModoFalha vMFalha = new SetModoFalha(idAdmin, getXLocation(), getYLocation(), modoFalha.getChave());
			dispose();
			vMFalha.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vMFalha.setVisible(true);
			vMFalha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if (CLASS_TYPE == CausaPotencial.class) {
			CausaPotencial causaPotencial = (CausaPotencial) node.getUserObject();
			SetCausaPotencial vMCausaPotencial = new SetCausaPotencial(idAdmin, getXLocation(), getYLocation(),
					causaPotencial.getChave());
			dispose();
			vMCausaPotencial.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vMCausaPotencial.setVisible(true);
			vMCausaPotencial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		else if (CLASS_TYPE == AcaoRecomendada.class) {
			AcaoRecomendada acaoRecomendada = (AcaoRecomendada) node.getUserObject();
			SetAcaoRecomendada setAcaoRecomendada = new SetAcaoRecomendada(idAdmin, getXLocation(), getYLocation(),
					acaoRecomendada.getChave());
			dispose();
			setAcaoRecomendada.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			setAcaoRecomendada.setVisible(true);
			setAcaoRecomendada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		else if (CLASS_TYPE == Efeito.class) {
			Efeito efeito = (Efeito) node.getUserObject();
			SetEfeito vEfeito = new SetEfeito(idAdmin, getXLocation(), getYLocation(),
					efeito.getChave());
			dispose();
			vEfeito.setIconImage(new ImageIcon(getClass().getResource("/Resources/icon/icon.png")).getImage());
			vEfeito.setVisible(true);
			vEfeito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		jSPane.setBounds(13, 139, 581, 270);
		desktopPane.add(jSPane);

	}

}
