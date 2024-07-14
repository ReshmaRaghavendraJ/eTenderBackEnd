package com.eTender.dto;

import java.sql.Date;

public class FeedbackInfoDTO 
{
	private Integer feedbackno;
	private String feedback;
	private Date feedbackDate;
	
	FeedbackInfoDTO(Integer feedbackno,String feedback,Date feedbackDate)
	{
		this.feedbackno=feedbackno;
        this.feedback = feedback;
        this.feedbackDate=feedbackDate;
	}
	
	public Integer getFeedbackno()
	{
		return feedbackno;
	}

	public void setFeedbackno(Integer feedbackno)
	{
		this.feedbackno = feedbackno;
	}

	public String getFeedback() 
	{
		return feedback;
	}

	public void setFeedback(String feedback) 
	{
		this.feedback = feedback;
	}

	public Date getFeedbackDate()
	{
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) 
	{
		this.feedbackDate = feedbackDate;
	}
}
