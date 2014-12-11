/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.repository;

import com.squarecode.training.domain.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class MahasiswaRepository {
    private Connection connection;

    public MahasiswaRepository() {
        this.connection = DatabaseConnection.getConnection();
    }        
    
    public void insertData(String nim, String nama, String alamat) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `MAHASISWA`(`NIM`, `NAMA`, `ALAMAT`) VALUES (?, ?, ?)");
        preparedStatement.setString(1, nim);
        preparedStatement.setString(2, nama);
        preparedStatement.setString(3, alamat);
        preparedStatement.executeUpdate();

        System.out.println("Insert Success");
    }      
    
    public void updateData(String nim, String nama, String alamat, String oldNim) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `MAHASISWA` SET `NIM`=?,`NAMA`=?,`ALAMAT`=? WHERE `NIM` = ?");
        preparedStatement.setString(1, nim);
        preparedStatement.setString(2, nama);
        preparedStatement.setString(3, alamat);
        preparedStatement.setString(4, oldNim);
        preparedStatement.executeUpdate();

        System.out.println("Insert Success");
    }
    
    public void deleteData(String nim) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `MAHASISWA` WHERE `NIM` = ?");
        preparedStatement.setString(1, nim);
        preparedStatement.executeUpdate();

        System.out.println("Insert Success");
    }
    
    public List<Mahasiswa> findAllData() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `MAHASISWA`");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        
        while(resultSet.next()) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNim(resultSet.getString("NIM"));
            mahasiswa.setNama(resultSet.getString("NAMA"));
            mahasiswa.setAlamat(resultSet.getString("ALAMAT"));
            mahasiswas.add(mahasiswa);                        
        }
            
        return mahasiswas;
    }
    
    public boolean update(String nim, String nama, String alamat, String oldNim) {      
        try {
            connection.setAutoCommit(false);
            updateData(nim, nama, alamat, oldNim);
            
            connection.commit();
            System.out.println("Update Data Success");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
               
            }
            return false;
        }
        return true;
    }
    
    public boolean delete(String nim) {      
        try {
            connection.setAutoCommit(false);
            deleteData(nim);
            
            connection.commit();
            System.out.println("Delete Data Success");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
               
            }
            return false;
        }
        return true;
    }
    
    public boolean insert(String nim, String nama, String alamat) {      
        try {
            connection.setAutoCommit(false);
            insertData(nim, nama, alamat);
            
            connection.commit();
            System.out.println("Insert All Data Success");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
               
            }
            return false;
        }
        return true;
    }            
}
