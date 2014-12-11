/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.squarecode.training.model;

import com.squarecode.training.domain.Mahasiswa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class TableModelMahasiswa extends AbstractTableModel {
    private static final long serialVersionUID = 1L;  
    private List<Mahasiswa> mahasiswas;

    public TableModelMahasiswa(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }    

    @Override
    public int getRowCount() {
        return mahasiswas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIM";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return mahasiswas.get(rowIndex).getNim();
            case 1:
                return mahasiswas.get(rowIndex).getNama();
            case 2:
                return mahasiswas.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
}
