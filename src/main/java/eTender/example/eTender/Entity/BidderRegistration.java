package eTender.example.eTender.Entity;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BidderRegistration")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class BidderRegistration 
{
	@Id
	private int Bidderid;
	private String BidderName;
	private String Emailid;
	private String Password;
	private String Mobileno;	
	private String Address;
	
	 public BidderRegistration() 
	 {
		 generateBidderid();
	 }
	 
	
	 public void generateBidderid() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.Bidderid = randomValue;
	    }
	
	
	public int getBidderid() {
		return Bidderid;
	}
	public void setBidderid(int bidderid) {
		Bidderid = bidderid;
	}
	public String getBidderName() {
		return BidderName;
	}
	public void setBidderName(String bidderName) {
		BidderName = bidderName;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMobileno() {
		return Mobileno;
	}
	public void setMobileno(String mobileno) {
		Mobileno = mobileno;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public List<AddClientDetails> getAddclientdetails() {
		return addclientdetails;
	}
	public void setAddclientdetails(List<AddClientDetails> addclientdetails) {
		this.addclientdetails = addclientdetails;
	}
	public List<ApplyTender> getApplytender() {
		return applytender;
	}
	public void setApplytender(List<ApplyTender> applytender) {
		this.applytender = applytender;
	}


	@OneToMany(mappedBy="bidderregistration")
	@JsonIgnore
	private List<AddClientDetails>addclientdetails;
	
	@OneToMany(mappedBy="bidderregistration1")
	@JsonIgnore
	private List<ApplyTender>applytender;
	
}
