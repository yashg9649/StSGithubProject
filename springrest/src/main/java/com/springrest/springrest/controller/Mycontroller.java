package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Load;
import com.springrest.springrest.services.loadService;

@RestController
public class Mycontroller {
	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	@Autowired
	private loadService loadservice;
	
//	get load
	@GetMapping("/load")
	public List<Load> getLoads()
	{
		return this.loadservice.getLoads();
	}
	
	@GetMapping("/load/{loadId}")
	public Load getLoad(@PathVariable String loadId)
	{
		return this.loadservice.getLoad(Long.parseLong(loadId));
	}
	
	@PostMapping("/load")
	public Load addLoad(@RequestBody Load load)
	{
		return this.loadservice.addLoad(load);
	}
	
	@PutMapping("/load")
	public Load updateLoad(@RequestBody Load load)
	{
		return this.loadservice.updateLoad(load);
	}
	
	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId){
		try {
			this.loadservice.deleteLoad(Long.parseLong(loadId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
