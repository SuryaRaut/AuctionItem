package com.example.auctionproject.service;

import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.exceptions.ReservePriceNotMetException;
import com.example.auctionproject.repository.AuctionRepo;
import com.example.auctionproject.repository.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidRepo bidRepo;
    @Autowired
    private AuctionRepo auctionRepo;

    @Autowired
    private AuditLogService logService;

    public String postBid(BidDTO bidDTO) throws ReservePriceNotMetException{
        // look up auction model entity for this bid, using passed in auction ID
        AuctionModel auctionModel = auctionRepo.findById(bidDTO.getAuctionID());
        double reservePrice = Double.parseDouble(auctionModel.getReservePrice());

        BidModel bidModel = new BidModel();
        bidModel.setAuctionModel(auctionModel);
        bidModel.setBidderName(bidDTO.getBidderName());
        bidModel.setMaxAutoBitAmount(bidDTO.getMaxAutoBidAmount());

        if (bidDTO.getMaxAutoBidAmount() <= reservePrice) {
            logService.log(bidModel, auctionModel, "Reserve price has not been met.");
            throw new ReservePriceNotMetException("Reserve price has not been met.");
        }

        bidRepo.save(bidModel);

        auctionModel.setCurrentBid(bidModel.getMaxAutoBitAmount() + "");
        auctionModel.setReservePrice(bidModel.getMaxAutoBitAmount() + "");
        auctionRepo.save(auctionModel);
        logService.log(bidModel, auctionModel, "Successfull");
        return "Successfull";
    }

    public BidModel getBid(int id){
        if(bidRepo.existsById(id)){
            return bidRepo.findById(id).get();
        }
        return null;
    }

    public List<BidModel> getAll(){
        return bidRepo.findAll();
    }

}
