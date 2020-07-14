package com.example.auctionproject.entity;

import javax.persistence.*;
@Entity
public class BidModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "auctionId",nullable = false, referencedColumnName = "auctionId")

    private Double maxAutoBitAmount;
    private String bidderName;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "auctionModel_auctionId",nullable = false)
    private AuctionModel auctionModel;

    public BidModel(){

    }
    public BidModel(int bidId, double maxAutoBitAmount, String bidderName) {
        this.bidId= bidId;
        this.maxAutoBitAmount = maxAutoBitAmount;
        this.bidderName= bidderName;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Double getMaxAutoBitAmount(){
        return maxAutoBitAmount;
    }
    public void setMaxAutoBitAmount(Double maxAutoBitAmount){
        this.maxAutoBitAmount= maxAutoBitAmount;
    }
    public AuctionModel getAuctionModel(){
        return auctionModel;

    }
    public void setAuctionModel(AuctionModel auctionModel){
        this.auctionModel= auctionModel;

    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

}
