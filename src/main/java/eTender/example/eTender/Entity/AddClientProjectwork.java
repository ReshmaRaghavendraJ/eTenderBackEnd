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
@Table(name="AddClientProjectWork")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class AddClientProjectwork
{
	@Id
	private int projectno;
	private String ClientProjectName;
	private String Description;
	private String Status;
	
	public AddClientProjectwork() 
	 {
		 generateProjectno();
	 }
	 
	 public void generateProjectno() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.projectno = randomValue;
	    }
	

	public int getProjectno() {
		return projectno;
	}

	public void setProjectno(int projectno) {
		this.projectno = projectno;
	}

	public String getClientProjectName() {
		return ClientProjectName;
	}
	public void setClientProjectName(String clientProjectName) {
		ClientProjectName = clientProjectName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public AddClientDetails getAddclientdetails() {
		return addclientdetails;
	}
	public void setAddclientdetails(AddClientDetails addclientdetails) {
		this.addclientdetails = addclientdetails;
	}
	public List<ClientFeedback> getClientfeedback() {
		return clientfeedback;
	}
	public void setClientfeedback(List<ClientFeedback> clientfeedback) {
		this.clientfeedback = clientfeedback;
	}


	@ManyToOne
	@JoinColumn(name="Cltid")
	private AddClientDetails addclientdetails;
	
	@OneToMany(mappedBy="addclientprojectwork")
	@JsonIgnore
	private List<ClientFeedback>clientfeedback;
}
