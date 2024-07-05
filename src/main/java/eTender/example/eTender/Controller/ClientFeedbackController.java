package eTender.example.eTender.Controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.AddClientProjectwork;
import eTender.example.eTender.Entity.ClientFeedback;
import eTender.example.eTender.Repository.AddClientProjectworkRepo;
import eTender.example.eTender.Repository.ClientFeedbackRepo;

@RestController
@CrossOrigin("*")
public class ClientFeedbackController 
{
	@Autowired
	ClientFeedbackRepo clientfeedbackrepo;
	
	@Autowired
	AddClientProjectworkRepo addclientprojectworkrepo;
	
	
	@PostMapping("/PostComments/{projectno}")
	public ResponseEntity<?>PostComments(@PathVariable Integer projectno,@RequestBody ClientFeedback obj)
	{
		AddClientProjectwork addclientprojectwork=addclientprojectworkrepo.findById(projectno).orElseThrow(()->new RuntimeException("Project no not found"));
		 if (clientfeedbackrepo.existsByAddclientprojectwork_Projectno(projectno)) 
		 {
	            return ResponseEntity.status(409).body("Comments already posted for this project.");
	     }
		obj.setAddclientprojectwork(addclientprojectwork);
		obj.setFeedbackDate(new Date());
		clientfeedbackrepo.save(obj);
		return new ResponseEntity<>("Comments Posted Successfuly",HttpStatus.OK);
	}
	
	@PostMapping("/postCurrentdate")
	 public LocalDate Getcurrentdate() 
	{
		return new ClientFeedback().getCurrentDate();
	}
}
