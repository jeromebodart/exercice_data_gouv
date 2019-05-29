package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.Entreprise;

@Mapper
public interface EntrepriseMapper{
    List<Entreprise> findAll();

    Entreprise findOne(Long id);

    void save(Entreprise player);

    void update(Entreprise player);

    void delete(Long id);
}
