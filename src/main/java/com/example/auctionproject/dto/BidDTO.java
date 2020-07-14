package com.example.auctionproject.dto;

public class BidDTO {
    private int bidId;
    private double maxAutoBidAmount;
    private String bidderName;
    private int auctionID;

    public BidDTO() {
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public double getMaxAutoBidAmount() {
        return maxAutoBidAmount;
    }

    public void setMaxAutoBidAmount(double maxAutoBidAmount) {
        this.maxAutoBidAmount = maxAutoBidAmount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

}
