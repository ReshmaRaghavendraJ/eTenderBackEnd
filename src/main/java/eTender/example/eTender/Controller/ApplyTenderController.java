package eTender.example.eTender.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eTender.example.eTender.Entity.ApplyTender;
import eTender.example.eTender.Entity.BidderRegistration;
import eTender.example.eTender.Entity.CreateTender;
import eTender.example.eTender.Repository.ApplyTenderRepo;
import eTender.example.eTender.Repository.BidderRegistrationRepo;
import eTender.example.eTender.Repository.CreateTenderRepo;

@RestController
@CrossOrigin("*")
public class ApplyTenderController
{	
	@Autowired
	CreateTenderRepo createtenderrepo;
	
	@Autowired
	BidderRegistrationRepo bidderregrepo;
	
	@Autowired
	ApplyTenderRepo applytenderrepo;
	
	/*this API is for displaying drop down list */
	@GetMapping("/GetCategorylisttoapplytender")
	public ResponseEntity <?> GetCategorytoapplytender()
	{
		List<CreateTender>categoriesinfo = createtenderrepo.findAll();
		return new ResponseEntity<>(categoriesinfo, HttpStatus.OK);
	}
	
	/*this API is for displaying all Tender list*/
	@GetMapping("/GetAllTenders")
	public ResponseEntity<?>GetAllTenders()
	 { 
			var tenderlist=createtenderrepo.findAll();
			return new ResponseEntity<>(tenderlist,HttpStatus.OK);
	 }
	
	
	/*this API is for posting Quotation for apply tender*/
	@PostMapping("/AddApplyTender/{tenderid}/{bidderid}")
	public ResponseEntity<?>AddApplyTender(@PathVariable Integer tenderid,@PathVariable Integer bidderid,@RequestBody ApplyTender obj)
	{
		CreateTender createtender=createtenderrepo.findById(tenderid).orElseThrow(()->new RuntimeException("Tender id not found"));
		BidderRegistration bidderRegistration = bidderregrepo.findById(bidderid).orElseThrow(() -> new RuntimeException("Bidder id not found"));
		boolean isAlreadyApplied = applytenderrepo.existsByCreatetender1AndBidderregistration1(createtender, bidderRegistration);
	    if (isAlreadyApplied) 
	    {
	        return new ResponseEntity<>("Tender already applied", HttpStatus.BAD_REQUEST);
	    }
		obj.setCreatetender1(createtender);
		obj.setBidderregistration1(bidderRegistration);
		obj.setStatus("Active");
		applytenderrepo.save(obj);
		return new ResponseEntity<>("Tender Applied Successfully", HttpStatus.OK);
	}
	
	/*this API is for checking the currentdate is Before or After the Bid Startdate or Bid Closedate*/
	@GetMapping("/Getdate/{bidstardate}/{bidclosedate}")
	public ResponseEntity<?> Getdate(@PathVariable("bidstardate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date bidstardate,
            @PathVariable("bidclosedate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date bidclosedate) 
	{
		Date currentdate=new Date();
		/*Coverting Date to String Type*/
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		String curdate=dateformat.format(currentdate);
		String startdate=dateformat.format(bidstardate);
		String clsdate=dateformat.format(bidclosedate);
		
		/*After Converting to String type, we are formatted to some pattern 
		 * and again converted to LocalDate*/
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today=LocalDate.parse(curdate,formatter);
		LocalDate sdate=LocalDate.parse(startdate,formatter);
		LocalDate cdate=LocalDate.parse(clsdate,formatter);
		
		/*Checking condition that curdate is within sdate and cdate*/
		if((today.isEqual(sdate)||today.isAfter(sdate)) && (today.isEqual(cdate)||today.isBefore(cdate)))
		{
			return new ResponseEntity<>("Tender can be applied", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Date is expired or Date is not yet started", HttpStatus.BAD_REQUEST);
		}
	}
}
