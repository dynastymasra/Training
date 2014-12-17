/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
@Entity
@Table(name = "TRAINING_MAHASISWA")
public class Mahasiswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MAHASISWA_ID")
    private Long id;
    @Column(name = "MAHASISWA_NIM", unique = true, nullable = false)
    private String nim;
    @Column(name = "MAHASISWA_NAMA", nullable = false)
    private String nama;
    @Column(name = "MAHASISWA_ALAMAT", nullable = false)
    private String alamat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }        
}
