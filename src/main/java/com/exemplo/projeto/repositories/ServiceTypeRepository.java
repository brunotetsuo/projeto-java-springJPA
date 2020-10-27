package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>{

}
