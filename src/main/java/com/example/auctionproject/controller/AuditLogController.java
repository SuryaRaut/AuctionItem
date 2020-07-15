package com.example.auctionproject.controller;

import com.example.auctionproject.entity.AuditLog;
import com.example.auctionproject.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditLogController {
    @Autowired
    private AuditLogService service;
    @GetMapping("/logs")
    public List<AuditLog> getAll(){
        return service.getAll();
    }
}
