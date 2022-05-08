package com.amedev.scms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Task {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private Address address;
	private String landMark;
    @ManyToOne
    private Staff staff;

}
