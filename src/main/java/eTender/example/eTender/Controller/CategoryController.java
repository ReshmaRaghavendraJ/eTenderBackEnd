package eTender.example.eTender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.Category;
import eTender.example.eTender.Repository.CategoryRepo;

@RestController
@CrossOrigin("*")
public class CategoryController 
{
	@Autowired
	CategoryRepo categoryrepo;
	
	@PostMapping("/AddCategory")
	public ResponseEntity<?>AddCategory(@RequestBody Category obj)
	{
			categoryrepo.save(obj);
			return new ResponseEntity <>("Category Added",HttpStatus.OK);
	}
	
	@GetMapping("/GetCategorylist")
	public ResponseEntity <?> GetCategory()
	{
		var categorylist=categoryrepo.findAll();
		return new ResponseEntity <>(categorylist,HttpStatus.OK);
	}
}

