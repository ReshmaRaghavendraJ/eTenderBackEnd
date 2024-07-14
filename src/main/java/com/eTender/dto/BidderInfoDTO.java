package com.eTender.dto;

public class BidderInfoDTO 
{
	private int bidderid;
	private String address;
    private String bidderName;
    private String mobileno;
    
    public BidderInfoDTO(Integer bidderid,String address, String bidderName, String mobileno) 
    {
    	this.bidderid=bidderid;
        this.address = address;
        this.bidderName = bidderName;
        this.mobileno = mobileno;
    }
    
	public int getBidderid() 
	{
		return bidderid;
	}

	public void setBidderid(int bidderid) {
		this.bidderid = bidderid;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
}