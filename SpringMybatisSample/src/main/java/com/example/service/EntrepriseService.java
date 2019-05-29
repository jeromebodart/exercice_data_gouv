package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entreprise.Entreprise;
import com.example.mapper.EntrepriseMapper;

@Service
public class EntrepriseService {
    @Autowired
    private EntrepriseMapper entrepriseMapper;

    @Transactional
    public List<Entreprise> findAll() {
        return entrepriseMapper.findAll();
    }

    @Transactional
    public Entreprise findOne(Long id) {
        return entrepriseMapper.findOne(id);
    }

    @Transactional
    public void save(Entreprise player) {
    	entrepriseMapper.save(player);
    }

    @Transactional
    public void update(Entreprise player) {
    	entrepriseMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	entrepriseMapper.delete(id);
    }
}
