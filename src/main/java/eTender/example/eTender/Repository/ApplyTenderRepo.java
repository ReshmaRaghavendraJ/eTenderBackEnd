package eTender.example.eTender.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTender.dto.QuotationInfoDTO;

import eTender.example.eTender.Entity.ApplyTender;
import eTender.example.eTender.Entity.BidderRegistration;
import eTender.example.eTender.Entity.CreateTender;

public interface ApplyTenderRepo extends JpaRepository<ApplyTender,Integer>
{
	boolean existsByCreatetender1AndBidderregistration1(CreateTender createtender, BidderRegistration bidderregistration);

	//display Quotation
	@Query("SELECT new com.eTender.dto.QuotationInfoDTO(apl.tenderQuotation) FROM ApplyTender apl JOIN apl.bidderregistration1 br JOIN apl.createtender1 cr WHERE br.bidderid=:bidderid AND cr.Tenderid=:tenderid")
     List<QuotationInfoDTO>joinInfo(@Param("bidderid") Integer bidderid,@Param("tenderid") Integer tenderid);

	 @Query("SELECT apl FROM ApplyTender apl WHERE apl.createtender1.Tenderid = :tenderid AND apl.bidderregistration1.bidderid=:bidderid")
	    Optional<ApplyTender> findByTenderid(@Param("tenderid") Integer tenderid,@Param("bidderid") Integer bidderid);
}
