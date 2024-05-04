package petcontrol.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import petcontrol.model.PetEntity;
import petcontrol.services.PetServices;



@RestController
@RequestMapping("/pet")
public class PetController {

	
    @Autowired	
	private PetServices service;
    @Cacheable(value = "listaPets", key ="#id", condition="#p0!=null")
	@GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
	public List<PetEntity> findAll()
		 {
		return service.findAll();
			
	}
	@GetMapping(value = "/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public PetEntity findByid(@PathVariable(value = "id") Long id)
	{
		return service.findByid(id);
		
		
		
	}
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			     consumes =MediaType.APPLICATION_JSON_VALUE)

	public PetEntity create(@RequestBody PetEntity pet)
	{
		return service.create(pet);
		
		
		
	}
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			    consumes =MediaType.APPLICATION_JSON_VALUE)
	public PetEntity update(@RequestBody PetEntity pet)
	{
		return service.update(pet);
		
		
		
	}
	@DeleteMapping(value = "/{id}")
	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id)
	{
		 service.delete(id);
		 return ResponseEntity.noContent().build();
		
		
		
		
	}
}
