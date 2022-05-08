package com.amedev.scms.service;

import java.util.List;
import java.util.Optional;

import com.amedev.scms.DTO.ManagerDTO;
import com.amedev.scms.model.Manager;

public interface ManagerService {

	// Getting the list of managers
	public List<ManagerDTO> getAllManagers();

	// Saving Manager
	public Manager saveManager(Manager manager);

	// Getting the manager by id
	public Optional<ManagerDTO> getManagerById(Long id);

	// updating the manager by Id
	public Manager updateManagerById(Manager manage ,Long id);

	// delete manager by Id
	public void deleteManagerById(Long id);

}
