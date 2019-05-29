package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.InformationsSiege;

@Mapper
public interface SiegeMapper{
    InformationsSiege get(Long id);
}
