package com.exemplo.projeto.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiceType implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String serviceType;
	private Double price;
	private Date scheduled;
	
	@ManyToOne
	private Client client;
	
	public ServiceType() {
	}

	public ServiceType(Long id, String serviceType, Double price, Date scheduled, Client client) {
		this.id = id;
		this.serviceType = serviceType;
		this.price = price;
		this.setScheduled(scheduled);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getScheduled() {
		return scheduled;
	}

	public void setScheduled(Date scheduled) {
		this.scheduled = scheduled;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}