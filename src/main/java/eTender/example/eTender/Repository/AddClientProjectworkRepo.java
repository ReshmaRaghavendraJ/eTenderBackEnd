package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTender.dto.ProjectworkInfoDTO;

import eTender.example.eTender.Entity.AddClientProjectwork;

public interface AddClientProjectworkRepo extends JpaRepository<AddClientProjectwork,Integer>
{
	@Query("SELECT new com.eTender.dto.ProjectworkInfoDTO(pr.projectno,pr.clientProjectName,pr.description,pr.status) " +
	           "FROM AddClientProjectwork pr JOIN pr.addclientdetails ac WHERE ac.clientid=:clientid")
	    List<ProjectworkInfoDTO> findByClientId(@Param("clientid") Integer clientid);
}
