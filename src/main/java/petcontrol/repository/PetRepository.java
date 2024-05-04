package petcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petcontrol.model.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long>{

}
