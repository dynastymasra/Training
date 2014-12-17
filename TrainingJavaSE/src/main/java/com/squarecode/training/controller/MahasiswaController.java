/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.controller;

import com.squarecode.training.domain.Mahasiswa;
import com.squarecode.training.repository.MahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
@Controller
public class MahasiswaController {
    
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    public List<Mahasiswa> findAll() {
        try {
            return mahasiswaRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error=>" + e);
            return null;
        }
    }

    public boolean save(Mahasiswa mahasiswa) {
        try {
            mahasiswaRepository.save(mahasiswa);
            return true;
        } catch (Exception e) {
            System.out.println("Error=>" + e);
            return false;
        }
    }

    public boolean delete(Long id) {
        try {
            mahasiswaRepository.delete(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error=>" + e);
            return false;
        }
    }
    
    public boolean update(Long id, Mahasiswa mahasiswa) {
        try {
            mahasiswaRepository.update(id, mahasiswa);
            return true;
        } catch (Exception e) {
            System.out.println("Error=>" + e);
            return false;
        }
    }
    
    public boolean findById(Long id) {
        try {
            mahasiswaRepository.findById(id);
            return true;
        } catch(Exception e) {
            System.out.println("Error=>" + e);
            return false;
        }
    }
}
