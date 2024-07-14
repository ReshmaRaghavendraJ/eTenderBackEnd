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
import lombok.Setter;

@Entity
@Table(name="tender_registration")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class TenderRegistration 
{
	@Id
	private int TenderCompanyid;
	private String fname;
	private String email;
	private String phoneno;
	private String address;
	private String password;
	
	
	public int getTenderCompanyid() {
		return TenderCompanyid;
	}
	public void setTenderCompanyid(int tenderCompanyid) {
		TenderCompanyid = tenderCompanyid;
	}
	
	
	 public TenderRegistration() 
	 {
		 generateTenderCompanyid();
	 }
	 
	
	 public void generateTenderCompanyid() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.TenderCompanyid = randomValue;
	    }
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy="tenderregistration")
	@JsonIgnore
	private List<CreateTender>createtender;
		
}
