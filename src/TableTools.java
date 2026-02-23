package assignment;

import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.*;

public class TableTools {
    
    public static void applySearch(JTable table, JTextField textField) {
        String keyword = textField.getText();
        TableRowSorter<TableModel> sorter;
        if (table.getRowSorter() instanceof TableRowSorter) {
            sorter = (TableRowSorter<TableModel>) table.getRowSorter();
        } else {
            sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);
        }

        if (keyword.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }

        try {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid search pattern: " + keyword);
            sorter.setRowFilter(null);
        }
    }

    public static void applySort(JTable table, JComboBox<String> comboBox) {
        if (table == null || comboBox == null || comboBox.getSelectedItem() == null) {
            return;
        }

        String sortColumn = comboBox.getSelectedItem().toString();
        TableRowSorter<TableModel> sorter;

        // make sure sorter exists
        if (table.getRowSorter() instanceof TableRowSorter) {
            sorter = (TableRowSorter<TableModel>) table.getRowSorter();
        } else {
            sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);
        }

        int columnIndex = -1;
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnName(i).equals(sortColumn)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex != -1) {
            sorter.setSortKeys(List.of(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)));
            sorter.sort();
        }
    }
    
    public static void applySort(JTable table, JComboBox<String> comboBox, Set<Integer> numericColumns) {
        if (table == null || comboBox == null || comboBox.getSelectedItem() == null) {
            return;
        }

        String sortColumn = comboBox.getSelectedItem().toString();
        TableRowSorter<TableModel> sorter;

        if (table.getRowSorter() instanceof TableRowSorter) {
            sorter = (TableRowSorter<TableModel>) table.getRowSorter();
        } else {
            sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);
        }

        int columnIndex = -1;
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnName(i).equals(sortColumn)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex != -1) {
            // Check if it is a numeric column
            if (numericColumns.contains(columnIndex)) {
                sorter.setComparator(columnIndex, (o1, o2) -> {
                    try {
                        Double d1 = Double.parseDouble(o1.toString());
                        Double d2 = Double.parseDouble(o2.toString());
                        return d1.compareTo(d2);
                    } catch (NumberFormatException e) {
                        return o1.toString().compareTo(o2.toString());
                    }
                });
            }

            sorter.setSortKeys(List.of(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)));
            sorter.sort();
        }
    }

    public static void resetTable(TableRowSorter<?>... sorters){
        for (TableRowSorter<?> sorter : sorters) {
            if (sorters == null) {
                return;
            }
            
            if (sorter != null) {
                sorter.setRowFilter(null);
                sorter.setSortKeys(null);
            }
        }
    }

    }