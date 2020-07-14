package com.example.auctionproject.service;

import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.repository.AuctionRepo;
import com.example.auctionproject.repository.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
    @Autowired
    private BidRepo bidRepo;
    @Autowired
    private AuctionRepo auctionRepo;

    public String postBid(BidDTO bidDTO){
        // look up auction model entity for this bid, using passed in auction ID
        AuctionModel auctionModel = auctionRepo.findById(bidDTO.getAuctionID());

        BidModel bidModel = new BidModel();
        bidModel.setAuctionModel(auctionModel);
        bidModel.setBidderName(bidDTO.getBidderName());
        bidModel.setMaxAutoBitAmount(bidDTO.getMaxAutoBidAmount());

        bidRepo.save(bidModel);

        return "Successfull";
    }

    public BidModel getBid(int id){
        if(bidRepo.existsById(id)){
            return bidRepo.findById(id).get();
        }
        return null;
    }

}
