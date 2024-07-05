package eTender.example.eTender.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.Category;
import eTender.example.eTender.Entity.CreateTender;
import eTender.example.eTender.Entity.TenderRegistration;
import eTender.example.eTender.Repository.CategoryRepo;
import eTender.example.eTender.Repository.CreateTenderRepo;
import eTender.example.eTender.Repository.TenderRegistrationRepo;

@RestController
@CrossOrigin("*")
public class CreateTenderController {
	@Autowired
	CreateTenderRepo createtenderrepo;

	@Autowired
	CategoryRepo categoryrepo;
	
	@Autowired
	TenderRegistrationRepo tenderregrepo;
	
	@PostMapping("/Createtender/{categoryId}/{TenderCompanyid}")
	public ResponseEntity<?> Createtender(@PathVariable Integer categoryId,@PathVariable Integer TenderCompanyid,@RequestBody CreateTender obj) 
	{
		Category category=categoryrepo.findById(categoryId).orElseThrow(()->new RuntimeException("Category id not found"));
		 TenderRegistration tenderRegistration = tenderregrepo.findById(TenderCompanyid).orElseThrow(() -> new RuntimeException("Tender company id not found"));
		 obj.setCategory(category);
	     obj.setTenderregistration(tenderRegistration);
		obj.setStatus("Active");
		 CreateTender createdTender = createtenderrepo.save(obj);
		return new ResponseEntity<>("New Tender Created", HttpStatus.OK);
	}	

	@GetMapping("/Getcategory")
	public ResponseEntity<?> Getcategory() {
		List<Category> list = categoryrepo.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);		
	}
}
