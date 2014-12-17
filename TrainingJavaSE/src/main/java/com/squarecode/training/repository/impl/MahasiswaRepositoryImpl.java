/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.repository.impl;

import com.squarecode.training.domain.Mahasiswa;
import com.squarecode.training.repository.MahasiswaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
@Service
@Transactional
public class MahasiswaRepositoryImpl implements MahasiswaRepository {
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Mahasiswa mahasiswa) {
        entityManager.persist(mahasiswa);
    }

    @Override
    public Mahasiswa update(Long id, Mahasiswa mahasiswa) {
        Mahasiswa oldData = findById(id);
        oldData.setNim(mahasiswa.getNim());
        oldData.setNama(mahasiswa.getNama());
        oldData.setAlamat(mahasiswa.getAlamat());
        
        return entityManager.merge(oldData);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Mahasiswa> findAll() {
        Query query = entityManager.createQuery("SELECT m FROM Mahasiswa m ORDER BY m.nim", Mahasiswa.class);
        
        return query.getResultList();
    }

    @Override
    public Mahasiswa findById(Long id) {
        return entityManager.find(Mahasiswa.class, id);
    }    
}
