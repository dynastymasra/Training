/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.squarecode.training.model;

import java.awt.Component;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class RowHeader extends JTable implements ChangeListener, PropertyChangeListener {
    private static final long serialVersionUID = 1L;

    private JTable main;

    public RowHeader(JTable table) {
        main = table;
        main.addPropertyChangeListener(RowHeader.this);

        setFocusable(false);
        setAutoCreateColumnsFromModel(false);
        setModel(main.getModel());
        setSelectionModel(main.getSelectionModel());

        TableColumn column = new TableColumn();
        column.setHeaderValue("No");
        addColumn(column);
        column.setCellRenderer(new RowHeader.RowRenderer());

        getColumnModel().getColumn(0).setPreferredWidth(35);
        setPreferredScrollableViewportSize(getPreferredSize());
    }

    @Override
    public void addNotify() {
        super.addNotify();
        Component c = getParent();

        if (c instanceof JViewport) {
            JViewport viewPort = (JViewport) c;
            viewPort.addChangeListener(this);
        }
    }

    @Override
    public int getRowHeight(int row) {
        return main.getRowHeight(row);
    }

    @Override
    public int getRowCount() {
        return main.getRowCount();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return row + 1;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JViewport viewPort = (JViewport) e.getSource();
        JScrollPane scroll = (JScrollPane) viewPort.getParent();
        scroll.getVerticalScrollBar().setValue(viewPort.getViewPosition().y);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("selectionModel".equals(evt.getPropertyName())) {
            setSelectionModel(main.getSelectionModel());
        }
        if ("model".equals(evt.getPropertyName())) {
            setModel(main.getModel());
        }
    }

    private static class RowRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;

        public RowRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    setForeground(header.getForeground());
                    setBackground(header.getBackground());
                    setFont(header.getFont());
                }
            }

            if (isSelected) {
                setFont(getFont().deriveFont(Font.BOLD));
            }

            setText((value == null) ? "" : value.toString());
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));

            return this;
        }
    }
}
