package eTender.example.eTender.Entity;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
@NoArgsConstructor
public class BidderRegistration 
{
	@Id
	@Column(name = "Bidderid")
	private int bidderid;
	
	 @Column(name = "BidderName")
	private String bidderName;
	 
	 @Column(name = "Emailid")
	private String emailid;
	 
	 @Column(name = "Password")
	private String password;
	 
	 @Column(name = "Mobileno")
	private String mobileno;	
	 
	 @Column(name = "Address")
	private String address;
	
	 public BidderRegistration() 
	 {
		 generateBidderid();
	 }
	 
	
	 public void generateBidderid() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.bidderid = randomValue;
	    }
	
	
	public int getBidderid() {
		return bidderid;
	}
	public void setBidderid(int bidderid) {
		bidderid = bidderid;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		bidderName = bidderName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		address = address;
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
