package com.example.auctionproject.repository;

import com.example.auctionproject.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepo extends JpaRepository<AuditLog, Integer> {
}
