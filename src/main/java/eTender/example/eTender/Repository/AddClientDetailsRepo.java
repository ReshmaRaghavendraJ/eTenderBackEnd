package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.AddClientDetails;

public interface AddClientDetailsRepo extends JpaRepository<AddClientDetails,Integer>
{

	//List<AddClientDetails> findByBid(Integer clientid);

}
