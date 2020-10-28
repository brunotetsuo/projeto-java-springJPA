package com.exemplo.projeto.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.projeto.entities.Client;
import com.exemplo.projeto.resources.util.URL;
import com.exemplo.projeto.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() throws ParseException {
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<List<Client>> findByName(@RequestParam(value = "name", defaultValue = "") String name) {
		name = URL.decodeParam(name);
		List<Client> list = service.findByName(name);
		return ResponseEntity.ok().body(list);
	}
}