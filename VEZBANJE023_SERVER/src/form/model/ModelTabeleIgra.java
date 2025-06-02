package form.model;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Igra;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jovana
 */
public class ModelTabeleIgra extends AbstractTableModel{
    private List<Igra> list=new ArrayList<>();
    private String[] kolone = {"redni broj", "kombinacija klijenta","na mestu","van mesta"};
    
    public ModelTabeleIgra (List<Igra> list){
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
        Igra i = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return i.getRb();
            case 1: return i.getKombinacija();
            case 2: return i.getBrNaMestu();
            case 3: return i.getBrVanMesta();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajIgru(Igra i) {
        //promeni rb igre
        i.setRb(list.size()+1);
        list.add(i);
        fireTableDataChanged();
    }
    
    
}
