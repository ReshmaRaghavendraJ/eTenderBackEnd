package eTender.example.eTender.Entity;

import java.time.LocalDate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ClientFeedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientFeedback 
{
	@Id
	private int Feedbackno;
	private String Feedback;
	
	@Temporal(TemporalType.DATE)
	private Date FeedbackDate;
	
	public ClientFeedback() 
	 {
		 generateFeedbackno();
	 }
	 
	 public void generateFeedbackno()
	 {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.Feedbackno = randomValue;
	 } 
	
	 public LocalDate getCurrentDate() 
	 {
	        return LocalDate.now();
	 }
	 
	public int getFeedbackno() {
		return Feedbackno;
	}
	public void setFeedbackno(int feedbackno) {
		Feedbackno = feedbackno;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	public Date getFeedbackDate() {
		return FeedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		FeedbackDate = feedbackDate;
	}
	
	public AddClientProjectwork getAddclientprojectwork() 
	{
		return addclientprojectwork;
	}

	public void setAddclientprojectwork(AddClientProjectwork addclientprojectwork)
	{
		this.addclientprojectwork = addclientprojectwork;
	}
	
	@ManyToOne
	@JoinColumn(name="pid")
	private AddClientProjectwork addclientprojectwork;
	
}
