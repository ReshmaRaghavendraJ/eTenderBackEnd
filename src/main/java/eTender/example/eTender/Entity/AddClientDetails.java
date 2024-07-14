package eTender.example.eTender.Entity;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
	@Column(name="Clientid")
	private int clientid;
	
	@Column(name="ClientPersonName")
	private String clientPersonName;
	
	@Column(name="Phoneno")
	private String phoneno;
	
	@Column(name="Emailid")
	private String emailid;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Password")
	private String password;
	
	public AddClientDetails() 
	 {
		 generateClientid();
		 generatePassword();
	 }
	 
	 public void generateClientid() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.clientid = randomValue;
	    }
	 
	 public void generatePassword()
	 {
		 Random random=new Random();
		 StringBuilder passwordBuilder = new StringBuilder(6);
		 for (int i = 0; i < 6; i++) {
	            int index = random.nextInt(CHARACTERS.length());
	            passwordBuilder.append(CHARACTERS.charAt(index));
	        }
	        this.password = passwordBuilder.toString();
	    }
	
	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		clientid = clientid;
	}

	public String getClientPersonName() {
		return clientPersonName;
	}

	public void setClientPersonName(String clientPersonName) {
		clientPersonName = clientPersonName;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		phoneno = phoneno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		emailid = emailid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}

	@ManyToOne
	@JoinColumn(name="bid")
	private BidderRegistration bidderregistration;
	
	@OneToMany(mappedBy="addclientdetails")
	@JsonIgnore
	private List<AddClientProjectwork>addclientprojectwork;
}
