package com.elhaouari.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhaouari.bank.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

}
