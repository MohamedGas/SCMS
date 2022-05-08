package com.amedev.scms.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Name name;
	private Address address;
	private String email;
	private String userName;
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
    @JsonIgnore
    private List<Role> roles = new ArrayList<>();  
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staff")
	 
	private List<Task> task = new ArrayList<>();
	@ManyToOne()
	@JoinColumn(name = "manager_id")
	private Manager manager;
}
