package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.CreateTender;

public interface CreateTenderRepo extends JpaRepository<CreateTender,Integer>
{

}
