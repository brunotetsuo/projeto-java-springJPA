package com.exemplo.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exemplo.projeto.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("FROM Client WHERE UPPER(name) LIKE CONCAT('%', UPPER(?1), '%')")
	List<Client> findByNameIgnoreCase(String name);

}
