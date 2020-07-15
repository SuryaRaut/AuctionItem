package com.example.auctionproject.service;

import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.AuditLog;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.repository.AuditLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {
    @Autowired
    AuditLogRepo auditLogRepo;
    public void log(BidModel bidModel, AuctionModel auction, String message){
        AuditLog auditLog = new AuditLog();
        auditLog.setAuctionId(auction.getAuctionId());
        auditLog.setCurrentBid(bidModel.getMaxAutoBitAmount() + "");
        auditLog.setReservePrice(auction.getReservePrice());
        auditLog.setMessage(message);
        auditLogRepo.save(auditLog);
    }

    public List<AuditLog> getAll(){
        return auditLogRepo.findAll();
    }

}
