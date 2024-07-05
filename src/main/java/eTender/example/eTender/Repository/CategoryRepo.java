package eTender.example.eTender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eTender.example.eTender.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> 
{

}
