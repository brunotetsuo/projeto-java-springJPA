package com.exemplo.projeto.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.projeto.entities.ServiceType;
import com.exemplo.projeto.services.ServiceTypeService;

@RestController
@RequestMapping(value = "/serviceTypes")
public class ServiceTypeResource {
	
	@Autowired
	private ServiceTypeService service;
	
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@GetMapping
	public ResponseEntity<List<ServiceType>> findAll() throws ParseException {
		List<ServiceType> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceType> findById(@PathVariable Long id) {
		ServiceType obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}