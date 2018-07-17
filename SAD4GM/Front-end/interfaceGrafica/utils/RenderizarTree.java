package interfaceGrafica.utils;

import java.awt.Component;

import javax.swing.ImageIcon;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import entidades.Componente;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;


public class RenderizarTree extends DefaultTreeCellRenderer implements TreeCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9027400418658050779L;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		final Class<? extends Object> CLASS_TYPE = node.getUserObject().getClass();

		if (node.toString().equals("Máquinas")) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/machines.png")));
		else if (node.toString().equals("Subsistemas")) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/subsystems.png")));
		
		else if (node.toString().equals("Componentes")) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/components.png")));
		
		else if (node.toString().equals("Falhas")) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/falhas.png")));
		
		else if (node.toString().equals("Modos de Falha")) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/modosfalha.png")));
		
		
		else if (CLASS_TYPE == Maquina.class) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/machine.png")));

		else if (CLASS_TYPE == Subsistema.class) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/subsystem.png")));

		else if (CLASS_TYPE == Componente.class) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/component.png")));

		else if (CLASS_TYPE == Falha.class) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/falha.png")));
		
		else if (CLASS_TYPE == ModoFalha.class) 
			setIcon(new ImageIcon(RenderizarTree.class.getResource("/Resources/icon/tree/modofalha.png")));
		

		return this;
	}

}