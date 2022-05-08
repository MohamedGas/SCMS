package com.amedev.scms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.amedev.scms.DTO.ManagerDTO;
import com.amedev.scms.model.Address;
import com.amedev.scms.model.Manager;
import com.amedev.scms.model.Name;
import com.amedev.scms.model.Role;
import com.amedev.scms.repository.ManagerRepository;

import exceptions.DataNotFoundException;

@Service
public class ManagerServiceImplementation implements ManagerService {

	private ManagerRepository managerRepository;

	public ManagerServiceImplementation(ManagerRepository managerRepository) {

		this.managerRepository = managerRepository;
	}

	@Override
	public List<ManagerDTO> getAllManagers() {
		return managerRepository.findAll().stream().map(this::dtoConverter).collect(Collectors.toList());

	}

	@Override
	public Manager saveManager(Manager manager) {
		
		return managerRepository.save(manager);
	}

	@Override
	public Optional<ManagerDTO> getManagerById(Long id) {
		Optional<ManagerDTO> manager = managerRepository.findById(id).map(this::dtoConverter);
		
		
		return manager;
		
	}

	@Override
	public Manager updateManagerById(Manager manager,Long id) {
		Manager oldManager = managerRepository.findById(id).orElseThrow(()-> new NoSuchElementException("DATA NOT FOUND"));
		oldManager.setAddress(manager.getAddress());
		oldManager.setEmail(manager.getEmail());
		oldManager.setName(manager.getName());
		oldManager.setUserName(manager.getUserName());
		oldManager.setRoles(manager.getRoles());
		oldManager.setPassword(manager.getPassword());
		managerRepository.save(oldManager);
		return oldManager;
		
		
		
		
		

	}

	@Override
	public void deleteManagerById(Long id) {
		Manager existingManager = managerRepository.findById(id).orElseThrow(()-> new NoSuchElementException("DATA NOT FOUND "));
		managerRepository.delete(existingManager);
		
	}

	private ManagerDTO dtoConverter(Manager manager) {
		ManagerDTO dto = new ManagerDTO();
		dto.setId(manager.getId());
		dto.setName(manager.getName());
		dto.setUserName(manager.getUserName());
		dto.setEmail(manager.getEmail());
		dto.setRoles(manager.getRoles());
		dto.setAddress(manager.getAddress());
		dto.setPassword(manager.getPassword());
		return dto;
	}

//	@PostConstruct
//  private void postConstruct() {
//      Name name1 = new Name();
//      
//      name1.setFirstName("Khadar");
//      name1.setLastName("Ali");
//      
//      Address address1 = new Address();
//      address1.setCityName("Seattle");
//      address1.setStateName("WA");
//      address1.setStreetName("7501 24TH AVE SW");
//      address1.setZipCode(98106);
//      
//      
//      
//      
//      
//      Manager manager1 = new Manager();
//      manager1.setId(2L);
//      manager1.setAddress(address1);
//      manager1.setName(name1);
//      manager1.setEmail("ugaas62@hotmail.com");
//      manager1.setPassword("123");
//      manager1.setUserName("mohamedg");
//      
//      
//     //manager1.setRoles(roles);
//      
//      managerRepository.save(manager1);
//  }

}
