package eTender.example.eTender.Entity;

import java.util.Random;

import jakarta.persistence.Column;
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
@Table(name="ApplyTender")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplyTender 
{
	@Id
	@Column(name="apno")
	private int apno;
	
	@Column(name="tenderQuotation")
	private int tenderQuotation;
	
	@Column(name="status")
	private String status;
	
	public ApplyTender() 
	 {
		 generateapno();
	 }
	 
	 public void generateapno() {
	        Random random = new Random();
	        int randomValue = (random.nextInt(90000) + 10000); // Generate a random number between 10000 and 99999
	        this.apno = randomValue;
	    }
	
	public int getApno() {
		return apno;
	}
	public void setApno(int apno) {
		this.apno = apno;
	}
	public int getTenderQuotation() {
		return tenderQuotation;
	}
	public void setTenderQuotation(int tenderQuotation) {
		tenderQuotation = tenderQuotation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public CreateTender getCreatetender1() {
		return createtender1;
	}
	public void setCreatetender1(CreateTender createtender1) {
		this.createtender1 = createtender1;
	}
	public BidderRegistration getBidderregistration1() {
		return bidderregistration1;
	}
	public void setBidderregistration1(BidderRegistration bidderregistration1) {
		this.bidderregistration1 = bidderregistration1;
	}

	@ManyToOne
	@JoinColumn(name="tender_id1")
	private CreateTender createtender1;
	
	@ManyToOne
	@JoinColumn(name="bidder_id2")
	private BidderRegistration bidderregistration1;
}
