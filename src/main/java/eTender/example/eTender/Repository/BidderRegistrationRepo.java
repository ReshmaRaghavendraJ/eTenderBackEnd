package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.BidderRegistration;

public interface BidderRegistrationRepo extends JpaRepository<BidderRegistration,Integer> 
{

}
