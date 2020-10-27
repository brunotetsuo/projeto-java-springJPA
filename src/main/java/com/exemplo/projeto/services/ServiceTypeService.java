package com.exemplo.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.projeto.entities.ServiceType;
import com.exemplo.projeto.repositories.ServiceTypeRepository;

@Service
public class ServiceTypeService {
	
	@Autowired
	private ServiceTypeRepository repository;
	
	public List<ServiceType> findAll() {
		return repository.findAll();
	}
	
	public ServiceType findById(Long id) {
		Optional<ServiceType> obj = repository.findById(id);
		return obj.get();
	}
}