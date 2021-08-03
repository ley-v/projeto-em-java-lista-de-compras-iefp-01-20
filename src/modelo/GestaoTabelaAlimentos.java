/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import main.Alimentos;
import estruturasBase.ArrayListObservable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ruiboticas
 */
public class GestaoTabelaAlimentos extends AbstractTableModel {

    private String[] columnNames = {"Alimento", "Mercado", "Preço Kg/L"};
    private final ArrayListObservable<Alimentos> listaAlimentos;

    public GestaoTabelaAlimentos(ArrayListObservable novaListaAlimentos) {
        this.listaAlimentos = novaListaAlimentos;

        listaAlimentos.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Pede à tabela o favor de se atualizar, pois os dados no arraylistObservable alteraram-se
                fireTableDataChanged();
            }
        });
    }

    @Override
    public int getRowCount() {
        return listaAlimentos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;

        switch (columnIndex) {
            case 0:
                type = String.class;
                break;
            case 1:
                type = String.class;
                break;
            case 2:
                type = String.class;
                break;
            case 3:
                type = double.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alimentos alimento = listaAlimentos.get(rowIndex);
        Object value = null;

        switch (columnIndex) {
            case 3:
                value = alimento.getId();
                break;
            case 0:
                value = alimento.getNomeAlimento();
                break;
            case 1:
                value = alimento.getNomeMercado();
                break;
            case 2:
                value = alimento.getPrecoKgL();
                break;
        }
        return value;
    }
}
