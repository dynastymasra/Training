/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.domain;

import com.squarecode.training.domain.enums.Gender;
import com.squarecode.training.domain.enums.Religion;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
@Entity
@Table(name = "TRAINING_IDENTITY")
public class Identity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDENTITY_ID")
    private Long id;
    @Column(name = "IDENTITY_NO", nullable = false)
    private String no;
    @Column(name = "IDENTITY_NAMA", nullable = false)
    private String nama;
    @Column(name = "IDENTITY_GENDER", nullable = false)
    private Gender gender;
    @Column(name = "IDENTITY_RELIGION", nullable = false)
    private Religion religion;
    @Column(name = "IDENTITY_ALAMAT", nullable = false)
    private String alamat;
    @Column(name = "IDENTITY_TELP", nullable = false)
    private String telp;
    @OneToMany(mappedBy = "identity")
    private List<Mahasiswa> mahasiswas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }        
}
