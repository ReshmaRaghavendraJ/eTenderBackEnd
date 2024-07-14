package eTender.example.eTender.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eTender.dto.ProjectworkInfoDTO;

import eTender.example.eTender.Entity.AddClientDetails;
import eTender.example.eTender.Entity.AddClientProjectwork;
import eTender.example.eTender.Repository.AddClientDetailsRepo;
import eTender.example.eTender.Repository.AddClientProjectworkRepo;
import eTender.example.eTender.Repository.BidderRegistrationRepo;

@RestController
@CrossOrigin("*")
public class AddClientProjectworkController 
{
	@Autowired
	AddClientProjectworkRepo addclientprojectworkrepo;
	
	@Autowired
	AddClientDetailsRepo addclientdetailsrepo;
	
	@Autowired
	BidderRegistrationRepo bidderregistrationrepo;
	
	@PostMapping("/AddClientProjectwork/{clientid}")
	public ResponseEntity<?> AddClientProjectwork(@PathVariable Integer clientid,@RequestBody AddClientProjectwork obj)
	{
		 AddClientDetails addclientdetails = addclientdetailsrepo.findById(clientid).orElseThrow(() -> new RuntimeException("Client id not found"));
		 obj.setAddclientdetails(addclientdetails);
		 obj.setStatus("Active");
		 addclientprojectworkrepo.save(obj);
			return new ResponseEntity<>("Client Projectwork Added Successfully", HttpStatus.OK);
	}
	@GetMapping("/GetClientidName")
	public ResponseEntity<?>GetClientidName()
	{
		List<AddClientDetails>list=addclientdetailsrepo.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/GetAllProjects")
	public ResponseEntity<?>GetAllProjects()
	 {
    	var addclientprojectworklist=addclientprojectworkrepo.findAll();
		return new ResponseEntity <>(addclientprojectworklist,HttpStatus.OK);
    }
	@PutMapping("/StatusCompleted/{projectno}")
	public ResponseEntity<?>StatusCompleted(@PathVariable Integer projectno)
	{	
		Optional<AddClientProjectwork> L=addclientprojectworkrepo.findById(projectno);
		if(L.isPresent())
		{
			AddClientProjectwork obj1=L.get();
			 if ("Completed".equals(obj1.getStatus())) {
		            return new ResponseEntity<>("Project is already completed", HttpStatus.BAD_REQUEST);
		        }
			obj1.setStatus("Completed");	
			addclientprojectworkrepo.save(obj1);	
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("project Id not found",HttpStatus.OK);
	}
	
	/*this API is for displaying Projects in Tender Dashboard(Frontend)*/
	@GetMapping("/GettodisplayProjects/{clientid}")
	public ResponseEntity<?>GettodisplayProjects(@PathVariable Integer clientid)
	{
		List<ProjectworkInfoDTO> projectlist = addclientprojectworkrepo.findByClientId(clientid);
    	if (projectlist.isEmpty())
		 {
		        return new ResponseEntity<>("No Projects found for the given Clientid", HttpStatus.NOT_FOUND);
		    }
        return new ResponseEntity<>(projectlist, HttpStatus.OK);
    }
}
