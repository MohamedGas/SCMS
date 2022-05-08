package com.amedev.scms.DTO;

import java.util.ArrayList;
import java.util.List;

import com.amedev.scms.model.Address;
import com.amedev.scms.model.Manager;
import com.amedev.scms.model.Name;
import com.amedev.scms.model.Role;
import com.amedev.scms.model.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
	private Long id;
	private Name name;
	private Address address;
	private String email;
	private String userName;
	private String password;
	private List<Role> roles = new ArrayList<>();
	private List<Task> task = new ArrayList<>();
	private Manager manager;
}
