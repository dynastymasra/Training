/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.squarecode.training.repository;

import com.squarecode.training.domain.Mahasiswa;
import java.util.List;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public interface MahasiswaRepository {

    public void save(Mahasiswa mahasiswa);

    public Mahasiswa update(Long id, Mahasiswa mahasiswa);

    public void delete(Long id);
    
    public Mahasiswa findById(Long id);

    public List<Mahasiswa> findAll();
}
