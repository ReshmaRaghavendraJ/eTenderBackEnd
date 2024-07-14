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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eTender.dto.BidderInfoDTO;

import eTender.example.eTender.Entity.BidderRegistration;
import eTender.example.eTender.Repository.BidderRegistrationRepo;

@RestController
@CrossOrigin("*")

public class BidderRegistrationController 
{
	@Autowired
	BidderRegistrationRepo bidderregrepo;
	
	@PostMapping("/BidderRegister")
	public ResponseEntity<?> BidderRegister(@RequestBody BidderRegistration obj) {
		bidderregrepo.save(obj);
		return new ResponseEntity<>("Bidder Registered Successfully", HttpStatus.OK);
	}
	@GetMapping("/blogin/{userid}/{password}")
    public ResponseEntity<String> blogin(@PathVariable Integer userid, @PathVariable String password) 
	{
        System.out.println("the userid and password is "+userid+" , "+password);
		Optional<BidderRegistration> userOptional = bidderregrepo.findById(userid);
        if (userOptional.isPresent()) {
            BidderRegistration user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok("Bidder Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Userid not found");
        }
	}
        @GetMapping("/GetAllBidders")
        public ResponseEntity<?>GetAllBidders()
        {
        	var Bidderslist=bidderregrepo.findAll();
    		return new ResponseEntity <>(Bidderslist,HttpStatus.OK);
        }
        
        /*this API is for displaying all Bidders in Tender Dashboard(Frontend)*/
        @GetMapping("/GetAlltodisplayBidders/{tenderid}")
        public ResponseEntity<?>GetAlltodisplayBidders(@PathVariable Integer tenderid)
        {
        	List<BidderInfoDTO> bidderList = bidderregrepo.findByTenderId(tenderid);
        	if (bidderList.isEmpty())
			 {
			        return new ResponseEntity<>("No Bidders found for the given Tender", HttpStatus.NOT_FOUND);
			    }
            return new ResponseEntity<>(bidderList, HttpStatus.OK);
        }
    }


