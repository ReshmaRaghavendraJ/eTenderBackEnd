package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTender.dto.BidderInfoDTO;

import eTender.example.eTender.Entity.BidderRegistration;

public interface BidderRegistrationRepo extends JpaRepository<BidderRegistration, Integer> {
    @Query("SELECT new com.eTender.dto.BidderInfoDTO(br.bidderid,br.address, br.bidderName, br.mobileno) " +
           "FROM BidderRegistration br " +
           "INNER JOIN ApplyTender ap ON ap.bidderregistration1.bidderid = br.bidderid " +
           "WHERE ap.createtender1.Tenderid = :tenderid")
    List<BidderInfoDTO> findByTenderId(@Param("tenderid") Integer tenderid);
}