package eTender.example.eTender.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@Column(name="Feedbackno")
	private int feedbackno;
	
	@Column(name="Feedback")
	private String feedback;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FeedbackDate")
	private Date feedbackDate;
	
	public ClientFeedback() 
	 {
		 generateFeedbackno();
	 }
	 
	 public void generateFeedbackno()
	 {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.feedbackno = randomValue;
	 } 
	
	 public LocalDate getCurrentDate() 
	 {
	        return LocalDate.now();
	 }
	 
	public int getFeedbackno() {
		return feedbackno;
	}
	public void setFeedbackno(int feedbackno) {
		feedbackno = feedbackno;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		feedback = feedback;
	}
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		feedbackDate = feedbackDate;
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
