package com.amedev.scms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amedev.scms.DTO.ManagerDTO;
import com.amedev.scms.model.Manager;
import com.amedev.scms.service.ManagerServiceImplementation;


@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ManagerController {
	private ManagerServiceImplementation service;

	public ManagerController(ManagerServiceImplementation service) {

		this.service = service;
	}
	/**
	 * 
	 * @return list of managers
	 */
	@GetMapping("managers")
	public List<ManagerDTO> getAllManagers() {
		return service.getAllManagers();
	}
	/**
	 * 
	 * @param id 
	 * @return the manager
	 */
	
	@GetMapping("managers/{id}")
	public Optional<ManagerDTO> getManagerById(@PathVariable("id")  Long id )
	{
		return service.getManagerById(id);
	}
	/**
	 * 
	 * @param manager
	 * @return Save the manager
	 */
	@PostMapping("managers")

	public ResponseEntity<?> saveManager(@RequestBody Manager manager)

	{

		return new ResponseEntity<Manager>(service.saveManager(manager), HttpStatus.CREATED);

	}
	/**
	 * 
	 * @param manager
	 * @param id
	 * @return Update the manager 
	 */
	@PutMapping("managers/{id}")

	public ResponseEntity<?> updateManager(@RequestBody Manager manager,@PathVariable("id") Long id)

	{

		return new ResponseEntity<Manager>(service.updateManagerById(manager,id), HttpStatus.OK);

	}
	/**
	 * 
	 * @param id
	 * @return Delete the manager
	 */
	@DeleteMapping("managers/{id}")
	
	public ResponseEntity<?> deleteManager(@PathVariable("id") Long id)
	{
		service.deleteManagerById(id);
		return new ResponseEntity<String>("Succesfully Deleted",HttpStatus.OK);
		
		
	}

}
