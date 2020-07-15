package com.example.auctionproject.controller;

import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.exceptions.ReservePriceNotMetException;
import com.example.auctionproject.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bidAuction")
public class BidController {
    @Autowired
    private BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/postBid")
    public String postBid(@RequestBody BidDTO bidDTO){

        try {
            return bidService.postBid(bidDTO);
        } catch(ReservePriceNotMetException e) {
            return e.getMessage();
        }

    }

    @GetMapping("/getBid/{id}")
    public BidModel getBidDetails(@PathVariable int id){
        return bidService.getBid(id);
    }

    @GetMapping("/getBids")
    public List<BidModel> getBidDetails(){
        return bidService.getAll();
    }

}
