package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.ApplyTender;
import eTender.example.eTender.Entity.BidderRegistration;
import eTender.example.eTender.Entity.CreateTender;

public interface ApplyTenderRepo extends JpaRepository<ApplyTender,Integer>
{
	boolean existsByCreatetender1AndBidderregistration1(CreateTender createtender, BidderRegistration bidderregistration);
}
