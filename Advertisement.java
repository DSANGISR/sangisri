package com.onlineadvertisement.entity;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlineadvertisement.entity.User.Customer;

@Entity
 public class Advertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int advertisementId;
	
	@NotNull
	private String advertiseTitle;
	
	@OneToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	@NotNull
	private double price;
	
	@NotNull
	private String description;

	@ManyToOne
	@JoinColumn(name="usrId")
	@JsonBackReference
	private Customer customer;

	public Advertisement() {
		super();
	}

	

	
	public Advertisement(int advertisementId, @NotNull String advertiseTitle, Category category, @NotNull double price,
			@NotNull String description, Customer customer) {
		super();
		this.advertisementId = advertisementId;
		this.advertiseTitle = advertiseTitle;
		this.category = category;
		this.price = price;
		this.description = description;
		this.customer = customer;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getAdvertiseTitle() {
		return advertiseTitle;
	}

	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}

	public Category getCategory() {
		return category;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", advertiseTitle=" + advertiseTitle
				+ ", category=" + category + ", price=" + price + ", description=" + description + "]";
	}

	
}

