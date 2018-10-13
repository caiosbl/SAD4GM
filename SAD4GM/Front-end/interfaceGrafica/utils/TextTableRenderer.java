package interfaceGrafica.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class TextTableRenderer extends JTextArea implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextTableRenderer() {
	setOpaque(true);
	setLineWrap(true);
	setWrapStyleWord(true);
	}

	public Component getTableCellRendererComponent(JTable table,
	Object value, boolean isSelected, boolean hasFocus, int row,
	int column) {

	if (isSelected) {
	setForeground(new Color(250, 0, 250));
	setBackground(table.getSelectionBackground());
	} else {
	setForeground(new Color(80,90,155));
	setBackground(table.getBackground());
	}

	setText((value == null)
	? ""
	: value.toString());
	return this;
	}
}

