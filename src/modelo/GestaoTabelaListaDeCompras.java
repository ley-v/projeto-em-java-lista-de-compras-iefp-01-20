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
import main.ListaDeCompras;

/**
 *
 * @author Ley
 */
public class GestaoTabelaListaDeCompras extends AbstractTableModel {

    private String[] columnNames = {"Alimento", "Mercado", "Quantidade", "Preço"};
    private final ArrayListObservable<ListaDeCompras> listaDeCompras;

    public GestaoTabelaListaDeCompras(ArrayListObservable novalistaDeCompras) {
        this.listaDeCompras = novalistaDeCompras;
        listaDeCompras.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Pede à tabela o favor de se atualizar, pois os dados no arraylistObservable alteraram-se
                fireTableDataChanged();
            }
        });
    }

    @Override
    public int getRowCount() {
        return listaDeCompras.size();
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
                type = double.class;
                break;
            case 3:
                type = double.class;
                break;
            case 4:
                type = String.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListaDeCompras lc = listaDeCompras.get(rowIndex);
        Object value = null;

        switch (columnIndex) {

            case 0:
                value = lc.getAlimento();
                break;
            case 1:
                value = lc.getMercado();
                break;
            case 2:
                value = lc.getQuantidade();
                break;
            case 3:
                value = lc.getPreco();
                break;
            case 4:
                value = lc.getId();
                break;
        }
        return value;
    }
}
