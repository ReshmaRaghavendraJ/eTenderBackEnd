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
@Table(name="AddClientProjectWork")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class AddClientProjectwork
{
	@Id
	@Column(name="projectno")
	private int projectno;
	
	@Column(name="ClientProjectName")
	private String clientProjectName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Status")
	private String status;
	
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
		return clientProjectName;
	}
	public void setClientProjectName(String clientProjectName) {
		clientProjectName = clientProjectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		status = status;
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
