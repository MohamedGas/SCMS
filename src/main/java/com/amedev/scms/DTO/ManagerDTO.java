package com.amedev.scms.DTO;

import java.util.ArrayList;
import java.util.List;

import com.amedev.scms.model.Address;
import com.amedev.scms.model.Manager;
import com.amedev.scms.model.Name;
import com.amedev.scms.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {
	private Long id;
	private Name name;
	private Address address;
	private String email;
	private String userName;
	private String password;

	private List<Role> roles = new ArrayList<>();

}
