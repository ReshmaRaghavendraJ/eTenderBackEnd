package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.ClientFeedback;

public interface ClientFeedbackRepo extends JpaRepository<ClientFeedback,Integer> 
{
	boolean existsByAddclientprojectwork_Projectno(Integer projectno);
}
