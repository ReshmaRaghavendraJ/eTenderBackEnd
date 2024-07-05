package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.TenderRegistration;

public interface TenderRegistrationRepo extends JpaRepository<TenderRegistration,Integer>
{

}
