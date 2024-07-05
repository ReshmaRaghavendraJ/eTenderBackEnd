package eTender.example.eTender.Entity;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CreateTender")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTender
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Tenderid;
	
	private String tendername;
	
	@Temporal(TemporalType.DATE)
	private Date bidstardate;
	
	@Temporal(TemporalType.DATE)
	private Date bidclosedate;
	
	private String description;
	private String status;
	
	public int getTenderid() {
		return Tenderid;
	}
	public void setTenderid(int tenderid) {
		Tenderid = tenderid;
	}

	public String getTendername() {
		return tendername;
	}

	public void setTendername(String tendername) {
		this.tendername = tendername;
	}

	public Date getBidstardate() {
		return bidstardate;
	}

	public void setBidstardate(Date bidstardate) {
		this.bidstardate = bidstardate;
	}

	public Date getBidclosedate() {
		return bidclosedate;
	}

	public void setBidclosedate(Date bidclosedate) {
		this.bidclosedate = bidclosedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public TenderRegistration getTenderregistration() {
		return tenderregistration;
	}

	public void setTenderregistration(TenderRegistration tenderregistration) {
		this.tenderregistration = tenderregistration;
	}

	public List<ApplyTender> getApplytender() {
		return applytender;
	}

	public void setApplytender(List<ApplyTender> applytender) {
		this.applytender = applytender;
	}

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "TenderCompanyid")
	private TenderRegistration tenderregistration;
	
	@OneToMany(mappedBy="createtender1")
	@JsonIgnore
	private List<ApplyTender>applytender;
	
}
