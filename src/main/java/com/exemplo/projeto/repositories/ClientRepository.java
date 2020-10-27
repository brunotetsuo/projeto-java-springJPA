package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
