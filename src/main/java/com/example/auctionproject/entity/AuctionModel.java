package com.example.auctionproject.entity;

import com.example.auctionproject.dto.AuctionDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AuctionModel {
    @Id
    @Column()
    private Integer auctionId;
    private String currentBid;
    private String reservePrice;

    public AuctionDTO  item;
    //    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy ="auction_items" )
    @OneToMany(mappedBy = "auctionModel")
    private Set<BidModel> bidModel = new HashSet<>();

    public AuctionModel(){
    }
    public AuctionModel(int auctionId, String currentBid, String reservePrice, AuctionDTO item){

        this.auctionId=auctionId;
        this.currentBid= currentBid;
        this.reservePrice = reservePrice;

        this.item = item;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(String currentBid) {
        this.currentBid = currentBid;
    }

    public String getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(String reservePrice) {
        this.reservePrice = reservePrice;
    }

    public AuctionDTO getItem() {
        return item;
    }

    public void setItem(AuctionDTO item) {
        this.item = item;
    }


}
