package eTender.example.eTender.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eTender.dto.ClientInfoDTO;

import eTender.example.eTender.Entity.AddClientDetails;

public interface AddClientDetailsRepo extends JpaRepository<AddClientDetails,Integer>
{
	  @Query("SELECT new com.eTender.dto.ClientInfoDTO(cl.clientid,cl.clientPersonName,cl.address,cl.phoneno)"+
"FROM AddClientDetails cl WHERE cl.bidderregistration.bidderid= :bidderid")
	    List<ClientInfoDTO> findClientDetailsByBidderId(@Param("bidderid") Integer bidderid); 
}

