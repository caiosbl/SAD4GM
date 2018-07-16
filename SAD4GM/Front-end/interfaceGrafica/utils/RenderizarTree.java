package interfaceGrafica.utils;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import entidades.Componente;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewComponente;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewFalha;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewMachine;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewModoFalha;
import interfaceGrafica.usuario.gerenciadorMaquinas.ViewSubsistema;

public class RenderizarTree extends DefaultTreeCellRenderer implements TreeCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9027400418658050779L;
	private Font plainFont, italicFont;
   
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        final Class<? extends Object> CLASS_TYPE = node.getUserObject().getClass();
       
        if(node.toString().equals("Máquinas")) {
            setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/tree/machines.png")));
        }
        else if(node.toString().equals("Subsistemas")) {
            setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/tree/subsystems.png")));
        }
        
        else if (CLASS_TYPE == Maquina.class) {
        	 setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/tree/machine.png")));
		}

		else if (CLASS_TYPE == Subsistema.class) {
			 setIcon(new ImageIcon(ViewMachine.class.getResource("/Resources/icon/tree/subsystem.png")));
		}

		else if (CLASS_TYPE == Componente.class) {
		
		}

		else if (CLASS_TYPE == Falha.class) {
			
		}

		else if (CLASS_TYPE == ModoFalha.class) {

		}
        
        
        return this;
    }

	
}