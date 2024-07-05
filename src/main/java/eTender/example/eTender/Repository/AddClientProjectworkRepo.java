package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eTender.example.eTender.Entity.AddClientProjectwork;

public interface AddClientProjectworkRepo extends JpaRepository<AddClientProjectwork,Integer>
{
}
