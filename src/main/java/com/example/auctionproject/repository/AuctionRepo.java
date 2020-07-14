package com.example.auctionproject.repository;

import com.example.auctionproject.entity.AuctionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepo extends JpaRepository<AuctionModel, Integer> {
    AuctionModel findById(int id);
}
