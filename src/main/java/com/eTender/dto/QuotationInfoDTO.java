package com.eTender.dto;

public class QuotationInfoDTO
{
	private Integer tenderQuotation;
	
	QuotationInfoDTO(Integer tenderQuotation)
	{
		this.tenderQuotation=tenderQuotation;
	}

	public int getTenderQuotation() 
	{
		return tenderQuotation;
	}

	public void setTenderQuotation(int tenderQuotation)
	{
		this.tenderQuotation = tenderQuotation;
	}	
}
