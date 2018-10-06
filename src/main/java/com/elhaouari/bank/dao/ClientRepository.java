package com.elhaouari.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhaouari.bank.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
