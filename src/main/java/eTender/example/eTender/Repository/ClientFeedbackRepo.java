package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTender.dto.FeedbackInfoDTO;

import eTender.example.eTender.Entity.ClientFeedback;

public interface ClientFeedbackRepo extends JpaRepository<ClientFeedback,Integer> 
{
	boolean existsByAddclientprojectwork_Projectno(Integer projectno);
	
	@Query("SELECT new com.eTender.dto.FeedbackInfoDTO(fb.feedbackno,fb.feedback,fb.feedbackDate) " +
	           "FROM ClientFeedback fb JOIN fb.addclientprojectwork pr WHERE pr.projectno=:projectno")
	    List<FeedbackInfoDTO> findByProjectNo(@Param("projectno") Integer projectno);
}
