package com.example.auctionproject.repository;

import com.example.auctionproject.entity.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepo extends JpaRepository<BidModel, Integer> {
}
