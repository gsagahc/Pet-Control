package petcontrol.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcontrol.exceptions.ResourceNotFoundException;
import petcontrol.model.PetEntity;
import petcontrol.repository.PetRepository;


@Service
public class PetServices {
	
    private Logger logger= Logger.getLogger(PetServices.class.getName());
   @Autowired
   PetRepository petRepository;
    
   public List<PetEntity> findAll() {
   	
		return petRepository.findAll();
   	
   }
  
	public PetEntity create(PetEntity pet) {
    	logger.info("Creating one pet!");
    	return petRepository.save(pet);
    	
    }
    public PetEntity update(PetEntity pet) {
    	logger.info("Updating one pet!");
    	PetEntity entity = petRepository.findById(pet.getId())
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    	entity.setPetName(pet.getPetName());
    	entity.setPetBreed(pet.getPetBreed());
    	entity.setPetKind(pet.getPetKind());
    	entity.setPetOwner(pet.getPetOwner());
    	entity.setAddress(pet.getAddress());
    	entity.setEmail(pet.getEmail());
    	entity.setPhoneNumber(pet.getPhoneNumber());
    	entity.setGender(pet.getGender());
    	return petRepository.save(entity);
    	
    }
  
	public PetEntity findByid(Long id) {
    	logger.info("Finding one pet!");
     	return petRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    }
	public void delete(Long id) {
		logger.info("Deleting one pet!");
		PetEntity entity = petRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
		 petRepository.delete(entity);
	}
}
