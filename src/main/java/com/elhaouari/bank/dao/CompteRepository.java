package com.elhaouari.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhaouari.bank.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
