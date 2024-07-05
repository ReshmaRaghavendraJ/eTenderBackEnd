package eTender.example.eTender.Entity;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="AddClientDetails")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class AddClientDetails
{
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public BidderRegistration getBidderregistration() {
		return bidderregistration;
	}

	public void setBidderregistration(BidderRegistration bidderregistration) {
		this.bidderregistration = bidderregistration;
	}

	public List<AddClientProjectwork> getAddclientprojectwork() {
		return addclientprojectwork;
	}

	public void setAddclientprojectwork(List<AddClientProjectwork> addclientprojectwork) {
		this.addclientprojectwork = addclientprojectwork;
	}
	
	@Id
	private int Clientid;
	private String ClientPersonName;
	private String Phoneno;
	private String Emailid;
	private String Address;
	private String Password;
	
	public AddClientDetails() 
	 {
		 generateClientid();
		 generatePassword();
	 }
	 
	 public void generateClientid() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.Clientid = randomValue;
	    }
	 
	 public void generatePassword()
	 {
		 Random random=new Random();
		 StringBuilder passwordBuilder = new StringBuilder(6);
		 for (int i = 0; i < 6; i++) {
	            int index = random.nextInt(CHARACTERS.length());
	            passwordBuilder.append(CHARACTERS.charAt(index));
	        }
	        this.Password = passwordBuilder.toString();
	    }
	
	public int getClientid() {
		return Clientid;
	}

	public void setClientid(int clientid) {
		Clientid = clientid;
	}

	public String getClientPersonName() {
		return ClientPersonName;
	}

	public void setClientPersonName(String clientPersonName) {
		ClientPersonName = clientPersonName;
	}

	public String getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@ManyToOne
	@JoinColumn(name="bid")
	private BidderRegistration bidderregistration;
	
	@OneToMany(mappedBy="addclientdetails")
	@JsonIgnore
	private List<AddClientProjectwork>addclientprojectwork;
}
