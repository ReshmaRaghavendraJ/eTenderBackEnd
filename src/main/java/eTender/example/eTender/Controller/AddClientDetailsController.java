package eTender.example.eTender.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.AddClientDetails;
import eTender.example.eTender.Entity.BidderRegistration;
import eTender.example.eTender.Repository.AddClientDetailsRepo;
import eTender.example.eTender.Repository.BidderRegistrationRepo;

@RestController
@CrossOrigin("*")
public class AddClientDetailsController 
{
	@Autowired
	BidderRegistrationRepo bidderregrepo;
	
	@Autowired
	AddClientDetailsRepo addclientdetailsrepo;
	
	@PostMapping("/AddClientDetails/{Bidderid}")
	public ResponseEntity<?>AddClientDetails(@PathVariable Integer Bidderid,@RequestBody AddClientDetails obj)
	{
		BidderRegistration bidderid=bidderregrepo.findById(Bidderid).orElseThrow(()->new RuntimeException("Bidder id not found"));
		 obj.setBidderregistration(bidderid);
		 AddClientDetails addclientdetails = addclientdetailsrepo.save(obj);
		return new ResponseEntity<>("New Client Added Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/GetAllClients")
	public ResponseEntity<?>GetAllClients()
	 {
    	var Clientslist=addclientdetailsrepo.findAll();
		return new ResponseEntity <>(Clientslist,HttpStatus.OK);
    }
	
	@GetMapping("/clogin/{userid}/{password}")
    public ResponseEntity<String> blogin(@PathVariable Integer userid, @PathVariable String password) 
	{
        System.out.println("the userid and password is "+userid+" , "+password);
		Optional<AddClientDetails> userOptional = addclientdetailsrepo.findById(userid);
        if (userOptional.isPresent()) {
        	AddClientDetails user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok("Client Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Userid not found");
        }
	}
}
