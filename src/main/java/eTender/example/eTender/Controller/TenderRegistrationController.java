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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.TenderRegistration;
import eTender.example.eTender.Repository.TenderRegistrationRepo;

@RestController
@CrossOrigin("*")
public class TenderRegistrationController {
	@Autowired
	TenderRegistrationRepo tenderregrepo;

	@PostMapping("/TenderRegister")
	public ResponseEntity<?> TenderRegister(@RequestBody TenderRegistration obj) {
		tenderregrepo.save(obj);
		return new ResponseEntity<>("Tender Registered Successfully", HttpStatus.OK);
	}

	@GetMapping("/tlogin/{userid}/{password}")
    public ResponseEntity<String> tlogin(@PathVariable Integer userid, @PathVariable String password) {
        System.out.println("the userid and password is "+userid+" , "+password);
		Optional<TenderRegistration> userOptional = tenderregrepo.findById(userid);
        if (userOptional.isPresent()) {
            TenderRegistration user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok("Tender Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Userid not found");
        }
    }
}