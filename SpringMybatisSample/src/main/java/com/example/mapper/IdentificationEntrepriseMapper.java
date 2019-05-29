package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.IdentificationEntreprise;

@Mapper
public interface IdentificationEntrepriseMapper{
	IdentificationEntreprise get(Long id);
}
