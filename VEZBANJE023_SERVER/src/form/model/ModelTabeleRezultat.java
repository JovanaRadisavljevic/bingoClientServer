/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Igra;
import model.RezultatIgre;

/**
 *
 * @author Jovana
 */
public class ModelTabeleRezultat extends AbstractTableModel{
    private List<RezultatIgre> list=new ArrayList<>();
    private String[] kolone = { "dobitna kombinacija","datum","broj pokusaja","rezultat"};
    
    public ModelTabeleRezultat (List<RezultatIgre> list){
        this.list=list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezultatIgre i = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return i.getDobitnaKombinacija();
            case 1: return i.getDatum();
            case 2: return i.getBrPoksuaja();
            case 3: return i.getRezultat();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<RezultatIgre> getList() {
        return list;
    }

    
}
